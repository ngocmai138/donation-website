package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student stu1 = new Student("scooby","john","scooby@mail.code");
			Student stu2 = new Student("happy","cry","happy@code.mail");
			Course course1 = session.get(Course.class, 1);
			Course course2 = session.get(Course.class, 2);
			course1.addStudent(stu1);
			course2.addStudent(stu1);
			course2.addStudent(stu2);
			session.save(course1);
			session.save(course2);
			session.save(stu1);
			session.save(stu2);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
