package src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import interfaces.InterSistema1;
import interfaces.InterSistema2;
import interfaces.InterSistema3;
import usuario.Administrador;

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
	public Integer conocerTama�oDelSistemaDeUsuarios() {
		return listaDeUsuarios.size();
	}

	@Override
	public Integer conocerTama�oDelSistemaDeCompras() {
		return listaDeCompra.size();
	}

	@Override
	public String vaciarListaDeUsuarios() {
		try {
		listaDeUsuarios.clear();
		return "Lista borrada";
		}
		catch (Exception e) {
			return "Error al borrar la lista";
		}
	}

	@Override
	public Boolean agregaUnUsuarioAlSistema(Usuario administrador){
		if(listaDeUsuarios.contains(administrador))
			return false;
		else
			listaDeUsuarios.add(administrador);
			return true;
	}

	@Override
	public Boolean eliminarUsuario(Usuario cliente) {
		Boolean resultado = false;
		Iterator<Usuario> it = listaDeUsuarios.iterator();
		while(it.hasNext()) {
			if(it.next().getNombreDeUsuario().equals(cliente.getNombreDeUsuario())) {
				it.remove();
				resultado = true;
			}
			else {
				resultado = false;
			}
		}
		return resultado;
	}
	@Override
	public String retornarElTipoDeUsuario(Usuario user) {
		if(user instanceof Administrador)
			return "El usuario es un Administrador";
		else 
			return "El usuario es un Cliente";
	}

	@Override
	public Boolean loggearseComoUsuario(String nombreUsuario, String contrase�a) {
		for(Usuario i: listaDeUsuarios) {
			if(i.getNombreDeUsuario().equals(nombreUsuario) && i.getContrase�a().equals(contrase�a)){
				i.setEstado(true);
				return true;
			}
		}
		return false;
	}

	@Override
	public Integer conocerCantidadDePuntos(String nombreUsuario, String contrase�a) {
		Integer resultado = 0;
		for(Usuario i: listaDeUsuarios) {
			if(i.getNombreDeUsuario().equals(nombreUsuario) && i.getContrase�a().equals(contrase�a)) {
				resultado = i.getPuntosAcumulados();
			}
			else {
				resultado = 0;
			}
		}
		return resultado;
	}

	@Override
	public Boolean salirDelSistema(String nombreDeUsuario, String contrase�a) {
		for(Usuario i: listaDeUsuarios) {
			if(i.getNombreDeUsuario().equals(nombreDeUsuario) && i.getContrase�a().equals(contrase�a)){
				i.setEstado(false);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void realizarUnaCompra(Usuario usuario, Producto producto) {
		Long idCompra = (long) (Math.random() * 999999999) + 1;
		Compra nuevaCompra = new Compra(idCompra, usuario);
		nuevaCompra.agregarProductoALaCompra(producto);		
	}
	//andres, si estas leyendo esto, aguante river. 9/12
	
	
}
