package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("create student...");
			Student tempStu = new Student("Daffy3","Duck3","daffy3@code.mail");
			session.beginTransaction();
			session.save(tempStu);
			session.getTransaction().commit();
			System.out.println("Student id: "+tempStu.getId());
			System.out.println("Done!");
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nReading student.....");
			Student myStu = session.get(Student.class, tempStu.getId());
			session.getTransaction().commit();
			System.out.println(myStu);
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}
