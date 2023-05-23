package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	//Add Employee
	public void addEmp(Employee e) {
		empRepo.save(e);
	}
	
	//Show in Table
	public List<Employee> getAllEmp(){
		return empRepo.findAll();		 
	}
	
	//Edit Employee
	public Employee getEmpById(int id)
	{
		Optional<Employee> e = empRepo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	// delete Employee
	
	public void deleteEmp(int id)
	{
		empRepo.deleteById(id);
	}
}
