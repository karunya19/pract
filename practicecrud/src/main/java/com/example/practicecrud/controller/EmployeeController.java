package com.example.practicecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practicecrud.entity.EmployeeEntity;
import com.example.practicecrud.exception.ResourceNotFoundException;
import com.example.practicecrud.exception.ResponseNotFoundException;
import com.example.practicecrud.repository.EmployeeRepository;
import com.example.practicecrud.service.EmployeeService;

import antlr.collections.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
@Autowired
private EmployeeRepository repo;
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeEntity emp) {
		
		service.createEmployee(emp);
	
		return ResponseEntity.ok("employee created");
	}

	
	@GetMapping("/getemp/{name}")
	public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable String name) {
	EmployeeEntity entity = service.getEmployeeByName(name);
	if(entity==null) {
	throw new ResponseNotFoundException();
	}
	return ResponseEntity.ok(entity);
	}
	

	@GetMapping("/getemployee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
	EmployeeEntity employee =repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/")
	public java.util.List<EmployeeEntity> getAllUser(){
	return repo.findAll();
	}



	
	@PutMapping("/update/{name}")
	public EmployeeEntity updateEmp(@RequestBody EmployeeEntity ent,@PathVariable String name) {
	return service.updateByName(name,ent);	
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable Long id) {
		service.deleteById(id);
	}
	}