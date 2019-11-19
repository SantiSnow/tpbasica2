package interfazGrafica;

import interfazGrafica.Ventana;
import src.Producto;
import src.Sistema;
import src.Usuario;
import usuario.Administrador;
import usuario.Cliente;

public class MainVentana {

	public static void main(String[] args) {
		//esta clase lanza las ventanas de la interfaz grafica
		Ventana v1 = new Ventana();
		
		v1.setVisible(true); //setea la ventana en visible, esto por defecto es false, JFrame aparece invisible
		
		//aqui creamos algunos objetos para que el sistema ya tenga datos
		//creamos el sistema
		Sistema sistema = new Sistema("Sistema 1");
		//creamos una cantidad de productos para que ya esten en el sistema:
		//productos pre-cargados en el sistema
		Producto producto1 = new Producto ("Gaseosa", 3484854L, 600.0);
		Producto producto2 = new Producto ("Jugo", 1234141L, 600.0);
		Producto producto3 = new Producto ("Cerveza", 3843843L, 700.0);
		Producto producto4 = new Producto ("Pizza", 1341412L, 900.0);
		Producto producto5 = new Producto ("Milanesas", 8438343L, 700.0);
		Producto producto6 = new Producto ("Papas Fritas", 4567657L, 800.0);
		Producto producto7 = new Producto ("Asado", 8677686L, 400.0);
		Producto producto8 = new Producto ("Pollo", 4543543L, 400.0);
		Producto producto9 = new Producto ("Pure", 6765765L, 800.0);
		Producto producto10 = new Producto ("Pasta", 8987689L, 700.0);
		//los agregamos al sistema
		sistema.agregarProductoAlSistema(producto1);
		sistema.agregarProductoAlSistema(producto2);
		sistema.agregarProductoAlSistema(producto3);
		sistema.agregarProductoAlSistema(producto4);
		sistema.agregarProductoAlSistema(producto5);
		sistema.agregarProductoAlSistema(producto6);
		sistema.agregarProductoAlSistema(producto7);
		sistema.agregarProductoAlSistema(producto8);
		sistema.agregarProductoAlSistema(producto9);
		sistema.agregarProductoAlSistema(producto10);
		//administrador ya creado en el sistema
		Usuario admin = new Administrador ("Admin1", "Contraseña123", 1111111L, 9000, false);
		sistema.agregaUnUsuarioAlSistema(admin);
		//cliente ya creado
		Usuario cliente = new Cliente ("Cliente1", "Contraseña123", 1222222L, 50, false);
		sistema.agregaUnUsuarioAlSistema(cliente);
		
		v1.iniciarComponentes();
		v1.agregarBotones();
		
	}

}
