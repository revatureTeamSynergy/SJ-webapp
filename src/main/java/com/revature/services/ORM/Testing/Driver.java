package com.revature.services.ORM.Testing;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.revature.models.UserLogin;
import com.revature.repository.ConnectionFactory;
import com.revature.services.ORM.Database.Query;

public class Driver {
	
	public static <T> Object getConstructor(Class<?> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Object row = clazz.getDeclaredConstructor().newInstance();
		return row;
	}
	public static void main(String[] args) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		
	UserLogin uLog = new UserLogin();
	Query q = new Query(ConnectionFactory.getConnection());
	
	System.out.println(q.getTable(uLog).toString());
		
		 
		 
		
		 
		 
	}
		//ObjTest1 Davinci = new ObjTest1();
		//Davinci.usernames = "Davinci";
		//Davinci.passwords = "Dinci";
		
		
		
	//	db.insert(Davinci);
		
		//Object query =  db.where("Davinci", "login", "usernames", ObjTest1.class);
		//ObjTest1 row = (ObjTest1) query;
		
		//System.out.println();
		//System.out.println(row.usernames);
		//System.out.println(row.passwords);
		
	//	ObjTest2 acco = new ObjTest2();
		//acco.usernames = "Davinci";
		//acco.acc_balance = 2.0;
		//acco.acc_num = 4.0;
		
		//db.insert(acco);
		 
		 
		
		//Object account = db.where("BobRoss", "account", "usernames", ObjTest2.class);
		//ObjTest2 acc = (ObjTest2) account;
		//System.out.println(acc.acc_balance );
		
		//db.update(Davinci, "passwords", "rdaf");
		//Object query2 =  db.where("Davinci", "login", "usernames", ObjTest1.class);
		//ObjTest1 row2 = (ObjTest1) query;
		
		//System.out.println();
		//System.out.println(row2.usernames);
		//System.out.println(row2.passwords);
		
		
		//db.delete(Davinci);
	
	
}
