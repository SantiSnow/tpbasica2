package usuario;
import src.Usuario;


public class Cliente extends Usuario{

	public Cliente(String nombreDeUsuario, String contraseņa, Long id, Integer puntosAcumulados, Boolean estado) {
		super(nombreDeUsuario, contraseņa, id, puntosAcumulados, estado);
		
	}

	@Override
	public String mostrarPuntosYId() {
		return "El ID del usuario es: "+ getId() + " Y los puntos acumulados del usuario son: "+ getPuntosAcumulados();
	}

}
