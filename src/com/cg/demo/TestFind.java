package com.cg.demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Employee;

public class TestFind {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Id To Search : ");
		int employeeId = scanner.nextInt();
		Employee employee = entityManager.find(Employee.class, employeeId);
		
		if(employee != null)
		{
			System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getEmployeeSalary());
		}
		else
		{
			System.err.println(employeeId+" NOT FOUND");
		}
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
