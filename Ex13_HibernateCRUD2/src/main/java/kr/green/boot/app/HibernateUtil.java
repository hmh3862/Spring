package kr.green.boot.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
