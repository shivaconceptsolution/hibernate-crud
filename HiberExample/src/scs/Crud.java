package scs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud {
	static Configuration cfg;
	static SessionFactory sf ;
	static Session session;
	static void connection()
	{
		cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
	}
	static void selectRecord()
	{
		Query q = session.createQuery("from Stu s");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			Stu s =(Stu)it.next();
			System.out.println(s.getRno() + " "+s.getSname());
		}
		
	}
	static void insertRecord(int rno,String sname)
	{
		Transaction tx = session.beginTransaction();
		Stu s = new Stu();
		s.setRno(rno);
		s.setSname(sname);
		session.save(s);
		tx.commit();
		
	}
	static void deleteRecord(int rno)
	{
		Transaction tx = session.beginTransaction();
		Object o = session.get(Stu.class,new Integer(rno));
		Stu s = (Stu)o;
		
		session.delete(s);
		tx.commit();
	}
	static void updaterecord(int rno,String sname)
	{
		Transaction tx = session.beginTransaction();
		Object o = session.get(Stu.class,new Integer(rno));
		Stu s = (Stu)o;
		s.setSname(sname);
		session.update(s);
		tx.commit();
	}
	static void closeconn()
	{
		session.close();
	}
	public static void main(String[] args) {
		connection();
		//insertRecord(105,"xyz");
		//updaterecord(102, "abc");
		deleteRecord(102);
	   // selectRecord();
	    
	    closeconn();
		

	}

}
