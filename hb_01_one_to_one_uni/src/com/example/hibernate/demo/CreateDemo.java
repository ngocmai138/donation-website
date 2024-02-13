package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		try {
			Instructor tempInstructor = new Instructor("Mary","Land","mary@code.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://youtune.com",
							"football");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
