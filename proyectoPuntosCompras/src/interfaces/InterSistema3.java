package interfaces;

import src.Producto;
import src.Usuario;

public interface InterSistema3 {
	//interfaz para la compra de productos por parte de los usuarios
	//todos los metodos relacionados con compras y objetos
	//de tipo producto
	public void realizarUnaCompra(Usuario usuario, Producto producto);
}
