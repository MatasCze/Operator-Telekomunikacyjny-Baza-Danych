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
public class KlientDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor */

	public KlientDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Klient> list() {

		String sql = "SELECT * FROM KLIENCI";
		List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
		return listKlient;
	}

	/* (C)reate */
	public void save(Klient klient) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("klienci").usingColumns("imie", "nazwisko", "data_urodzenia", "plec", "pesel",
				"nr_telefonu", "nr_operatora", "nr_adresu");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
		insertActor.execute(param);
	}

	/* (R)ead */
	public Klient get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM KLIENCI WHERE nr_klienta = " + args[0];
		Klient klient = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
		return klient;
	}

	/* (U)pdate */
	public void update(Klient klient) {
		String sql = "UPDATE KLIENCI SET imie=:imie, nazwisko =:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel, nr_telefonu=:nr_telefonu, nr_operatora=:nr_operatora, nr_adresu=:nr_adresu WHERE nr_klienta=:nr_klienta";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int nr_klienta) {

		String sql = "DELETE FROM KLIENCI WHERE nr_klienta = ?";
		jdbcTemplate.update(sql, nr_klienta);

	}
}
