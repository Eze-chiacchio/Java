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
	 * Mensajes de validaci�n
	 */
	private static final String MSG_EL_CODIGO_NO_PUEDE_SER_NULO = "El c�digo no puede ser nulo";
	private static final String MSG_TIPO_DE_PRODUCTO_INV�LIDO = "Tipo de producto inv�lido";
	private static final String MSG_EL_PRODUCTO_NO_PUEDE_SER_NULO = "El producto no puede ser nulo";
	private static final String MSG_TAMANIO_DE_DEPOSITO_FRAGIL_INVALIDO = "Tama�o de dep�sito fr�gil inv�lido";
	private static final String MSG_TAMANIO_DE_DEPOSITO_ESTANDAR_INVALIDO = "Tama�o de dep�sito estandar inv�lido";

/*
 *TODO Completar
 */
	/**
	 * Constructor del sistema de log�stica.
	 * @param stockMaximoEstandar St�ck m�ximo a almacenar para productos est�ndar.
	 * @param stockMaximoFragil St�ck m�ximo a almacenar para productos fr�giles.
	 * @throws IllegalArgumentException en caso de que los par�metros sean inv�lidos
	 */
	public SistemaLogistica(int stockMaximoEstandar, int stockMaximoFragil) throws IllegalArgumentException {
		//TODO Completar
		this.pilonaEstandar=new PilaAL(stockMaximoEstandar);
		this.pilonaFragil=new PilaAL(stockMaximoFragil);
	}

	/**
	 * Ingresa un producto al deposito que corresponda
	 * @param p el producto a ingresar - NO DEBE SER NULO
	 * @throws RuntimeException En caso de que el producto sea nulo, de tipo inv�lido o no pueda ser agregado.
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
	 * Retira un producto en base a su tipo y c�digo
	 * @param codigo Del producto a retirar
	 * @param tipo Tipo del producto a retirar
	 * @return el producto retirado
	 * @throws IllegalArgumentException en caso de que el c�digo o el tipo sean nulos
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
