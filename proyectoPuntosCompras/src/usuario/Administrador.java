package usuario;
import src.Usuario;

public class Administrador extends Usuario{

	public Administrador(String nombreDeUsuario, String contrase�a, Long id, Integer puntosAcumulados, Boolean estado) {
		super(nombreDeUsuario, contrase�a, id, puntosAcumulados, estado);
		
	}

	@Override
	public String mostrarPuntosYId(String nombreUsuarioStringContrase�a) {
		
		return null;
	}

}
