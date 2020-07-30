package com.cg.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "emp_tbl")
@NamedQuery(name="findEmployeeBySalary",query="select e from Employee e where employeeSalary>=:low and employeeSalary<=:high")
public class Employee {
	
	@Id
	@Column(name="empid")
	@GeneratedValue(generator="seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="employee_seq",allocationSize=1)
	private int employeeId;
	
	@Column(name="empname",length=15)
	//@Transient
	private String employeeName;
	
	@Column(name="empsal")
	private double employeeSalary;
	
	@Column(name="empdoj")
	@Temporal(TemporalType.DATE)
	private Date employeeDoj;

	public Employee(int employeeId, String employeeName, double employeeSalary, Date employeeDoj) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeDoj = employeeDoj;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Date getEmployeeDoj() {
		return employeeDoj;
	}

	public void setEmployeeDoj(Date employeeDoj) {
		this.employeeDoj = employeeDoj;
	}
	
}
