package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
										+ "join fetch i.courses "
										+ "where i.id=:theInstructorId",
					Instructor.class);
			query.setParameter("theInstructorId", 1);
			Instructor instructor = query.getSingleResult();
			System.out.println("The instructor: "+instructor);
			System.out.println("The course: "+instructor.getCourses());
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
