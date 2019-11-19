package Main;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

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
		//cliente ya creado
		Usuario cliente = new Cliente ("Cliente1", "Contraseña123", 1222222L, 50, false);
		sistema.agregaUnUsuarioAlSistema(cliente);
		
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
		
		Integer opcionInicial = Integer.parseInt(JOptionPane.showInputDialog(null, "Para comenzar, ingrese 1 si desea Registrarse, o 2 si ya tiene usuario creado"));
		
		if(opcionInicial == 1) {
			String nuevoNombreUsuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
			JPasswordField pass = new JPasswordField(); 
			String contraseñaNueva = Integer.toString(JOptionPane.showConfirmDialog(null, pass, "Ingrese su contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)); 
			
			Long idNuevo = (long) (Math.random() * 999999999) + 1;
			Usuario nuevoUsuario = new Cliente (nuevoNombreUsuario, contraseñaNueva, idNuevo, 50, false);
			
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
										Double precioFinal = sistema.realizarUnaCompra(nuevoUsuario, i);
										System.out.println("El precio de la compra es de " + precioFinal);
										Integer opcionDePago = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para pagar con Efectivo o 2 para pagar con puntos"));
										if(opcionDePago.equals(1)) {
											sistema.pagarEnEfectivo(precioFinal);
											JOptionPane.showMessageDialog(null, "Gracias por su compra, el producto esta en camino");
										}
										else {
											if(sistema.pagarConPuntos(nuevoUsuario, precioFinal)) {
												JOptionPane.showMessageDialog(null, "Gracias, el producto esta en camino");
											}
											else {
												JOptionPane.showMessageDialog(null, "Error, no tiene suficientes puntos, debe pagar en efectivo");
											}
										}
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
								//se necesita un exit
							}
						}
					}
					else {
						nuevoUsuario.setEstado(false);
						JOptionPane.showMessageDialog(null, "Fin del Programa");
						//se necesita un exit
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
					//se necesita un do while aqui
					
					Integer opcionesParaElMenuAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 comprar"+"\nIngrese 2 para ver la lista de productos"+
					"\nIngrese 3 para eliminar un usuario"+"\nIngrese 4 para ver la lista de usuarios" + "\nIngrese 5 para vaciar la lista de usuarios" + "\nIngrese 6 para agregar un producto"+"\nIngrese 7 para salir"));
					switch (opcionesParaElMenuAdmin) {
						case 1:
							sistema.mostrarLosProductos();
							System.out.println(" ");
							System.out.println("Para comprar, ingrese el Id del producto, y luego el metodo de pago.");
							Long productoElegido = teclado.nextLong();
							for(Producto i: sistema.listaDeProductos) {
								if(i.getId().equals(productoElegido)) {
									Double precioFinal = sistema.realizarUnaCompra(sistema.retornarElObjetoUsuario(usuarioIngresado, contraseña), i);
									System.out.println("El precio de la compra es de " + precioFinal);
									Integer opcionDePago = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para pagar con Efectivo o 2 para pagar con puntos"));
									if(opcionDePago.equals(1)) {
										sistema.pagarEnEfectivo(precioFinal);
									}
									else {
										sistema.pagarConPuntos(sistema.retornarElObjetoUsuario(usuarioIngresado, contraseña), precioFinal);
									}
								}
							}
							break;
						case 2:
							sistema.mostrarLosProductos();
							System.out.println(" ");
							break;
						case 3:
							String nombreUrsEliminar = JOptionPane.showInputDialog("Ingrese el nombre del usuario a eliminar");
							if(sistema.eliminarUsuario(nombreUrsEliminar)) {
								JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
							}
							break;
						case 4:
							sistema.verListaDeUsuarios();
							break;
						case 5:
							Integer opcionFormateo = Integer.parseInt(JOptionPane.showInputDialog("¿Esta seguro que desea borrar a todos los usuarios, incluido el suyo? Esto no puede deshacerse."+"\nIngrese 1 para borrar"));
							if(opcionFormateo.equals(1)){
								sistema.vaciarListaDeUsuarios();
								JOptionPane.showMessageDialog(null, "Se han eliminado, todos los usuarios del sistema. Reinicie el sistema.");
							}
							break;
						case 6:
							String nombreNuevoProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
							Double precioNuevoProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
							Long IdProductoNuevo = (long) (Math.random() * 999999999) + 1;
							Producto productoNuevo = new Producto (nombreNuevoProducto, IdProductoNuevo, precioNuevoProducto);
								if(sistema.agregarProductoAlSistema(productoNuevo)) {
									JOptionPane.showMessageDialog(null, "El producto se agrego correctamente");
								}
								else {
									JOptionPane.showMessageDialog(null, "Error al agregar el producto");
								}
							
							break;
						case 7:
							JOptionPane.showMessageDialog(null, "Saliendo del sistema, hasta pronto");
							sistema.salirDelSistema(usuarioIngresado, contraseña);
							//se necesita un exit
							break;
						default:
							JOptionPane.showMessageDialog(null, "La opcion es incorrecta, intente nuevamente");
							break;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bienvenido: "+ usuarioIngresado + " al sistema de compras");
					//se necesita un do while aqui
					
					Integer opcionesParaElMenuCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Gracias por elegirnos, si desea ver la lista de Producto ingrese 1"+
					"\nIngrese 2 para ver sus datos"+"\nIngrese 3 para salir del sistema"));
					switch (opcionesParaElMenuCliente) {
						case 1:
							sistema.mostrarLosProductos();
							System.out.println(" ");
							System.out.println("Para comprar, ingrese el Id del producto, y luego el metodo de pago.");
							Long productoElegido = teclado.nextLong();
							
							for(Producto i: sistema.listaDeProductos) {
								if(i.getId().equals(productoElegido)) {
									Double precioFinal = sistema.realizarUnaCompra(sistema.retornarElObjetoUsuario(usuarioIngresado, contraseña), i);
									System.out.println("El precio de la compra es de " + precioFinal);
									Integer opcionDePago = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para pagar con Efectivo o 2 para pagar con puntos"));
									if(opcionDePago.equals(1)) {
										sistema.pagarEnEfectivo(precioFinal);
										JOptionPane.showMessageDialog(null, "Gracias por su compra, el producto esta en camino" + "\n Ha sumado "+ precioFinal/10 +" puntos con su compra");
									}
									else {
										sistema.pagarConPuntos(sistema.retornarElObjetoUsuario(usuarioIngresado, contraseña),precioFinal);
									}
								}
							}
							break;
						case 2:
							JOptionPane.showMessageDialog(null, "Los puntos del usuario son: "+sistema.conocerCantidadDePuntos(usuarioIngresado, contraseña));
							break;
						case 3:
							JOptionPane.showMessageDialog(null, "Saliendo del sistema, hasta pronto");
							sistema.salirDelSistema(usuarioIngresado, contraseña);
							//se necesita un exit
							System.exit(0);
							break;
						default:
							break;
					}
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
