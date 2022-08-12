package com.example.demohibernateapp.jdbc;

import com.example.demohibernateapp.entity.Instructor;
import com.example.demohibernateapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            Session session = factory.openSession();

            // Create objects
            Instructor instructor = new Instructor("Egor", "Gavriliuk", "test@gmail.com");
            InstructorDetail detail = new InstructorDetail("https://someyoutubechannel.com",
                    "Luv to code");

            // Assosiate objects
            instructor.setInstructorDetail(detail);

            session.beginTransaction();

            // Save (will cascade)
            session.save(instructor);

            session.getTransaction().commit();

        }
    }
}
