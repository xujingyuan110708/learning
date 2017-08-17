package com.ms.www.util.method;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection(){
		try {
			
			Properties pro = new Properties();
			InputStream ipt = new FileInputStream(new File(new DBConnection().getClass().getResource("/jdbc.properties").toURI()));
			pro.load(ipt);
			// 装入数据库特定的驱动器  
	        Class.forName(pro.getProperty("jdbc.driverClassName"));  
	        String user = pro.getProperty("jdbc.username");
	        String password =pro.getProperty("jdbc.password");
	        String url = pro.getProperty("jdbc.url");
	        // 与数据库建立连接  
	        return (Connection)DriverManager.getConnection(url ,user ,password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
