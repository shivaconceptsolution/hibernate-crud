package scs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Showrecord {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Stu s");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Stu s =(Stu)it.next();
			System.out.println(s.getRno() + " "+s.getSname());
		}
		session.close();

	}

}
