package ar.com.educacionit.databases.productos;

public class Productos {
	
	private int id;
	private String descripcion;
	private double precio;
	
	public Productos()
	{
		
	}
	
	public Productos(String descripcion, double precio)
	{
		setDescripcion(descripcion);
		setPrecio(precio);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
