package demo;

import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertStudent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student Name");
        String name = sc.next();
        System.out.println("Enter Student Percent");
        double percent = sc.nextDouble();
        System.out.println("Enter Student Stream");
        String stream = sc.next();



        Configuration cfg;
        Session ses;
        SessionFactory factory;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();
        tx= ses.beginTransaction();

        Student s = new Student();

        s.setStudName(name);
        s.setStudPercent(percent);
        s.setStudStream(stream);
        ses.save(s);
        tx.commit();

        System.out.println("Student Details Inserted Successfully");





    }


}
