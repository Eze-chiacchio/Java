package clases;

import tads.Pila;
import tadsarraylist.PilaAL;

public class SistemaLogistica {
public int cantRetiros=0;
public int cantEstandar=0;
public int cantFragil=0;
private Pila<Producto> pilonaFragil;
private Pila<Producto> pilonaEstandar;
	/**
	 * Mensajes de validación
	 */
	private static final String MSG_EL_CODIGO_NO_PUEDE_SER_NULO = "El código no puede ser nulo";
	private static final String MSG_TIPO_DE_PRODUCTO_INVÁLIDO = "Tipo de producto inválido";
	private static final String MSG_EL_PRODUCTO_NO_PUEDE_SER_NULO = "El producto no puede ser nulo";
	private static final String MSG_TAMANIO_DE_DEPOSITO_FRAGIL_INVALIDO = "Tamaño de depósito frágil inválido";
	private static final String MSG_TAMANIO_DE_DEPOSITO_ESTANDAR_INVALIDO = "Tamaño de depósito estandar inválido";

/*
 *TODO Completar
 */
	/**
	 * Constructor del sistema de logística.
	 * @param stockMaximoEstandar Stóck máximo a almacenar para productos estándar.
	 * @param stockMaximoFragil Stóck máximo a almacenar para productos frágiles.
	 * @throws IllegalArgumentException en caso de que los parámetros sean inválidos
	 */
	public SistemaLogistica(int stockMaximoEstandar, int stockMaximoFragil) throws IllegalArgumentException {
		//TODO Completar
		this.pilonaEstandar=new PilaAL(stockMaximoEstandar);
		this.pilonaFragil=new PilaAL(stockMaximoFragil);
	}

	/**
	 * Ingresa un producto al deposito que corresponda
	 * @param p el producto a ingresar - NO DEBE SER NULO
	 * @throws RuntimeException En caso de que el producto sea nulo, de tipo inválido o no pueda ser agregado.
	 */
	public void ingresarProducto(Producto p) throws RuntimeException {
		if(p.tipo==TipoProducto.ESTANDAR) {
			this.pilonaEstandar.push(p);
		}else {
			this.pilonaFragil.push(p);
		}
		
//		TODO COMPLETAR
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retira un producto en base a su tipo y código
	 * @param codigo Del producto a retirar
	 * @param tipo Tipo del producto a retirar
	 * @return el producto retirado
	 * @throws IllegalArgumentException en caso de que el código o el tipo sean nulos
	 * @throws RuntimeException En caso de no encontrar el producto buscado.
	 */
public Producto retirarProductoSeleccionado(String codigo, TipoProducto tipo) throws IllegalArgumentException, RuntimeException {
			Producto p=null;
			Producto pp=null;
			PilaAL<Producto> aux=new PilaAL<Producto>();
			while (pp == null) {
				if (tipo==TipoProducto.ESTANDAR) {
					p=this.pilonaEstandar.pop();
					if (p.codigo==codigo) {
						pp=p;
					}else {
						aux.push(p);
					}
				}
				else {
					p=this.pilonaFragil.pop();
				if (p.codigo==codigo) {
					pp=p;
				}else {
					aux.push(p);
				}
					
				}
				this.DevolverProductos(aux);
			}
			if(pp!=null) {
				this.cantRetiros++;
				System.out.println(pp);
			}
			return pp;
}

	private void DevolverProductos(PilaAL<Producto> aux) {
		Producto p;
		while(!aux.isEmpty()) {
			p=aux.pop();
			if(p.tipo==TipoProducto.ESTANDAR){
				this.pilonaEstandar.push(p);
			}else {
				this.pilonaFragil.push(p);
			}
		}
		
	}

}
