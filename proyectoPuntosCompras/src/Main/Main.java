package Main;

import javax.swing.JOptionPane;

import src.Sistema;
import src.Usuario;
import usuario.Cliente;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema("Sistema 1");
		
		JOptionPane.showMessageDialog(null, "Bienvenidos Restaurante LaCachila");
		
		Integer opcionInicial = Integer.parseInt(JOptionPane.showInputDialog(null, "Para comenzar, ingrese 1 si desea Registrarse, o 2 si ya tiene usuario"));
		
		if(opcionInicial == 1) {
			String nuevoNombreUsuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
			String contraseñaNueva = JOptionPane.showInputDialog("Ingrese contraseña");
			
			Long idNuevo = (long) (Math.random() * 999999999) + 1;
			Usuario nuevoUsuario = new Cliente (nuevoNombreUsuario, contraseñaNueva, idNuevo, 500, false);
			if(sistema.agregaUnUsuarioAlSistema(nuevoUsuario)) {
				JOptionPane.showInputDialog(null, "Felicidades, ha sido registrado en el sistema, presione 1 para mostrar el menu inicio u otro numero para salir");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error, el usuario ya existe");
			}
		}
		else if(opcionInicial == 2) {
			String usuarioIngresado = JOptionPane.showInputDialog("Ingrese su usuario:");
			String contraseña = JOptionPane.showInputDialog("Ingrese contraseña");
			
			if(sistema.loggearseComoUsuario(usuarioIngresado, contraseña)) {
				JOptionPane.showMessageDialog(null, "Bienvenido "+ usuarioIngresado + "al sistema de compras" );
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
