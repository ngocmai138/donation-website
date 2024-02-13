package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("Instructor: "+instructor);
			System.out.println("Course: "+instructor.getCourses());
			session.getTransaction().commit();
			session.close();
			System.out.println("Course: "+instructor.getCourses());
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
