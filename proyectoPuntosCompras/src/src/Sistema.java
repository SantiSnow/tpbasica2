package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import interfaces.InterSistema1;
import interfaces.InterSistema2;
import interfaces.InterSistema3;
import usuario.Administrador;

public class Sistema implements InterSistema1, InterSistema2, InterSistema3{
	//atributos
	private String nombreDelSistema;
	public Set <Usuario> listaDeUsuarios;
    public Set <Compra> listaDeCompra;
    public List <Producto> listaDeProductos;
    
    //constructor
    public Sistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
		listaDeUsuarios = new HashSet<Usuario>();
		listaDeCompra = new HashSet<Compra>();
		listaDeProductos = new ArrayList<Producto>();
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
		try {
		listaDeUsuarios.clear();
		return "Lista borrada";
		}
		catch (Exception e) {
			return "Error al borrar la lista";
		}
	}

	@Override
	public Boolean agregaUnUsuarioAlSistema(Usuario user){
		try {
			return listaDeUsuarios.add(user);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		return false;
	}
	

	@Override
	public Boolean eliminarUsuario(String usrName) {
		Iterator<Usuario> it = listaDeUsuarios.iterator();
		while(it.hasNext()) {
			if(it.next().getNombreDeUsuario().equals(usrName)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String retornarElTipoDeUsuario(Usuario user) {
		if(user instanceof Administrador)
			return "El usuario es un Administrador";
		else 
			return "El usuario es un Cliente";
	}

	@Override
	public Boolean loggearseComoUsuario(String nombreUsuario, String contraseña) {
		for(Usuario i: listaDeUsuarios) {
			if(i.getNombreDeUsuario().equals(nombreUsuario) && i.getContraseña().equals(contraseña)){
				i.setEstado(true);
				return true;
			}
		}
		return false;
	}
	
	public Usuario retornarElObjetoUsuario(String nombreUsuario, String contraseña) {
		for(Usuario i: listaDeUsuarios) 
			if(i.getNombreDeUsuario().equals(nombreUsuario) && i.getContraseña().equals(contraseña)) {
				i.setEstado(true);
				return i;	
			}
		return null;
	}

	@Override
	public Integer conocerCantidadDePuntos(String nombreUsuario, String contraseña) {
		for (Usuario i : listaDeUsuarios) {
			if(i.getNombreDeUsuario().equals(nombreUsuario) && i.getContraseña().equals(contraseña)) {
				  return i.getPuntosAcumulados();						
			}
		}
		return 0;
	}

	@Override
	public Boolean salirDelSistema(String nombreDeUsuario, String contraseña) {
		for(Usuario i: listaDeUsuarios) {
			if(i.getNombreDeUsuario().equals(nombreDeUsuario) && i.getContraseña().equals(contraseña) && i.getEstado().equals(true)){
				i.setEstado(false);
				return true;
			}
		}
		return false;
	}
	
	public void verListaDeUsuarios() {
		for(Usuario i: listaDeUsuarios) {
			System.out.println(i);
		}
	}
	
	@Override
	public Double realizarUnaCompra(Usuario usuario, Producto producto) {
		for (Usuario i : listaDeUsuarios) {
			if(i == usuario && usuario.getEstado() == true) {
				Long idCompra = (long) (Math.random() * 999999999) + 1;
				Compra nuevaCompra = new Compra(idCompra, usuario);
				listaDeCompra.add(nuevaCompra);
				nuevaCompra.agregarProductoALaCompra(producto);
				return nuevaCompra.calcularPrecioFinal();
			}
		}
		return null;
	}
	
	public Boolean agregarProductoAlSistema(Producto p1) {
		return listaDeProductos.add(p1);
	}
	
	public void mostrarLosProductos(){
		for(Producto i: listaDeProductos) {
			System.out.println(i);
		}
	}
	
	//metodos de pago
	public String pagarEnEfectivo(Double precio) {
		return "Gracias por su compra, el producto esta en camino!";
	}
	
	public Boolean pagarConPuntos(Usuario usr, Double precio) {
		if(usr.getPuntosAcumulados()>precio/10) {
			usr.setPuntosAcumulados((int) -(precio/10));
			return true;
		}
		return false;
	}
	//andres, si estas leyendo esto, aguante river. 9/12
	
	public void sumarPuntosPorComprar(Usuario nuevoUsuario, Double pagarEnEfectivo) {
		Integer nuevosPuntos = (int) (nuevoUsuario.getPuntosAcumulados() + (pagarEnEfectivo/10));
		nuevoUsuario.setPuntosAcumulados(nuevosPuntos);
		
	}
	
}
