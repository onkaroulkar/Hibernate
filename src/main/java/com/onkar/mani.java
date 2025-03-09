package com.onkar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class mani {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        a1.setAid(123);
        a1.setAname("Subha");
        a1.setTech("Java");


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.onkar.Alien.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction = session.beginTransaction();
        session.merge(a1);

        transaction.commit();
        session.close();
        System.out.println(a1);
    }
}
