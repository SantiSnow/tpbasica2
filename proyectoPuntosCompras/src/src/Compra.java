package src;

import interfaces.InterCompra;
import src.Producto;

import java.util.*;

import javax.swing.JOptionPane;

public class Compra implements InterCompra{

	//atributos
	private Long idDeCompra;
	private Double precioTotal;
	private Integer puntosQueDaLaCompra;
	Set <Producto> listaDeProductos;
	
	//constructores
	public Compra(Long idDeCompra, Usuario usr) {
		this.idDeCompra = idDeCompra;
		listaDeProductos = new HashSet<Producto>();
	}

	public Compra() {
		super();
	}
	
	//getters y setters
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


	@Override
	public Boolean agregarProductoALaCompra(Producto producto) {
		try{return listaDeProductos.add(producto);
		}catch(Exception e) {
			JOptionPane.showInputDialog("No se pueden repetir productos.");
			return false;
		}
		
	}
	@Override
	public Double calcularPrecioFinal() {
		precioTotal = 0.0;
		for (Producto producto : listaDeProductos) {
			precioTotal += producto.getPrecio();	
		}
		puntosQueDaLaCompra =(int) (precioTotal /10);
 		return precioTotal;
	}
	
}
