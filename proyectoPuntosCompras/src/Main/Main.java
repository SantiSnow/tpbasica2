package Main;

import java.util.Scanner;

import javax.swing.JOptionPane;

import src.Producto;
import src.Sistema;
import src.Usuario;
import usuario.Administrador;
import usuario.Cliente;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema("Sistema 1");
		
		//administrador ya creado en el sistema
		Usuario admin = new Administrador ("Admin1", "Contraseña123", 1111111L, 9000, false);
		sistema.agregaUnUsuarioAlSistema(admin);
		
		//scaner de teclado
		Scanner teclado = new Scanner (System.in);
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
		
//		Producto producto11 = new Producto ("Ensalada mixta", 8987689L, 700.0);
//		Producto producto12 = new Producto ("Mostaza", 8563344L, 200.0);
//		Producto producto13 = new Producto ("Ketchup", 81231387L, 200.0);
//		Producto producto14 = new Producto ("Mayonesa", 67823423L, 200.0);
//		Producto producto15 = new Producto ("Arroz", 61231323L, 450.0);
//		Producto producto16 = new Producto ("Agua Mineral", 61231323L, 150.0);
//		Producto producto17 = new Producto ("Ñoquis", 61231323L, 300.0);
//	  	Producto producto18 = new Producto ("Mariscos", 61231323L, 900.0);
//  	Producto producto19 = new Producto ("Atun", 61231323L, 300.0);
//  	Producto producto20 = new Producto ("Ensalada rusa", 61231323L, 400.0);
		
		JOptionPane.showMessageDialog(null, "Bienvenidos Restaurante LaCachila");
		
		Integer opcionInicial = Integer.parseInt(JOptionPane.showInputDialog(null, "Para comenzar, ingrese 1 si desea Registrarse, o 2 si ya tiene usuario administrador"));
		
		if(opcionInicial == 1) {
			String nuevoNombreUsuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
			String contraseñaNueva = JOptionPane.showInputDialog("Ingrese contraseña");
			
			Long idNuevo = (long) (Math.random() * 999999999) + 1;
			Usuario nuevoUsuario = new Cliente (nuevoNombreUsuario, contraseñaNueva, idNuevo, 500, false);
			
			if(sistema.agregaUnUsuarioAlSistema(nuevoUsuario)) {
				JOptionPane.showMessageDialog(null, "Felicidades, ha sido registrado en el sistema");
				nuevoUsuario.setEstado(true);
				Integer opcionMenuOSalir = Integer.parseInt(JOptionPane.showInputDialog("presione 1 para mostrar el menu inicio u otro numero para salir"));
				do {
					if(opcionMenuOSalir == 1) {
						Integer opcionesDelInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para realizar una compra, 2 para ver sus datos, o 3 para salir: "));
						if(opcionesDelInicio == 1) {
							JOptionPane.showMessageDialog(null, "Para comprar, vea en la consola los productos e ingrese su numero de id en pantalla.");
							sistema.mostrarLosProductos();
							System.out.println(" ");
							System.out.println("Ingrese el numero id del producto deseado");
							Long idProductoElegido = teclado.nextLong();
								for(Producto i: sistema.listaDeProductos) {
									if(i.getId().equals(idProductoElegido)) {
										System.out.println("El precio de la compra es de " + sistema.realizarUnaCompra(nuevoUsuario, i));
										JOptionPane.showInputDialog("Ingrese 1 para pagar con Efectivo o 2 para pagar con puntos");
										
									}
								}
						}
						else if(opcionesDelInicio == 2) {
							JOptionPane.showMessageDialog(null, nuevoUsuario.mostrarPuntosYId());
						}
						else {
							String usuarioIngresado = JOptionPane.showInputDialog("Ingrese su usuario:");
							String contraseña = JOptionPane.showInputDialog("Ingrese contraseña");
							if(sistema.salirDelSistema(usuarioIngresado, contraseña)) {
								JOptionPane.showMessageDialog(null, "Ha salido del sistema correctamente");
							}
						}
					}
					else {
						nuevoUsuario.setEstado(false);
						JOptionPane.showMessageDialog(null, "Fin del Programa");
					}
				}
				while(opcionMenuOSalir == 1);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error, el usuario ya existe");
			}
		}
		else if(opcionInicial == 2) {
			String usuarioIngresado = JOptionPane.showInputDialog("Ingrese su usuario:");
			String contraseña = JOptionPane.showInputDialog("Ingrese contraseña");
			
			if(sistema.loggearseComoUsuario(usuarioIngresado, contraseña)) {
				if(sistema.retornarElObjetoUsuario(usuarioIngresado, contraseña) instanceof Administrador){
					JOptionPane.showMessageDialog(null, "Bienvenido: "+ usuarioIngresado + " al sistema de compras");
					JOptionPane.showMessageDialog(null, "Como administrador, puede realizar las siguientes tareas: ");
					Integer opcionesParaElMenuAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para ver la lista de productos"+"\nIngrese 2 para realizar una compra"+
					"\nIngrese 3 para eliminar un usuario"+"\nIngrese 4 para ver la lista de usuarios" + "\nIngrese 5 para vaciar la lista de usuarios" + "\nIngrese 6 para agregar un producto"));
				}
				else {
					JOptionPane.showMessageDialog(null, "Bienvenido: "+ usuarioIngresado + " al sistema de compras");
					
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Los datos son incorrectos");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "La opcion es incorrecta");
		}
	}

}
