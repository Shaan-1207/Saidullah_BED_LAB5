package org.greatlearning.ems.service;

import java.util.List;
import java.util.Optional;

import org.greatlearning.ems.entity.Employee;
import org.greatlearning.ems.repositary.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements ServiceInterface {

	@Autowired
	private EmployeeRepositary employeeRepositary;

	//Adding the employees
	public void addEmployee(Employee e) {
		employeeRepositary.save(e);
	}

	//Fetch employee data
	public List<Employee> getAllEmployees() {
		return employeeRepositary.findAll();
	}

	//Get employee by id
	public Employee getEmpLoyeeById(int id) {
		Optional<Employee> emp = employeeRepositary.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

	// deleting employee
	public void delete(int id) {
		employeeRepositary.deleteById(id);
	}

}
