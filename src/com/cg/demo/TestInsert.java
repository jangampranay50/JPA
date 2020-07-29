package com.cg.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Employee;

public class TestInsert {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee(0,"Akash",78000);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("Employee Object Saved Into DataBase");
		System.out.println("Employee Id generated ="+employee.getEmployeeId());
		
	}

}
