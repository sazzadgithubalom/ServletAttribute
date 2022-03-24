package com.alom.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
	static Connection conn;
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		
		if(conn==null) {
			FileReader fr = new FileReader("D:\\DatabaseConnction\\DatabaseConnection.properties"); 
			Properties proprties = new Properties();
			proprties.load(fr);
			
			String userName = proprties.getProperty("userName");
			String userPassword = proprties.getProperty("userPassword");
			String driverClass = proprties.getProperty("driverClass");
			String mysqlUrl = proprties.getProperty("mysqlUrl");
			
			Class.forName(driverClass);
			conn=DriverManager.getConnection(mysqlUrl,userName,userPassword);
		}
		return conn;
	} 
}
