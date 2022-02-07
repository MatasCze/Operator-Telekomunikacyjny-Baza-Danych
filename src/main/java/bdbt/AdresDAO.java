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
public class AdresDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor */

	public AdresDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Adres> list() {

		String sql = "SELECT * FROM ADRESY";
		List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
		return listAdres;
	}

	/* (C)reate */
	public void save(Adres adres) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("adresy").usingColumns("miasto", "ulica", "nr_lokalu", "kod_pocztowy", "poczta");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
		insertActor.execute(param);
	}

	/* (R)ead */
	public Adres get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM ADRESY WHERE nr_adresu = " + args[0];
		Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
		return adres;
	}

	/* (U)pdate */
	public void update(Adres adres) {
		String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_lokalu=:nr_lokalu, kod_pocztowy=:kod_pocztowy, poczta=:poczta WHERE nr_adresu=:nr_adresu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int nr_adresu) {

		String sql = "DELETE FROM ADRESY WHERE nr_adresu = ?";
		jdbcTemplate.update(sql, nr_adresu);

	}
}
