package com.cg.demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Employee;

public class TestUpdate {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Id To Update : ");
		int employeeId = scanner.nextInt();
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		
		if(employee != null)
		{
			System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getEmployeeSalary());
			System.out.println("Enter new Salary to Update : ");
			double salary = scanner.nextDouble();
			employee.setEmployeeSalary(salary);
			entityManager.merge(employee);
			System.out.println("Employee Salary Updated");
		}
		else
		{
			System.err.println(employeeId+" NOT FOUND");
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
