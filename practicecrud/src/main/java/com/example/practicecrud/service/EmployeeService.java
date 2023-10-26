package com.example.practicecrud.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.example.practicecrud.entity.EmployeeEntity;
import com.example.practicecrud.repository.EmployeeRepository;  
 

@Service  
public class EmployeeService   
{  
@Autowired  
private EmployeeRepository repo;

public EmployeeEntity createEmployee(EmployeeEntity emp) {
	emp=repo.save(emp);
	return emp;
}

public EmployeeEntity getEmployeeByName(String name) {
	return repo.findByName(name);
}

public List<EmployeeEntity> getAllUsers() {
	
	return repo.findAll();
}

public EmployeeEntity updateByName(String name, EmployeeEntity newdata) {
	
	EmployeeEntity old=repo.findByName(name);
	old.setAge(newdata.getAge());
	old.setName(newdata.getName());
	old.setPassword(newdata.getPassword());
	old.setEmail(newdata.getEmail());
	repo.save(old);
	return old;
}

public void deleteById(Long id) {
	// TODO Auto-generated method stub
	EmployeeEntity entit=repo.getById(id);
	repo.delete(entit);
}


}