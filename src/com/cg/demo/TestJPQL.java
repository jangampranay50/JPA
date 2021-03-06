package com.cg.demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Employee;

public class TestJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Low Salry : ");
		double lowSalary = scanner.nextDouble();
		System.out.println("Enter High Salary : ");
		double highSalary = scanner.nextDouble();
		
		String qry = "select e from Employee e where employeeSalary>=? and employeeSalary<=?";
		
		TypedQuery<Employee> query = entityManager.createQuery(qry,Employee.class);
		
		query.setParameter(1,  lowSalary);
		query.setParameter(2, highSalary);
		
		List<Employee> list = query.getResultList();
		
		for(Employee employee : list)
		{
			System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getEmployeeSalary());
		}
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
