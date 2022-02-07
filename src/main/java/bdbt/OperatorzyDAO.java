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
public class OperatorzyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor */

	public OperatorzyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List for data from database */
	public List<Operatorzy> list() {

		String sql = "SELECT * FROM OPERATORZY";
		List<Operatorzy> listOperatorzy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Operatorzy.class));
		return listOperatorzy;
	}

	/* (C)reate */
	public void save(Operatorzy operatorzy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("operatorzy").usingColumns("nazwa", "data_zalozenia", "nr_adresu");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(operatorzy);
		insertActor.execute(param);
	}

	/* (R)ead */
	public Operatorzy get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM OPERATORZY WHERE nr_operatora = " + args[0];
		Operatorzy operatorzy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Operatorzy.class));
		return operatorzy;
	}

	/* (U)pdate */
	public void update(Operatorzy operatorzy) {
		String sql = "UPDATE OPERATORZY SET nazwa=:nazwa, data_zalozenia=:data_zalozenia, nr_adresu=:nr_adresu WHERE nr_operatora=:nr_operatora";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(operatorzy);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete */
	public void delete(int nr_operatora) {
		
		String sql = "DELETE FROM OPERATORZY WHERE nr_operatora = ?";
		jdbcTemplate.update(sql, nr_operatora);

	}
}
