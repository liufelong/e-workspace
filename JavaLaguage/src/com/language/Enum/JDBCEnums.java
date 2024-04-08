package com.language.Enum;

public enum JDBCEnums {
	DRIVER,URL,USERNAME,PASSWORD;
	
	public static String getJDBCEnums(JDBCEnums JDBC) {
		
		switch (JDBC) {
		case DRIVER:
			return "com.mysql.jdbc.Driver";
		case URL :
			return "jdbc:mysql://localhost:3306/mysqltest";
		case USERNAME:
			return "root";
		case PASSWORD:
			return "123456";
		default:
			return "";
		}
	}
}
