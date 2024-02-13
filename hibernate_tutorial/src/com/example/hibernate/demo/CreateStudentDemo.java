package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Create new student object....");
			Student studentTemp= new Student("Mary","Land","mary@code.mail");
			session.beginTransaction();
			System.out.println("Saving the student....");
			session.save(studentTemp);
			session.getTransaction().commit();
			System.out.print("done!");
		}
		finally {
			factory.close();
		}
	}

}

