package com.ist.services.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Hassan Jegan Ndow
 */
 
public class ConnectDb {

	Connection conn;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * 
	 */
	public ConnectDb(String username, String password)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		conn = connect(username, password);
	}

	public java.sql.Connection connect(String username, String password)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		String driverMaria = "org.mariadb.jdbc.Driver";
		Class.forName(driverMaria);
		String url = "jdbc:mariadb://team-torvalds.ist.rit.edu:3306/InventoryItemDb";

		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		props.setProperty("useTimezone", "true");
		props.setProperty("useLegacyDatetimeCode", "false");
		props.setProperty("serverTimezone", "UTC");
		Connection conn = DriverManager.getConnection(url, props);

		return conn;
	}

	public Connection getConn() {
		return conn;
	}

}
