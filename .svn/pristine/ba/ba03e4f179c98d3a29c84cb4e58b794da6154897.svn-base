package co.com.mirai.jgcr.chat.entities;

import co.com.mirai.jgcr.chat.entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chat
 *
 */
@Entity

public class Chat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fin;
	private Usuario administrador;
	@OneToMany
	private List<Usuario> usuarios;
	@OneToMany
	private List<Momento> momentos;
	private int position;
	private String tema;
	private String materia;
	private String nombreChat;

	private static final long serialVersionUID = 1L;

	public Chat() {
		super();
		this.usuarios = new ArrayList<Usuario>();
		this.momentos = new ArrayList<Momento>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Usuario getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Momento> getMomentos() {
		return momentos;
	}

	public void setMomentos(List<Momento> momentos) {
		this.momentos = momentos;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public boolean getAcceso() {
		boolean retorno = true;
		if (this.inicio.before(Calendar.getInstance().getTime()) && this.fin.after(Calendar.getInstance().getTime()))
			retorno = false;
		return retorno;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getNombreChat() {
		return nombreChat;
	}

	public void setNombreChat(String nombreChat) {
		this.nombreChat = nombreChat;
	}

}
