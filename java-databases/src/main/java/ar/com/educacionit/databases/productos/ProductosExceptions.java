package ar.com.educacionit.databases.productos;

public final class ProductosExceptions  extends Exception{
	private String descripcion;
	
	public ProductosExceptions(String descripcion) {
		setDescripcion(descripcion);
	}

	@Override
	public String getMessage() {
		return getDescripcion();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
