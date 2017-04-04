package biz.mathias.main;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import biz.mathias.domain.EmployeeImpl;
import biz.mathias.domain.EmployeeMapper;

public class Main {

	public static void main(String[] args) {
		new Main().go();
	}

	public void go() {
		ApplicationContext context = new AnnotationConfigApplicationContext(biz.mathias.config.SpringJdbcConfig.class);
		DataSource dataSource = context.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		String insertSql = "insert into Employee (id,name,role) values (:id,:name,:role)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("id", 14);
		namedParameters.put("name", "mittNamn");
		namedParameters.put("role", "roll");
		// namedParameterJdbcTemplate.update(insertSql, namedParameters);

		String insertSql2 = "insert into Employee (id,name,role) values (?,?,?)";
		// jdbcTemplate.update(insertSql2,5,"hej","hej");
		String deleteSql = "delete from Employee where id=?";
		// jdbcTemplate.update(deleteSql,3);
		String getSql1 = "select count(*) from Employee";
		System.out.println(jdbcTemplate.queryForObject(getSql1, Integer.class));
		String getSql2 = "select * from Employee";
		System.out.println(jdbcTemplate.queryForList(getSql2));
		String getSql3 = "select name from Employee where id=?";
		System.out.println(jdbcTemplate.queryForObject(getSql3, new Object[] { 4 }, String.class));
		String getSql4 = "select * from Employee where id=?";
		System.out.println(jdbcTemplate.queryForObject(getSql4, new Object[] { 4 }, new EmployeeMapper()));
	}
}
