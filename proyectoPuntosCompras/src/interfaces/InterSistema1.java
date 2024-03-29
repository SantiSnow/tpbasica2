package interfaces;

import src.Usuario;

public interface InterSistema1 {

	//interfaz que define creacion, logeo y eliminacion de usuarios
	//esta interfaz esta dedicada a proveer cuerpo a los metodos
	//relacionados con los usuarios
	
	Boolean agregaUnUsuarioAlSistema(Usuario administrador);
	Boolean eliminarUsuario(String nombreUsr);
	Boolean loggearseComoUsuario(String nombreUsuario, String contraseņa);
	Integer conocerCantidadDePuntos(String nombreUsuario, String contraseņa);
	Boolean salirDelSistema(String nombreDeUsuario, String contraseņa);
	String retornarElTipoDeUsuario(Usuario user);
}
