package com.cg.demo;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Employee;

public class TestLifeCycle {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = null;
		
		entityManager.getTransaction().begin();
		
		employee = entityManager.find(Employee.class, 5061);
		
		entityManager.remove(employee);
		
		employee.setEmployeeName("Ajay");
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("Employee Object Saved Into DataBase");
		System.out.println("Employee Id generated ="+employee.getEmployeeId());
		

	}

}
