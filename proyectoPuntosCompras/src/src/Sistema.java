package src;

import java.util.HashSet;
import java.util.Set;

import interfaces.InterSistema1;
import interfaces.InterSistema2;
import interfaces.InterSistema3;

public class Sistema implements InterSistema1, InterSistema2, InterSistema3{
	//atributos
	private String nombreDelSistema;
	public Set <Usuario> listaDeUsuarios;
    public Set <Compra> listaDeCompra;
	
    //constructor
    public Sistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
		listaDeUsuarios = new HashSet<Usuario>();
		listaDeCompra = new HashSet<Compra>();
	}

    //constructor por defecto
	public Sistema() {
	}

	//getters y setters
	public String getNombreDelSistema() {
		return nombreDelSistema;
	}
	public void setNombreDelSistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
	}
	public Set<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}
	public void setListaDeUsuarios(Set<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	//hashcode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDeCompra == null) ? 0 : listaDeCompra.hashCode());
		result = prime * result + ((listaDeUsuarios == null) ? 0 : listaDeUsuarios.hashCode());
		result = prime * result + ((nombreDelSistema == null) ? 0 : nombreDelSistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (listaDeCompra == null) {
			if (other.listaDeCompra != null)
				return false;
		} else if (!listaDeCompra.equals(other.listaDeCompra))
			return false;
		if (listaDeUsuarios == null) {
			if (other.listaDeUsuarios != null)
				return false;
		} else if (!listaDeUsuarios.equals(other.listaDeUsuarios))
			return false;
		if (nombreDelSistema == null) {
			if (other.nombreDelSistema != null)
				return false;
		} else if (!nombreDelSistema.equals(other.nombreDelSistema))
			return false;
		return true;
	}

	@Override
	public Integer conocerTamañoDelSistemaDeUsuarios() {
		return listaDeUsuarios.size();
	}

	@Override
	public Integer conocerTamañoDelSistemaDeCompras() {
		return listaDeCompra.size();
	}

	@Override
	public String vaciarListaDeUsuarios() {
		listaDeUsuarios.clear();
		return "La lista ha sido vaciada";
	}

	@Override
	public Boolean agregaUnUsuarioAlSistema(Usuario administrador) {
		
		return null;
	}

	@Override
	public Boolean agregarUnUsuarioAlSistema2(Usuario user) {
		
		return null;
	}

	@Override
	public Boolean eliminarUsuario(Usuario cliente) {
		
		return null;
	}

	@Override
	public Boolean eliminarUsuarioHash(Usuario cliente) {
		
		return null;
	}

	@Override
	public Boolean loggearseComoUsuarioHash(String nombreUsuario, String contraseña) {
		
		return null;
	}

	@Override
	public Boolean logearseComoUsuario(String nombreUsuario, String contraseña) {
		
		return null;
	}

	@Override
	public Integer conocerCantidadDePuntos(String nombreUsuario, String contraseña) {
		
		return null;
	}

	@Override
	public Boolean salirDelSistema(String nombreDeUsuario, String contraseña) {
		
		return null;
	}
	@Override
	public void realizarUnaCompra(Usuario usuario, Producto producto) {
		
	}
	
}
