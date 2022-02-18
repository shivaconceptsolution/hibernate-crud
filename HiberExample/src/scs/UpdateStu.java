package scs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStu {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Object o = session.get(Stu.class,new Integer(1001));
		Stu s = (Stu)o;
		s.setSname("Ram kumar Sharma");
		session.update(s);
		tx.commit();
		session.close();

	}

}
