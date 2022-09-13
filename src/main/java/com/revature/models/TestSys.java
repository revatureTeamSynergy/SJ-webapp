package com.revature.models;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.repository.Manager;

public class TestSys {
	
//	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
//			.createEntityManagerFactory("postgres");

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		  
	      
	     Customer s = Manager.get(2, Customer.class);
		System.out.println(s.getFirstName().getValue());

	}

}
