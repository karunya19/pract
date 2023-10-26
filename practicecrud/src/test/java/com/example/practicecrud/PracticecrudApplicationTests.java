package com.example.practicecrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.practicecrud.entity.EmployeeEntity;
import com.example.practicecrud.repository.EmployeeRepository;
import com.example.practicecrud.service.EmployeeService;

@SpringBootTest

class PracticecrudApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
	
	
	


	@Autowired
	EmployeeRepository repo;
	@Autowired
	EmployeeService service;

	@Test
	@Order(1)
	public void testCreate() {
	EmployeeEntity e=new EmployeeEntity();
	e.setAge(12);
	e.setEmail("karu@gmail.com");
	e.setName("karu");
	e.setPassword("456");
	EmployeeEntity storedValue=repo.save(e);
	EmployeeEntity ea=repo.findById(storedValue.getId());
	assertEquals(ea.getAge(),e.getAge());



	}

	@Test
	@Order(2)
	public void testReadAll(){
	List<EmployeeEntity> list=repo.findAll();
	int size=list.size();
	assertTrue(size>0);

	}




//	@Test
//	@Order(3)
//	public void testUpdate() {
//	EmployeeEntity e=new EmployeeEntity();
//	e.setAge(12);
//	e.setName("namu");
//	e.setPassword("123456");
//	e.setEmail("namu@gmail.com");
//	//EmployeeEntity storedValue=repo.save(e);
//	EmployeeEntity ent=service.updateByName(e.getName(),e);
//	assertEquals(e.getAge(),ent.getAge());
//	System.out.println(ent);
//	}


	
//	@Test
//	@Order(4)
//	public void testDelete() {
//		EmployeeEntity e=new EmployeeEntity();
//		e.setAge(12);
//		e.setEmail("karu12345om");
//		e.setName("india");
//		e.setPassword("4567");
//		EmployeeEntity storedValue=repo.save(e);
//		
//	System.out.println("pass"+storedValue.getPassword()+""+storedValue.getName());
//	repo.deleteById(storedValue.getId());
//	Boolean ent=repo.findById(storedValue.getId()).isPresent();
//	
//	System.out.println(ent);
//	assertFalse(ent);
	//}
	
//	@Test
//	@Order(4)
//	public void tetDelete() {
//			   repo.deleteById(11L);
//			   boolean st = repo.findById(11L).isPresent();
//			   assertFalse(st);
//	}

	
	@Test
	// @Order(3)
	public void testUpdate() {
	EmployeeEntity e=new EmployeeEntity();
	e.setAge(12);
	e.setName("karunuya");
	e.setPassword("567");
	e.setEmail("karu123@gmail.com");
	//EmployeeEntity storedValue=repo.save(e);
	EmployeeEntity ent=service.updateByName(e.getName(),e);
	assertEquals(e.getAge(),ent.getAge());
	System.out.println(ent);
	}
	@Test
	// @Order(4)
	public void testDelete() {
	EmployeeEntity e=new EmployeeEntity();
	e.setAge(20);
	e.setEmail("vishal@gmail.com");
	e.setName("vishal");
	e.setPassword("609");
	EmployeeEntity storedValue=repo.save(e);
	repo.deleteById(storedValue.getId());
	Boolean ent=repo.findById(storedValue.getId()).isPresent();
	System.out.println(ent);
	assertFalse(ent);
	}





	}

