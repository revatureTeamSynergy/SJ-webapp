package com.revature.models;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.revature.repository.ConnectionFactory;

public class Model {
		public int id;
	
	public static void createDBTable(Class<?> klass) throws InstantiationException, InvocationTargetException, NoSuchMethodException, IllegalAccessException{
		String className = klass.getSimpleName().toLowerCase();
		Field[] fields = klass.getDeclaredFields();
		String sql = "CREATE TABLE " + className + "( ";
		
		
		sql = sql + "id serial primary key,";
		
		for (Field field : fields) {
			
			if (field.getType().isInstance(new CharField())) {
				CharField obj = (CharField) field.get(klass.getDeclaredConstructor().newInstance());
				sql = sql + field.getName() + " varchar("+ obj.getMaxLength()+ ")";
				if(obj.getNull()) {
					sql = sql + " null";
				}else {
					sql = sql + " not null";
				}
				if(obj.getUnique()) {
					sql = sql + " unique";
				}
				sql = sql + ", ";

			}else if (field.getType().isInstance(new BooleanField())) {
				BooleanField obj = (BooleanField) field.get(klass.getDeclaredConstructor().newInstance());
				sql = sql + field.getName() + " boolean";
				/*
				if(obj.getNull()) {
					sql = sql + " null";
				}else {
					sql = sql + " not null";
				}
				*/
				if(obj.getDefault()) {
					sql = sql + " default true";
				}else {
					sql = sql + " default false";
				}
				sql = sql + ", ";
				
			}else if (field.getType().isInstance(new DecimalField())) {
				sql = sql + field.getName() + " decimal";
				sql = sql + ", ";
				
			}else if(field.getType().isInstance(new ForeignKey<Object>())) {
				ForeignKey<?> obj = (ForeignKey<?>) field.get(klass.getDeclaredConstructor().newInstance());
				sql = sql + field.getName() + " int";
				if(obj.getNull()) {
					sql = sql + " null";
				}else {
					sql = sql + " not null";
				}
				ParameterizedType pt = (ParameterizedType) field.getGenericType();
				Class<?> fkClass = (Class<?>) pt.getActualTypeArguments()[0];
				
				sql = sql + ", ";
				sql = sql + "foreign key(" + fkClass.getSimpleName().toLowerCase()+ ")";
				sql = sql + " references " + fkClass.getSimpleName().toLowerCase() + "(id)";
				sql = sql + " on delete " + obj.onDelete;
				sql = sql + ", ";
			}
	    }
		sql = sql.replaceAll(", $", "");
		sql = sql + ");";
				
		
		try(Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();
				){
			statement.executeUpdate(sql);

		}catch(Exception e){
			e.printStackTrace();
			//consoleLogger.error(e.toString());
			//fileLogger.error(e.toString());
		}
		
	}
	
	public void save() {
		String className = this.getClass().getSimpleName().toLowerCase();
		Field[] fields = this.getClass().getDeclaredFields();
		
		String sql = "";
		sql = "UPDATE " + className;
		sql = sql + " SET ";
		
		for(Field field : fields) {
			if(!Modifier.isStatic(field.getModifiers())) {
				sql = sql + field.getName() + "=?, ";
			}
		}
		sql = sql.replaceAll(", $", "");
		sql = sql + " WHERE id=?;";
		
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);)
			{
			int i = 1;
			for(Field field : fields) {
				if  (field.getType().isInstance(new CharField())) {
					CharField charObj = (CharField) field.get(this);
					preparedStatement.setString(i, charObj.getValue());
					i++;
					
				}else if (field.getType().isInstance(new BooleanField())) {
					BooleanField boolObj = (BooleanField) field.get(this); 
					preparedStatement.setBoolean(i, boolObj.getValue());
					i++;
					
				}else if (field.getType().isInstance(new DecimalField())) {
					DecimalField decimalObj = (DecimalField) field.get(this); 
					preparedStatement.setDouble(i, decimalObj.getValue());
					i++;
					
				}else if(field.getType().isInstance(new ForeignKey<Object>())) {
					ForeignKey<?> fkObj = (ForeignKey<?>) field.get(this);
					if(fkObj.obj != null) {
						Field fkObjID= fkObj.obj.getClass().getSuperclass().getDeclaredField("id");
						int fkRecordID = fkObjID.getInt(fkObj.obj);
						preparedStatement.setInt(i, fkRecordID);
					}else {
						preparedStatement.setNull(i, 0);
					}
					i++;
				}
			}
			
            Field id = this.getClass().getSuperclass().getDeclaredField("id");
            int record_id = id.getInt(this);
    		preparedStatement.setInt(i, record_id);	
			preparedStatement.executeUpdate();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
	
	public void delete() {
		String sql = "";
		
		String className = this.getClass().getSimpleName().toLowerCase();
		sql = sql + "DELETE FROM " + className;
		sql = sql + " WHERE id=?";
			
		try(Connection connection = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);)
		{
			Field id = this.getClass().getSuperclass().getDeclaredField("id");
            int record_id = id.getInt(this);
            
			preparedStatement.setInt(1, record_id);
			preparedStatement.executeUpdate();
					
		}catch(Exception e){
			e.printStackTrace();
			//consoleLogger.error(e.toString());
			//fileLogger.error(e.toString());
	    }
	
	}
}
