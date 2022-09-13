package com.revature.repository;

import java.lang.annotation.Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.revature.models.BooleanField;
import com.revature.models.CharField;
import com.revature.models.Customer;
import com.revature.models.DecimalField;
import com.revature.models.ForeignKey;

public class Manager {
	
	public static <T> void create(T obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field[] fields = obj.getClass().getDeclaredFields();
		String sql = "";
		sql = sql + "INSERT INTO " + obj.getClass().getSimpleName().toLowerCase() + "(";
		
		
		String values = "VALUES(";
		for(Field field : fields) {
			if(!Modifier.isStatic(field.getModifiers()) && !field.getType().isInstance(new ForeignKey<Object>())) {
				sql = sql + field.getName() + ", ";
				values = values + "?, ";
			}
		}
		sql = sql.replaceAll(", $", "");
		values = values.replaceAll(", $", "");
		values = values + ")";
		sql = sql + ")";
		sql = sql + values + ";";
		
		try (Connection connection = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
		{
			
			int i = 1;
			for(Field field : fields) {
				if  (field.getType().isInstance(new com.revature.models.CharField())) {
					CharField charObj = (CharField) field.get(obj);
					preparedStatement.setString(i, charObj.getValue());
					i++;
					
				}else if (field.getType().isInstance(new BooleanField())) {
					BooleanField boolObj = (BooleanField) field.get(obj); 
					preparedStatement.setBoolean(i, boolObj.getValue());
					i++;
					
				}else if (field.getType().isInstance(new DecimalField())) {
					DecimalField decimalObj = (DecimalField) field.get(obj); 
					preparedStatement.setDouble(i, decimalObj.getValue());
					i++;
					
				}
			}
			preparedStatement.executeUpdate();
			ResultSet set = preparedStatement.getGeneratedKeys();
            if(set.next()){
                int record_id = set.getInt("id");
                Field id = obj.getClass().getSuperclass().getDeclaredField("id");
        		id.setInt(obj, record_id);
            }
			
            
            
		}catch(SQLException e){
			e.printStackTrace();

		}
	}
	
	public static <T> T get(int id, Class<?> klass) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//		String colName = klass.getDeclaredField("sqlId").get(klass).toString();
		Field[] fields = klass.getDeclaredFields();
		
		
//		Field fieldId = klass.getField("sqlId");
//		
//		Object value = fieldId.get(klass);
//		
//		klass.getField("sqlId").get(value);
		
		T obj = (T) klass.getConstructor().newInstance();
		@SuppressWarnings("deprecation")
		Object fooObj = klass.newInstance();
		Method fooMethod = klass.getMethod("getSqlId");
		String bar = (String) fooMethod.invoke(obj);
		
		
		String sql = "";
		sql = "SELECT * FROM " + klass.getSimpleName().toLowerCase() + " WHERE " + bar  + " = " + id + ";";
		
		System.out.println(sql);
		
		
				
		try(Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql);)
		{
			
			if(set.next()) {
				for(Field field : fields) {
					
					if  (field.getType().isInstance(new CharField())) {
						CharField charObj = (CharField) field.get(obj);
						charObj.setValue(set.getString(field.getName()));
						System.out.println(field.getName());

					}else if (field.getType().isInstance(new BooleanField())) {
						BooleanField boolObj = (BooleanField) field.get(obj); 
						boolObj.setValue(set.getBoolean(field.getName()));
						System.out.println(field.getName());
						
					}else if (field.getType().isInstance(new DecimalField())) {
						DecimalField decimalObj = (DecimalField) field.get(obj); 
						decimalObj.setValue(set.getDouble(field.getName()));
						System.out.println(field.getName());
						
					}else if(field.getType().isInstance(new ForeignKey<Object>())) {
						ForeignKey<?> fk = (ForeignKey<?>) field.get(obj);
						int fkID = set.getInt(field.getName());
						System.out.println(field.getName());
						
						if(fkID != 0) {
							ParameterizedType pt = (ParameterizedType) field.getGenericType();
							Class<?> fkClass = (Class<?>) pt.getActualTypeArguments()[0];
							fk.obj = get(fkID, fkClass);	
						}	
					}
//				Field record_id = obj.getClass().getSuperclass().getDeclaredField("customerId");
//					record_id.setAccessible(true);
//				record_id.setInt(obj, set.getInt("customerId"));
				
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();
			//consoleLogger.error(e.toString());
			//fileLogger.error(e.toString());
	}
		return obj;
	}

	public static <T> List<T> all(Class<?> klass){
		Field[] fields = klass.getDeclaredFields();
	    List<T> list = new ArrayList<T>(); 
	    
	    String sql = "";
		sql = sql + "SELECT * FROM " + klass.getSimpleName().toLowerCase() + ";";

	    
	    try(Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery(sql);)
		{
	    while(set.next()) {

	        T obj = (T) klass.getConstructor().newInstance();
	        
	        for(Field field: fields) {
	            
	            if  (field.getType().isInstance(new CharField())) {
					CharField charObj = (CharField) field.get(obj);
					charObj.setValue(set.getString(field.getName()));

				}else if (field.getType().isInstance(new BooleanField())) {
					BooleanField boolObj = (BooleanField) field.get(obj); 
					boolObj.setValue(set.getBoolean(field.getName()));

				}else if (field.getType().isInstance(new DecimalField())) {
					DecimalField decimalObj = (DecimalField) field.get(obj); 
					decimalObj.setValue(set.getDouble(field.getName()));

				}else if(field.getType().isInstance(new ForeignKey<Object>())) {
					ForeignKey<?> fk = (ForeignKey<?>) field.get(obj);
					int fkID = set.getInt(field.getName());
					
					if(fkID != 0) {
						ParameterizedType pt = (ParameterizedType) field.getGenericType();
						Class<?> fkClass = (Class<?>) pt.getActualTypeArguments()[0];
						fk.obj = get(fkID, fkClass);	
					}	
				}
	        }
	        Field record_id = obj.getClass().getSuperclass().getDeclaredField("id");
			record_id.setInt(obj, set.getInt("id"));
	        
	        list.add(obj);

	    }
		}catch(Exception e){
			e.printStackTrace();
			//consoleLogger.error(e.toString());
			//fileLogger.error(e.toString());
		}
		return list;
		
	}
	
}
