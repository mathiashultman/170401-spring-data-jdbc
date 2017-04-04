package biz.mathias.service;

import org.springframework.beans.factory.annotation.Autowired;

import biz.mathias.repository.EmployeeRepository;

public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
}
