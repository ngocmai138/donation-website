package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor instructor = new Instructor("angry","bird","angry@code.mail");
			InstructorDetail detail = new InstructorDetail("http://bird.com","shout");
			instructor.setInstructorDetail(detail);
			session.save(instructor);
			session.getTransaction().commit();
			System.out.println("Done create instructor");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
