package com.itf.leistungskontrolle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name="name")
	@NotEmpty
	private String name;
	
	@Column(name="department")
	@NotEmpty
	private String department;
	
	@Column(name="salary")
	@DecimalMin("0")
	private Long salary;
	
}

