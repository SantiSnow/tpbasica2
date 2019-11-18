package interfaces;

public interface InterSistema2 {
	//interfaz que define metodos de devolucion de datos del sistema
	//tales como ver la cantidad de usuarios
	//y vaciar las listas
	Integer conocerTamañoDelSistemaDeUsuarios();
	Integer conocerTamañoDelSistemaDeCompras();
	String vaciarListaDeUsuarios();
}
