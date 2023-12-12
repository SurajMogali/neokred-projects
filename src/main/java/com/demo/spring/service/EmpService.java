package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Employee;
import com.demo.spring.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	EmpRepository empRepository;

	public Employee createEmployee(Employee e) {
		return empRepository.save(e);
	}

	public List<Employee> getAllEmployees() {
		return empRepository.findAll();

	}

	public Optional<Employee> getEmployeeById(Integer empId) {
		return empRepository.findById(empId);
	}

	public Employee updatedEmployee(Employee e) throws NotFoundException {
//		Optional<Employee> empOp = empRepository.findById(updatedEmployee.getEmpId());

		if (empRepository.existsById(e.getEmpId()))
		{
//		empOp.get().setEmpFirstName(updatedEmployee.getEmpFirstName());	

			Employee emp = empRepository.save(e);
			System.out.println(emp);
			return emp;
		} else {
			return null;
		}

	}

	public void deleteEmployee(Integer empId) throws NotFoundException {

		empRepository.deleteById(empId);

	}

}
