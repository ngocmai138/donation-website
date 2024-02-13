package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student= session.get(Student.class, 9);
			student.setFirstName("Scooby");
			session.getTransaction().commit();
			session.beginTransaction();
			Student myStu=session.get(Student.class, 9);
			session.getTransaction().commit();
			System.out.println(myStu);
		}
		finally {
			factory.close();
		}

	}

}
