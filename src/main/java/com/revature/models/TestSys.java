package com.revature.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.sqlmakers.StandardPojoInfo;
import com.dieselpoint.norm.sqlmakers.StandardSqlMaker;
import com.revature.repository.AccountDao;
import com.revature.repository.CustomerDao;
import com.revature.repository.HibernateUtil;
import com.revature.repository.UserLoginDao;

public class TestSys {
	
//	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
//			.createEntityManagerFactory("postgres");

	public static void main(String[] args) {
		
		 Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        
	        
	        SessionFactory factory = configuration.buildSessionFactory();
	    
	        
	        Session session = HibernateUtil.getSession();

	        Transaction tx = session.beginTransaction();
		
		
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
		Customer custy = new Customer();
		custy.setFirstName("bob");
		custy.setLastName("huns");
		custy.setUserLoginId(1);
//		
//		CustomerDao cDao = new CustomerDao();
//		
//		cDao.insert(custy);
		
//		StandardSqlMaker sqlMk = new StandardSqlMaker();
//		StandardPojoInfo pjo = sqlMk.getPojoInfo(custy);
//		System.out.println(pjo(Customer.class));
	        
	      CustomerDao cDao = new CustomerDao();
	      
	      cDao.addCustomer(custy);
		
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
		
		tx.commit();
	
		session.close();
	}

}
