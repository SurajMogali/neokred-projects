package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Employee;
import com.demo.spring.service.EmpService;

import io.swagger.v3.oas.models.annotations.OpenAPI30;

@RestController
@RequestMapping(path = "/employees")
@OpenAPI30
public class EmpController {

	@Autowired
	private EmpService empService;

	@PostMapping("/save")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.createEmployee(employee);
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/get/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable Integer empId) {
		return empService.getEmployeeById(empId);
	}

	@PutMapping("/update")
	public Employee updateEmployee( @RequestBody Employee updatedEmployee)
			throws NotFoundException {
		return empService.updatedEmployee( updatedEmployee);
	}

	@DeleteMapping("/delete/{empId}")
	public void deleteEmployee(@PathVariable Integer empId) throws NotFoundException {

		empService.deleteEmployee(empId);

	}
}
