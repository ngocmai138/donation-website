package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

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
			Course course1 = new Course("How to Live");
			Course course2 = new Course("How to be Peace");
			instructor.add(course1);
			instructor.add(course2);
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
