package ar.com.educacionit.databases.productos;

public class MainProductos {
	public static void main(String[]args) throws Exception{
		
		
		/*	Ejemplos de insertar:	    Descripción - precio ↓
		 *  Productos p = new Productos("Maletin"   , 3335.66);
		 *  PreparedStatementEjemplo.inserta(p);
		 *  
		 *  Modifica el producto con el ID seteado. ↓  
		 *  Proudctos p2 = new Productos("Cacerola Carol", 2222);
		 *  p2.setId(1);
		 *  PreparedStatementEjemplo.modifica(p2);
		 *  
		 *  Elimina el producto con el id seleccionado: ↓
		 *  PreparedStatementEjemplo.elimina(4);
		 *  
		 *  Devuelve el producto con el id seleccionado.↓
		 *  PreparedStatementEjemplo.getProducto(1);
		 *  
		 */
		
		
		//Devuelve la lista de productos completa.
		//PreparedStatementEjemplo.Listar();
		
		PreparedStatementEjemplo.getProductos();
		
	}
}
