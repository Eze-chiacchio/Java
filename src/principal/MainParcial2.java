package principal;

import clases.ProductoEstandar;
import clases.ProductoFragil;
import clases.SistemaLogistica;
import clases.TipoProducto;

public class MainParcial2 {

	private static final String MSG_HUBO_UN_PROBLEMA_SACANDO_UN_PRODUCTO = "Hubo un problema sacando un producto: ";
	private static final String MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO = "Se retiró correctamente el producto";
	private static final String MSG_NO_SE_PUDO_AGREGAR_EL_PRODUCTO_ESTANDAR = "No se pudo agregar el producto Estándar: ";
	private static final String MSG_NO_SE_PUDO_AGREGAR_EL_PRODUCTO_FRAGIL = "No se pudo agregar el producto frágil: ";
	private static final String MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO = "Se ingresó correctamente el producto";

	public static void main(String[] args) {

		MainParcial2 test = new MainParcial2();

		SistemaLogistica sl = new SistemaLogistica(4, 3);
		try {
		test.ingresarProductosEstandar(sl);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------------------------------------------");

		try {
		test.ingresarProductosFragil(sl);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------------------------------------------");
		
		try {
		test.retirar(sl);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------------------------------------------");

		sl.mostrar();

	}

	private void ingresarProductosFragil(SistemaLogistica sl) {

		sl.ingresarProducto(new ProductoFragil("Fragil1", "Ventana", "Ventana Fragil"));

		sl.ingresarProducto(new ProductoFragil("Fragil2", "Florero", "Florero hindú"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoFragil("null", "Ventanas", "Ventanas Fragiles"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoFragil("Un codigo", "null", "Ventanas Fragiles"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoFragil("Fragil5", "Jarron", "Dinastia Ming"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoFragil("Fragil6", "Espejo", "Espejo mágico"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

	}

	private void ingresarProductosEstandar(SistemaLogistica sl) {

		sl.ingresarProducto(new ProductoEstandar("Estandar1", "Goma", "Goma de auto"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoEstandar("Estandar2", "Silla", "Silla ergonómica"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoEstandar("null", "Bolsa de Arena", "Arenas del desierto"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoEstandar("Un codigo loco", "null", "Gran producto en oferta"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoEstandar("Estandar5", "Barra de acero", "Ideal para edificios"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoEstandar("Estandar6", "Caja carton", "medida única"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);

		sl.ingresarProducto(new ProductoEstandar("Estandar99", "Caja carton", "medida única"));
		System.out.println(MSG_SE_INGRESO_CORRECTAMENTE_EL_PRODUCTO);
	}

	private void retirar(SistemaLogistica sl) {

		sl.retirarProductoSeleccionado("Estandar2", TipoProducto.ESTANDAR);
		System.out.println(MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO);

		sl.retirarProductoSeleccionado(null, TipoProducto.ESTANDAR);
		System.out.println(MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO);

		sl.retirarProductoSeleccionado("codigo", null);
		System.out.println(MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO);

		sl.retirarProductoSeleccionado("Estandar6", TipoProducto.ESTANDAR);
		System.out.println(MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO);

		sl.retirarProductoSeleccionado("Fragil2", TipoProducto.FRAGIL);
		System.out.println(MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO);

		sl.retirarProductoSeleccionado("Sin Codigo", TipoProducto.FRAGIL);
		System.out.println(MSG_SE_RETIRO_CORRECTAMENTE_EL_PRODUCTO);
	
	}

}
