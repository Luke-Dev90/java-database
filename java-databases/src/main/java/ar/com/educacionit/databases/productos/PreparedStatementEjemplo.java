package ar.com.educacionit.databases.productos;

import java.sql.*;

public class PreparedStatement 
{	
	/* metodos estaticos para manipular Base de datos SQL.
	*  Ejemplo con productos > ID , Descripcion , Precio;
	*  Insertar , Modificar , Eliminar , Buscar por id, Mostrar Lista completa.
	*/
	public static void inserta(Productos p) throws Exception, ProductosExceptions 
	{	
		Connection con = DBConexion.obtenerConexion();
		
		String sqlBusqueda = "Select * from productos where descripcion='"  + p.getDescripcion()+"'";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sqlBusqueda);
		
		if(rs.next()) 
		{
			throw new ProductosExceptions("El producto: "+ p.getDescripcion() +" ya existe");
		}
		else 
		{
			String sql = "insert into productos (descripcion,precio) values ('"
					+ p.getDescripcion() +"', " + p.getPrecio() + ")";
			st.execute(sql);
			System.out.println("Se inserto corretamente el producto");
		}
		
		st.close();
		con.close();
	}
	
	public static void modifica(Productos p) throws Exception 
	{
		
		Connection con = DBConexion.obtenerConexion();
		Statement st = con.createStatement();
		
		String sqlBusqueda = "select * from productos where id=" + p.getId();
		
		ResultSet rs = st.executeQuery(sqlBusqueda);
		
		if(!rs.next()) 
		{
			throw new ProductosExceptions("El id: " + p.getId() + " no existe.");
		}
		else 
		{
			String sql = "update productos set descripcion='"+p.getDescripcion() +
					"', precio=" + p.getPrecio() + " where id="+p.getId();
			st.execute(sql);	
			System.out.println("Registro modificado");
		}
		
		st.close();
		con.close();
	}

	public static void elimina(int id) throws Exception, ProductosExceptions
	{
		Connection con = DBConexion.obtenerConexion();
		Statement st = con.createStatement();
		
		String sentenciaCheck = "select * from productos where id=" + id;
		String sentencia = "delete from productos where id=" + id;
		
		ResultSet rs = st.executeQuery(sentenciaCheck);
		
		if(rs.next()) 
		{
			st.execute(sentencia);
			System.out.println("El registro eliminado correctamente");
		}
		else 
		{
			System.err.println("Por favor ingrese un id correcto");
			throw new ProductosExceptions("El Id: " + id + " no existe");
		}
		
		st.close();
		con.close();
	}
	
	public static void buscar(int id) throws Exception, ProductosExceptions 
	{
		Connection con = DBConexion.obtenerConexion();
		Statement st = con.createStatement();
		String sentenciaCheck = "select * from productos where id=" +id;
		ResultSet rs = st.executeQuery(sentenciaCheck);
		
		if(rs.next()) 
		{
			int idView = rs.getInt("id");
			String descripcion = rs.getString("descripcion");
			double precio = rs.getDouble("precio");
			
			System.out.println("---------");
			System.out.println("Registro encontrado:");
			System.out.println("Producto: #" + idView + " descripcion: " + descripcion + " $" + precio);
			System.out.println("---------");
		}
		else 
		{
			System.err.println("Error-Ingrese un ID correcto!");
			throw new ProductosExceptions("El ID" + id + " solicitado no existe");
		}
		st.close();
		con.close();
	}
	
	public static  Productos Listar() throws Exception, ProductosExceptions 
	{
		Connection con = DBConexion.obtenerConexion();
		Statement st = con.createStatement();
		String sentenciaCheck = "select * from productos";
		ResultSet rs = st.executeQuery(sentenciaCheck);
		
		Productos p = new Productos();
		System.out.println("<--- Lista de Productos ---->");
		while(rs.next()) 
		{
			try {
			int idView = rs.getInt("id");
			String descripcion = rs.getString("descripcion");
			double precio = rs.getDouble("precio");
			
			p.setId(idView);
			p.setDescripcion(descripcion);
			p.setPrecio(precio);
			
			
			System.out.println("Producto: #" + idView + " descripcion: " + descripcion + " $" + precio);
			
		}
		catch(Exception e)
		{
			System.err.println("No existen productos");
			throw new ProductosExceptions("La base de datos esta vacia!");
		}
		
	}
		st.close();
		con.close();
		System.out.println("<--- Base de datos rastreada ---->");
		return p;
	}
}
