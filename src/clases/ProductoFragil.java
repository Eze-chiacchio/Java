package clases;

public class ProductoFragil extends Producto{
	
	public TipoProducto tipo;
	
	public ProductoFragil(String cod, String nom, String des) {
		// TODO Auto-generated constructor stub
		this.codigo=cod;
		this.nombre=nom;
		this.desc=des;
		this.tipo=TipoProducto.FRAGIL;
	}

	private static final String ETIQUETA = "Producto Frágil trátese con cuidado";


	/*
	 * TODO COMPLETAR Atributos y métodos 
	 */

}
