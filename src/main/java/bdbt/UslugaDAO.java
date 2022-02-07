package bdbt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UslugaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor */

	public UslugaDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Usluga> list() {

		String sql = "SELECT * FROM USLUGI";
		List<Usluga> listUsluga = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usluga.class));
		return listUsluga;
	}

	/* (C)reate */
	public void save(Usluga usluga) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("uslugi").usingColumns("nazwa", "opis", "data_od", "data_do", "cena",
				"nr_punktu_sprzedazy");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
		insertActor.execute(param);
	}

	/* (R)ead */
	public Usluga get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM USLUGI WHERE nr_uslugi = " + args[0];
		Usluga usluga = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Usluga.class));
		return usluga;
	}

	/* (U)pdate */
	public void update(Usluga usluga) {
		String sql = "UPDATE USLUGI SET nazwa=:nazwa, opis=:opis, data_od=:data_od, data_do=:data_do, cena=:cena, nr_punktu_sprzedazy=:nr_punktu_sprzedazy, nr_klienta=:nr_klienta WHERE nr_uslugi=:nr_uslugi";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int nr_uslugi) {

		String sql = "DELETE FROM USLUGI WHERE nr_uslugi = ?";
		jdbcTemplate.update(sql, nr_uslugi);

	}
}
