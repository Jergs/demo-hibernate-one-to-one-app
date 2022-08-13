package com.example.demohibernateapp.jdbc;

import com.example.demohibernateapp.entity.Instructor;
import com.example.demohibernateapp.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            Session session = factory.openSession();
            session.beginTransaction();

            int id = 1;
            InstructorDetail detail = session.get(InstructorDetail.class, id);
            Instructor instructor = detail.getInstructor();
            System.out.println(instructor.getFirstName() + " " + instructor.getLastName());

            session.getTransaction().commit();
        }
    }
}
