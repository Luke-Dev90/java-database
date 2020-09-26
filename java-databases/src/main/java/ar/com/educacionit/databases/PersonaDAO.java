package ar.com.educacionit.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonaDAO 
{
	public static void inserta(Persona p) throws Exception
	{
		Connection con = AdministradorDeConexiones.ObtenerConexion();
	
		String sql = "insert into personas (nombre,apellido,edad) values ('" + p.getNombre() + " ',' "
		+ p.getApellido() + "', " + p.getEdad() + ")";
		
		Statement st = con.createStatement();
		st.execute(sql);
		//Cierra Statement.
		st.close();
		//Cierra Conexion.
		con.close();
	}
	
	public static void modifica(Persona p) throws Exception
	{
		Connection con = AdministradorDeConexiones.ObtenerConexion();
		
		String sql = "update personas set nombre = '"+ p.getNombre() +"' , apellido='"
					+p.getApellido() + "', edad=" + p.getEdad() + " where id = " + p.getId();
		
		Statement st = con.createStatement();
		
		st.execute(sql);
		st.close();
		con.close();
	}
	
	public static void elimina(int id) throws Exception
	{
		Connection con = AdministradorDeConexiones.ObtenerConexion();
		
		String sql = "delete from personas where id=" + id;

		//Creo objeto ST para ejecutar query
		Statement st = con.createStatement();
		st.execute(sql);
		//Cerramos Objeto Statement.
		st.close();
		//Cerramos Conexion.
		con.close();
	}
	
	public static Persona mostrarPersona(int idPersona) throws Exception
	{
		Connection con = AdministradorDeConexiones.ObtenerConexion();
		String sql = "select * from personas";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		Persona p = new Persona();
		if(rs.next()) {
			int id = rs.getInt("id");
			int edad = rs.getInt("edad");
			String nombre = rs.getString("nombre");
			String apellido = rs.getNString("apellido");
			
			p.setId(id);
			p.setEdad(edad);
			p.setNombre(nombre);
			p.setApellido(apellido);
			
			System.out.println("Dato obtenido, Apellido y nombre: " + p.getApellido() + " "
							+ p.getNombre() + " de edad: " + p.getEdad());
			
		}
		
		
		st.close();
		con.close();
		return p;
	}
	
	public static Persona listadoPersona() throws Exception
	{
		Connection con = AdministradorDeConexiones.ObtenerConexion();
		String sql = "select * from personas";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		Persona p = new Persona();
		while(rs.next()) {
			int id = rs.getInt("id");
			int edad = rs.getInt("edad");
			String nombre = rs.getString("nombre");
			String apellido = rs.getNString("apellido");
			
			p.setId(id);
			p.setEdad(edad);
			p.setNombre(nombre);
			p.setApellido(apellido);
			
			System.out.println("Dato obtenido, Apellido y nombre: " + p.getApellido() + " "
							+ p.getNombre() + " de edad: " + p.getEdad());
			
		}
		
		
		st.close();
		con.close();
		return p;
	}
	
	
}
