package usuario;
import src.Usuario;


public class Cliente extends Usuario{

	public Cliente(String nombreDeUsuario, String contrase�a, Long id, Integer puntosAcumulados, Boolean estado) {
		super(nombreDeUsuario, contrase�a, id, puntosAcumulados, estado);
		
	}

	@Override
	public String mostrarPuntosYId(String nombreUsuarioStringContrase�a) {
		
		return null;
	}

}
