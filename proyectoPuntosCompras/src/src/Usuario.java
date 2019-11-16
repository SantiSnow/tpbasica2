package src;

public abstract class Usuario {
	//atributos
	private String nombreDeUsuario;
	private String contrase�a;
	private Long id;
	private Integer puntosAcumulados;
	public Boolean estado;
	
	//constructor
	public Usuario(String nombreDeUsuario, String contrase�a, Long id, Integer puntosAcumulados, Boolean estado) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrase�a = contrase�a;
		this.id = id;
		this.puntosAcumulados = puntosAcumulados;
		this.estado = estado;
	}

	//getters y setters
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPuntosAcumulados() {
		return puntosAcumulados;
	}
	public void setPuntosAcumulados(Integer puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	//sobreescribir hascode equals y tostring
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrase�a == null) ? 0 : contrase�a.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombreDeUsuario == null) ? 0 : nombreDeUsuario.hashCode());
		result = prime * result + ((puntosAcumulados == null) ? 0 : puntosAcumulados.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Usuario [nombreDeUsuario=" + nombreDeUsuario + ", contrase�a=" + contrase�a + ", id=" + id
				+ ", puntosAcumulados=" + puntosAcumulados + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contrase�a == null) {
			if (other.contrase�a != null)
				return false;
		} else if (!contrase�a.equals(other.contrase�a))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreDeUsuario == null) {
			if (other.nombreDeUsuario != null)
				return false;
		} else if (!nombreDeUsuario.equals(other.nombreDeUsuario))
			return false;
		if (puntosAcumulados == null) {
			if (other.puntosAcumulados != null)
				return false;
		} else if (!puntosAcumulados.equals(other.puntosAcumulados))
			return false;
		return true;
	}

	//metodos abstractos
	public abstract String mostrarPuntosYId(String nombreUsuarioStringContrase�a);
}
