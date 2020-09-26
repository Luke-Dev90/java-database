package ar.com.educacionit.databases.productos;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConexion {
	
	public static Connection obtenerConexion() throws Exception{
		
		//establecemos url, user, pass;
		String url = "jdbc:mysql://localhost/cafe";
		String user = "root";
		String pass = "lucaschalelamomo";
		
		//com.mysql.cj.jdbc.Driver
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		
		//Establecemos la conexion:
		Class.forName(dbDriver).newInstance();
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		return conn;
	}
	
	
}
