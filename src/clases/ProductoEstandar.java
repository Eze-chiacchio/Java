package clases;

public class ProductoEstandar extends Producto  {

	private static final String ETIQUETA = "Producto Estandar";
	

	public TipoProducto tipo;
	public ProductoEstandar(String cod, String nom, String des) {
		// TODO Auto-generated constructor stub
		this.codigo=cod;
		this.nombre=nom;
		this.desc=des;
		this.tipo=TipoProducto.ESTANDAR;
	}

	/*
	 * TODO COMPLETAR Atributos y métodos 
	 */


}
