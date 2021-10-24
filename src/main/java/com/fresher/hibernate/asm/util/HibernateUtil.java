package com.fresher.hibernate.asm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory FACTORY;
	
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		FACTORY = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
}
