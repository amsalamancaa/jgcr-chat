package co.com.mirai.jgcr.chat.entities;

import co.com.mirai.jgcr.chat.entities.Usuario;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MensajesUsuario
 *
 */
@Entity

public class MensajesUsuario implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Usuario usuario;
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public MensajesUsuario() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}   
	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
   
}
