package com.itf.leistungskontrolle.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itf.leistungskontrolle.entity.Employee;
import com.itf.leistungskontrolle.repository.EmployeeRepository;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeerepository;
		
	
		
		@GetMapping("/helloworld")
		public String helloWorld() {
			return "helloworld";
		}
		
		@GetMapping("/employees")
		public ResponseEntity<Iterable<Employee>> getEmployees() {
			return new ResponseEntity<Iterable<Employee>>(employeerepository.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
			Optional<Employee> optEmployee = employeerepository.findById(id);
			if(optEmployee.isPresent()) {
				return new ResponseEntity<Employee>(optEmployee.get(),HttpStatus.OK);
			}else
				return ResponseEntity.notFound().build();
		}
		
		@PostMapping("/employees")
		public ResponseEntity<Employee> createNewEmployee(@Valid @RequestBody Employee employee){
			employee.setEmpId(null);
			employeerepository.save(employee);
			return new ResponseEntity<Employee>(HttpStatus.CREATED);
		}
		
	}