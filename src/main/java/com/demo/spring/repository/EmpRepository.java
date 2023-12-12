package com.demo.spring.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.spring.entity.Employee;

public interface EmpRepository extends MongoRepository<Employee, Integer>
{
	Employee findByEmpFirstName(String firstName);
	
	@org.springframework.cache.annotation.Cacheable(value="firstName")
	default Employee myTest(String firstName) {
		System.out.println("Cache is working");
		return findByEmpFirstName(firstName);
	}

	@CacheEvict(value="firstName",allEntries = true)
	@Override
	 <S extends Employee> S save(S entity);
	
	
	
	

	

	

	
	
	
	
	
}