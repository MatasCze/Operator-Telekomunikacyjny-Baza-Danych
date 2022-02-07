package bdbt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class OperatorzyDAOTest {
	
	private OperatorzyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
		datasource.setUsername("mczepla");
		datasource.setPassword("mczepla");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new OperatorzyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {

		List<Operatorzy> listOperatorzy = dao.list();
		assertTrue(!listOperatorzy.isEmpty());
	}

	@Test
	void testSave() {
		Operatorzy operatorzy = new Operatorzy(0, "Orange", "2021-01-23", 6);
		dao.save(operatorzy);
	}

	@Test
	void testGet() {
		int id = 24;
		Operatorzy operatorzy = dao.get(id);
		
		assertNotNull(operatorzy);
	}

	@Test
	void testUpdate() {
		Operatorzy operatorzy = new Operatorzy();
		operatorzy.setNr_operatora(29);
		operatorzy.setNazwa("Netia2");
		operatorzy.setData_zalozenia("24-01-2020");
		operatorzy.setNr_adresu(7);
		
		dao.update(operatorzy);
		
	}

	
	@Test
	void testDelete() {
		int nr_operatora = 29;
		dao.delete(nr_operatora);
	}

}
