package usuario;
import src.Usuario;


public class Cliente extends Usuario{

	public Cliente(String nombreDeUsuario, String contraseña, Long id, Integer puntosAcumulados, Boolean estado) {
		super(nombreDeUsuario, contraseña, id, puntosAcumulados, estado);
		
	}

	@Override
	public String mostrarPuntosYId(String nombreUsuarioStringContraseña) {
		
		return null;
	}

}
