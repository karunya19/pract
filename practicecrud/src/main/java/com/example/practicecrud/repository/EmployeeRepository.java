package com.example.practicecrud.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practicecrud.entity.EmployeeEntity;  
 
@Repository 

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>
{
EmployeeEntity findByName(String name);
EmployeeEntity findById(long id);

}

