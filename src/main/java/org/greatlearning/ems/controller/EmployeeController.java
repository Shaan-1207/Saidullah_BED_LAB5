package org.greatlearning.ems.controller;

import java.util.List;

import org.greatlearning.ems.entity.Employee;
import org.greatlearning.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeController {

	// Autowiring the service class
	@Autowired
	private EmployeeService employeeService;

	// getting all the employees
	@GetMapping("/employees")
	public String mainPage(Model theModel) {

		List<Employee> emp = employeeService.getAllEmployees();
		theModel.addAttribute("emp", emp);
		return "index";
	}

	// Navigating to create employee
	@GetMapping("/new")
	public String addEmployeePage() {
		return "addEmployee";
	}

	// Adding new employee
	@PostMapping("/addEmp")
	public String newEmployee(@ModelAttribute Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}

	// Editing and updating the employee
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model theModel) {
		Employee e = employeeService.getEmpLoyeeById(id);
		theModel.addAttribute("e", e);
		return "editEmployee";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/employees";

	}

	// deleting the employee
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, Model theModel) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
}
