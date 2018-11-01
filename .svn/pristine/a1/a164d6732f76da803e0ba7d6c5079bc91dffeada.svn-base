package co.com.mirai.jgcr.chat.entities;

import co.com.mirai.jgcr.chat.entities.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mensaje
 *
 */
@Entity

public class Mensaje implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private Usuario usuario;
	private String mensaje;
	private int tipo;
	private boolean advertencia;
	private long chat;
	private static final long serialVersionUID = 1L;

	public Mensaje(Usuario u, String m, long chat) {
		this.fecha = Calendar.getInstance().getTime();
		this.usuario = u;
		this.mensaje = m;
		this.chat = chat;
		this.advertencia = false;
	}

	public Mensaje() {
		super();
		this.advertencia = false;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public long getChat() {
		return chat;
	}

	public void setChat(long chat) {
		this.chat = chat;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isAdvertencia() {
		return advertencia;
	}

	public void setAdvertencia(boolean advertencia) {
		this.advertencia = advertencia;
	}

}
