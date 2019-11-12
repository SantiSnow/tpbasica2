package interfaces;

public interface InterSistema1 {

	//interfaz que define creacion, logeo y eliminacion de usuarios
	//esta interfaz esta dedicada a proveer cuerpo a los metodos
	//relacionados con los usuarios
	
		Boolean agregaUnUsuarioAlSistema(Usuario administrador);
		Boolean agregarUnUsuarioAlSistema2(Usuario user);
		Boolean eliminarUsuario(Usuario cliente);
		Boolean eliminarUsuarioHash(Usuario cliente);
		Boolean loggearseComoUsuarioHash(String nombreUsuario, String contraseņa);
		Boolean logearseComoUsuario(String nombreUsuario, String contraseņa);
		Integer conocerCantidadDePuntos(String nombreUsuario, String contraseņa);
		Boolean salirDelSistema(String nombreDeUsuario, String contraseņa);
}
