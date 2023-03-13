package demo;

import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AcceptStreamAndDisplayAllStudent {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Stream");
        Student s = new Student();
        String stream = sc.next();
        s.getStudStream(stream);

        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria c = ses.createCriteria(Student.class);
        c.add(Restrictions.eq("studStream",stream));
        List<Student> slist = c.list();


        for(Student s1:slist){
            System.out.println(s1);
        }

    }
}
