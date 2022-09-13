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
		
//		 Configuration configuration = new Configuration();
//	        configuration.configure("hibernate.cfg.xml");
//	        
//	        
//	        SessionFactory factory = configuration.buildSessionFactory();
//	    
//	        
//	        Session session = HibernateUtil.getSession();
//
//	        Transaction tx = session.beginTransaction();
		
		
//		Database db = new Database();
//		
//		db.setJdbcUrl("jdbc:postgresql://p1data.cdiwjc2x9nug.us-east-1.rds.amazonaws.com:5432/");
//		db.setDatabaseName("postgres");
//		db.setUser("postgres");
//		db.setPassword("bubblegum");
//		
//		db.createTable(Money.class);
//		
//		Money money = new Money("moname");
//		db.insert(money);
//		Customer custy = new Customer();
//		custy.setFirstName("bobie");
//		custy.setLastName("huns");
//		custy.setUserLoginId(1);
		
//		
//		CustomerDao cDao = new CustomerDao();
//		
//		cDao.insert(custy);
		
//		StandardSqlMaker sqlMk = new StandardSqlMaker();
//		StandardPojoInfo pjo = sqlMk.getPojoInfo(custy);
//		System.out.println(pjo(Customer.class));
		
		
//		Object colName = custy.getClass().getField("sqlId").get(Customer.class);

//		System.out.println(value);
		
//			System.out.println("field " + " " + field.getName());
//		}
		
		
	  
	      
	     Customer s = Manager.get(2, Customer.class);
		System.out.println(s.getFirstName().getValue());
//		AccountDao aDao = new AccountDao();
//		
//		Account acc1 = new Account();
//		acc1.setBalance(100);
//		acc1.setAccountTypeId(1);
//		
//		aDao.addAccount(null)
	
//		UserLoginDao uDao = new UserLoginDao();
//		
//		UserLogin uLog = uDao.getUserLoginByUsername("bilboboy1");
//		uLog.setUsername("bilboboy2");
//		
//		try {
//		uDao.update(uLog);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		tx.commit();
//	
//		session.close();
	}

}
