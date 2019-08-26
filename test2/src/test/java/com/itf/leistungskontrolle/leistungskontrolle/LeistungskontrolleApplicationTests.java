package com.itf.leistungskontrolle.leistungskontrolle;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LeistungskontrolleApplicationTests {
	
	

	@LocalServerPort
	private int port;
	
	@Before
	public void setUp() throws Exception {
	    RestAssured.port = port;
	}
	
	@Test
	public void getEmployees_returns200() {
		Response response = RestAssured.get("http://localhost:"+port+"/api/employees").andReturn();
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void addEmployee_validEmployee_returns201() {
		Map<String, String> employee = new HashMap<>();
		employee.put("name", "Test Employee");
		employee.put("salary", "10000");
		employee.put("department", "IT");
		Response response = RestAssured.given()
				.contentType("application/json")
				.body(employee)
				.post("http://localhost:"+port+"/api/employees");
		Assert.assertEquals(201, response.getStatusCode());
	}
	
	@Test
	public void addEmployee_negativeSalary_returns400() {
		Map<String, String> employee = new HashMap<>();
		employee.put("name", "Test Employee");
		employee.put("salary", "-10000");
		employee.put("department", "IT");
		Response response = RestAssured.given()
				.contentType("application/json")
				.body(employee)
				.post("http://localhost:"+port+"/api/employees");
		Assert.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void addEmployee_blankName_returns400() {
		Map<String, String> employee = new HashMap<>();
		employee.put("name", "");
		employee.put("salary", "10000");
		employee.put("department", "IT");
		Response response = RestAssured.given()
				.contentType("application/json")
				.body(employee)
				.post("http://localhost:"+port+"/api/employees");
		Assert.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void addEmployee_blankDepartment_returns400() {
		Map<String, String> employee = new HashMap<>();
		employee.put("name", "Test Employee");
		employee.put("salary", "10000");
		employee.put("department", "");
		Response response = RestAssured.given()
				.contentType("application/json")
				.body(employee)
				.post("http://localhost:"+port+"/api/employees");
		Assert.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void findEmployeebyId_returnsEmployee() {
		Map<String, String> employee = new HashMap<>();
		employee.put("name", "Test Employee");
		employee.put("salary", "10000");
		employee.put("department", "IT");
		RestAssured.given()
				.contentType("application/json")
				.body(employee)
				.post("http://localhost:"+port+"/api/employees");
		Response allEmployees = RestAssured.get("http://localhost:"+port+"/api/employees").andReturn();
		Response response = RestAssured.get("http://localhost:"+port+"/api/employees/{id}", allEmployees.jsonPath().getString("empId[0]"));
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals(allEmployees.jsonPath().getString("name[0]"), response.jsonPath().getString("name"));
	}
	


}
