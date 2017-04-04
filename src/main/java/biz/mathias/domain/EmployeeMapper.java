package biz.mathias.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<EmployeeImpl>{

	public EmployeeImpl mapRow(ResultSet rs, int rowIndex) throws SQLException {
		EmployeeImpl employee=new EmployeeImpl();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setRole(rs.getString("role"));
		return employee;
	}

}
