package ar.com.educacionit.databases.productos;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConexion {
	
	public static Connection obtenerConexion() throws Exception
	{
		//establece url, user, pass;
		String url = "jdbc:mysql://localhost/cafe";
		String user = "root";
		String pass = "lucaschalelamomo";
		
		//establece conector.
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		
		//Establece la conexion:
		Class.forName(dbDriver).newInstance();
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		return conn;
	}
}
