package ar.com.educacionit.databases.productos;

import java.sql.*;

public class PreparedStatementEjemplo 
{	
	/* metodos estaticos para manipular Base de datos SQL.
	*  Ejemplo con productos > ID , Descripcion , Precio;
	*  Insertar , Modificar , Eliminar , Buscar por id, Mostrar Lista completa.
	*/
	
	public static void inserta(Productos p) throws Exception, ProductosExceptions 
	{	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		con = DBConexion.obtenerConexion();
		String sqlBusqueda = "Select * from productos where descripcion= ?";
		
		ps = con.prepareStatement(sqlBusqueda);
		ps.setNString(1, p.getDescripcion());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) 
		{	
			System.err.println("Por favor no duplique las descripciones");
			throw new ProductosExceptions("El producto: "+ p.getDescripcion() +" ya existe");
		}
		else 
		{
			String sql = "insert into productos (descripcion,precio) values (?,?)";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, p.getDescripcion());
			ps2.setDouble(2, p.getPrecio());
			ps2.execute();
			System.out.println("Se inserto corretamente el producto");
		}
		}finally{
		con.close();
		}
	}
	
	public static void modifica(Productos p) throws Exception, ProductosExceptions 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		con = DBConexion.obtenerConexion();
		String sqlBusqueda = "select * from productos where id=?";
		ps = con.prepareStatement(sqlBusqueda);
		ps.setInt(1, p.getId());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) 
		{
			String sql = "update productos set descripcion= ?, precio= ? where id= ?";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, p.getDescripcion());
			ps2.setDouble(2, p.getPrecio());
			ps2.setInt(3, p.getId());
			ps2.execute();	
			System.out.println("Registro modificado");
		}
		else
		{
			System.err.println("Ingrese un ID correcto");
			throw new ProductosExceptions("El id: " + p.getId() + " no existe.");
		}
		
		}
		finally 
		{
		con.close();
		}
	}

	public static void elimina(int id) throws Exception, ProductosExceptions
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		con = DBConexion.obtenerConexion();
		String sentenciaCheck = "select * from productos where id=?";
		ps = con.prepareStatement(sentenciaCheck);
		ps.setInt(1,id);
		String sentencia = "delete from productos where id=?";
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) 
		{
			PreparedStatement ps2 = con.prepareStatement(sentencia);
			ps2.setInt(1, id);
			ps2.execute();
			System.out.println("El registro eliminado correctamente");
		}else {
			System.err.println("Por favor ingrese un id correcto");
			throw new ProductosExceptions("El Id: " + id + " no existe");
		}
		}
		finally 
		{
		con.close();
		}
	}
	
	public static Productos getProducto(int id) throws Exception, ProductosExceptions 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		con = DBConexion.obtenerConexion();
		Productos p = new Productos();
		String sentenciaCheck = "select * from productos where id=?";
		ps = con.prepareStatement(sentenciaCheck);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) 
		{
			int idView = rs.getInt("id");
			String descripcion = rs.getString("descripcion");
			double precio = rs.getDouble("precio");
			
			p.setId(idView);
			p.setDescripcion(descripcion);
			p.setPrecio(precio);
			
			System.out.println("<---- Registro encontrado ---->");
			System.out.println(p.toString());
			System.out.println("<---- Busqueda Finalizada ---->");
		}else {
			System.err.println("Error-Ingrese un ID correcto!");
			throw new ProductosExceptions("El ID" + id + " solicitado no existe");
		}
			return p;
		}
		finally 
		{
			con.close();	
		}
	}
	
	public static  Productos Listar() throws Exception, ProductosExceptions 
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
		con = DBConexion.obtenerConexion();
		String sentenciaCheck = "select * from productos";
		ps = con.prepareStatement(sentenciaCheck);
		
		ResultSet rs = ps.executeQuery();
		
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
			System.out.println(p.toString());
			
		}
		
		catch(Exception e)
		{
			System.err.println("No existen productos");
			throw new ProductosExceptions("La base de datos esta vacia!");
		}
			
		}
			System.out.println("<--- Base de datos rastreada ---->");
			return p;
		}
		finally 
		{
		con.close();
		}
	}
}
