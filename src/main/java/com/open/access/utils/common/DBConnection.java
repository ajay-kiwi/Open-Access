package com.open.access.utils.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getCOnnection() {

		Connection con = null;
		try{  
			 Class.forName("com.mysql.jdbc.Driver"); 

			con = DriverManager.getConnection("jdbc:mysql://jat40.cagh7pb9onik.ap-northeast-1.rds.amazonaws.com:3306/" + "user=jat40&password=jatkiwi1!");

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
