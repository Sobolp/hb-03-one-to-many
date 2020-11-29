package com.example.hibernatetutorial.demo;

import com.example.hibernatetutorial.entity.Instructor;
import com.example.hibernatetutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Chad", "Darby", "darby@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.luv2code.com/youtube",
                    "Luv 2 code!!!");
/*
            Instructor instructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.youtube.com",
                    "Guitar");
*/

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
