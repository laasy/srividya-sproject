package com.cg.map.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.map.exception.MPException;

public class JdbcUtility {

	static Connection connection = null;

	public static Connection getConnection() throws MPException {

		File file = null;
		FileInputStream inputStream = null;
		Properties properties = null;

		file = new File("resources/jdbc.properties");
		
		try {
			inputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inputStream);
			
			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
		} catch (FileNotFoundException e) {
			throw new MPException("no file present");
		} catch (IOException e) {
			throw new MPException("unable to read the file");
		} catch (ClassNotFoundException e) {
			throw new MPException("class is not found");
		} catch (SQLException e) {
			throw new MPException("not connected to database");
		}
		
		return connection;

	}

}
