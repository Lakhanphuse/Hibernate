package demo;

import domain.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;


import java.util.Iterator;

public class DisplayNameAndPercentGreterThan60 {

    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria c2 = ses.createCriteria(Student.class);
        c2.add(Restrictions.gt("studPercent",60.0));
        ProjectionList plist = Projections.projectionList();

        plist.add(Projections.property("studName"));
        plist.add(Projections.property("studPercent"));
        c2.setProjection(plist);


        Iterator itr = c2.list().iterator();

        while(itr.hasNext()){
            Object[] arr = (Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]);
        }


    }
}
