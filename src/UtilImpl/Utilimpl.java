package UtilImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Util.Util;

public class Utilimpl implements Util {

	public Statement st() {
		Statement stm = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dd","root","");
		stm = cn.createStatement();
		return stm;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return stm;
	}
	
	

}
