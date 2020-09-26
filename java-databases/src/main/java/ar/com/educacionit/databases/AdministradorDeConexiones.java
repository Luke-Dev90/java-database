package ar.com.educacionit.databases;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones 
{
	public static Connection ObtenerConexion() throws Exception
	{
		// Establece URL, USER, PASS;
		String url = "jdbc:mysql://localhost/cafe";
		String dbUser = "root";
		String dbPass = "lucaschalelamomo";
		
		// Establece Driver JDBC
		
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		
		//Establece la Conexion.
		Class.forName(dbDriver).newInstance();
		
		Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
		
		return conn;
	}
}
