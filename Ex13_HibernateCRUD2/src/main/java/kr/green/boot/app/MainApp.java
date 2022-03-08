package kr.green.boot.app;

import org.hibernate.Session;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
	}
}
