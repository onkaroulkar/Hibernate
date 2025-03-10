package com.onkar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;


public class main {
    public static void main(String[] args) {

        Laptop lap1 = new Laptop();
        lap1.setId(1);
        lap1.setColour("black");
        lap1.setRam(16);
        lap1.setModelName("Apple");

        Laptop lap2 = new Laptop();
        lap2.setId(2);
        lap2.setColour("silver");
        lap2.setRam(32);
        lap2.setModelName("Dell");

        Laptop lap3 = new Laptop();
        lap3.setId(3);
        lap3.setColour("black");
        lap3.setRam(16);
        lap3.setModelName("Apple");

        Alien a1 = new Alien();
        a1.setAid(127);
        a1.setAname("Nishi");
        a1.setTech("Python");

        Alien a2 = new Alien();
        a2.setAid(128);
        a2.setAname("Subha");
        a2.setTech("Java");

        Alien a3= new Alien();
        a3.setAid(129);
        a3.setAname("Onkar");
        a3.setTech("JavaScript");

        lap1.setAlien(Arrays.asList(a1,a2));
        lap2.setAlien(Arrays.asList(a1,a3));
        lap3.setAlien(Arrays.asList(a1,a2,a3));

        a1.setLaptop(Arrays.asList(lap1,lap2));
        a2.setLaptop(Arrays.asList(lap1,lap3));
        a3.setLaptop(Arrays.asList(lap1,lap2,lap3));



        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.onkar.Alien.class).
        addAnnotatedClass(com.onkar.Laptop.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();

      // Alien a2 = session.get(Alien.class,124);


        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        session.persist(lap1);
        session.persist(lap2);
        session.persist(lap3);

        transaction.commit();
        session.close();
       // System.out.println(a1);
    }
}
