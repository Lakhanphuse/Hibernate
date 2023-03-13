package demo;

import domain.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AcceptIdFromUserAndUpdateStream {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student id");
        int id = sc.nextInt();
        Student s = new Student();
        s.getStudId(id);
        System.out.println("Enter the updated Stream");
        String stream = sc.next();
        s.setStudStream(stream);

        Configuration cfg ;
        SessionFactory factory ;
        Session ses;
        Transaction tx;



        cfg= new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();
        tx =ses.beginTransaction();
       Query q = ses.createQuery("update Student s set s.studStream=:n where id=:id");
       q.setParameter("n",stream);
       q.setParameter("id",id);
       int count = q.executeUpdate();
        System.out.println(count+" Stream Updated Successfully");
        tx.commit();






    }
}


