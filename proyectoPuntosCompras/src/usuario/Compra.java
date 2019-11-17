package usuario;

import interfaces.InterCompra;
import src.Producto;

import java.util.*;

import javax.swing.JOptionPane;

public class Compra implements InterCompra{

	//atributos
	private Long idDeCompra;
	private Double precioTotal;
	private Integer puntosQueDaLaCompra;
	private Set <Producto> listaDeProductos;
	

	public Compra(Long idDeCompra, Double precioTotal, Integer puntosQueDaLaCompra, Set<Producto> listaDeProductos) {
		super();
		this.idDeCompra = idDeCompra;
		this.precioTotal = precioTotal;
		this.puntosQueDaLaCompra = puntosQueDaLaCompra;
		this.listaDeProductos = listaDeProductos;
	}

	public Compra() {
		super();
	}
	

	public Long getIdDeCompra() {
		return idDeCompra;
	}

	public void setIdDeCompra(Long idDeCompra) {
		this.idDeCompra = idDeCompra;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Integer getPuntosQueDaLaCompra() {
		return puntosQueDaLaCompra;
	}

	public void setPuntosQueDaLaCompra(Integer puntosQueDaLaCompra) {
		this.puntosQueDaLaCompra = puntosQueDaLaCompra;
	}

	public Set<Producto> getListaDeProductos() {
		return listaDeProductos;
	}

	public void setListaDeProductos(Set<Producto> listaDeProductos) {
		this.listaDeProductos = listaDeProductos;
	}

	@Override
	public Boolean agregarProductoALaCompra(Producto producto) {
		try{listaDeProductos.add(producto);
		return true;
		}catch(Exception e) {
			JOptionPane.showInputDialog("No se pueden repetir productos.");
			return false;
		}
	}

	@Override
	public Double calcularPrecioFinal() {
		Double recibo = 0d;
		for (Producto producto : listaDeProductos) {
		recibo+= producto.getPrecio();	
		}
		puntosQueDaLaCompra =(int) (precioTotal /10);
 		return recibo;
	}

//	@Override
//	public Boolean pagarConPuntos() {
//		
//		return true;
//	}
//
//	@Override
//	public Boolean pagarConEfectivo() {
//		
//		return true;
//	}
//
//	@Override
//	public Boolean sumarPuntosPorLaCompra() {
//		if(this.pagarConEfectivo() == true) {
//			return true;
//		}
//		return false;
//	}

	
}
