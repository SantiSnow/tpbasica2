package usuario;
import src.Usuario;

public class Administrador extends Usuario{

	public Administrador(String nombreDeUsuario, String contraseña, Long id, Integer puntosAcumulados, Boolean estado) {
		super(nombreDeUsuario, contraseña, id, puntosAcumulados, estado);
		
	}

	@Override
	public String mostrarPuntosYId(String nombreUsuarioStringContraseña) {
		
		return null;
	}

}
