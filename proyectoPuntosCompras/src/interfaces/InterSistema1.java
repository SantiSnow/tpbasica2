package interfaces;

import src.Usuario;

public interface InterSistema1 {

	//interfaz que define creacion, logeo y eliminacion de usuarios
	//esta interfaz esta dedicada a proveer cuerpo a los metodos
	//relacionados con los usuarios
	
		Boolean agregaUnUsuarioAlSistema(Usuario administrador);
		Boolean agregarUnUsuarioAlSistema2(Usuario user);
		Boolean eliminarUsuario(Usuario cliente);
		Boolean eliminarUsuarioHash(Usuario cliente);
		Boolean loggearseComoUsuarioHash(String nombreUsuario, String contrase�a);
		Boolean logearseComoUsuario(String nombreUsuario, String contrase�a);
		Integer conocerCantidadDePuntos(String nombreUsuario, String contrase�a);
		Boolean salirDelSistema(String nombreDeUsuario, String contrase�a);
}
