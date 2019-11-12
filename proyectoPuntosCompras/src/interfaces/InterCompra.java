package interfaces;

public interface InterCompra {

	public Boolean agregarProductoALaCompra(Producto producto);
	public Double calcularPrecioFinal();
	public Boolean pagarConPuntos();
	public Boolean pagarConEfectivo();
	public Boolean sumarPuntosPorLaCompra();
}
