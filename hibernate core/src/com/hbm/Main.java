package com.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {
    try {
        StandardServiceRegistry config = new StandardServiceRegistryBuilder().configure("config.cfg.xml").build();

        Metadata meta = new MetadataSources(config).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setName("Rakib Hossain");
        student.setRoll(916);
        student.setEmail("webfil303@gmail.com");

        session.save(student);
        tx.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }catch (Exception e)  { e.printStackTrace(); }

    }
}
