package interfaces;

import src.Producto;

public interface InterCompra {
	//la interfaz de compra define metodos de como deben comportarse los 
	//metodos de compra y firma deben tener
	public Boolean agregarProductoALaCompra(Producto producto);
	public Double calcularPrecioFinal();
//	public Boolean pagarConPuntos();
//	public Boolean pagarConEfectivo();
//	public Boolean sumarPuntosPorLaCompra();
}
