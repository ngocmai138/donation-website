package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("List of students:");
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudent(students);
			System.out.println("\nList of students have last name contains 'Duck'");
			students=session.createQuery("from Student s where s.lastName like '%Duck%'").getResultList();
			displayStudent(students);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> students) {
		for(Student student:students) {
			System.out.println(student);
		}
	}

}
