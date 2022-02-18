package scs;
import org.hibernate.cfg.*;
import org.hibernate.*;
public class Hello {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Stu s = new Stu();
		s.setRno(1002);
		s.setSname("Jay");
		session.save(s);
		tx.commit();
		session.close();

	}

}
