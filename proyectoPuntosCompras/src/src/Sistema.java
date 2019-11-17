package src;

import java.util.HashSet;
import java.util.Set;

public class Sistema {
	//atributos
	private String nombreDelSistema;
	Set <Usuario> listaDeUsuarios;
    Set <Producto> listaDeProducto;
	
    //constructor
    public Sistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
		listaDeUsuarios = new HashSet<Usuario>();
		listaDeProducto = new HashSet<Producto>();
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
	public Set<Producto> getListaDeProducto() {
		return listaDeProducto;
	}
	public void setListaDeProducto(Set<Producto> listaDeProducto) {
		this.listaDeProducto = listaDeProducto;
	}

	//hashcode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDeProducto == null) ? 0 : listaDeProducto.hashCode());
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
		if (listaDeProducto == null) {
			if (other.listaDeProducto != null)
				return false;
		} else if (!listaDeProducto.equals(other.listaDeProducto))
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
    
    
    
	
}
