package co.com.mirai.jgcr.chat.entities;

import co.com.mirai.jgcr.chat.entities.Chat;
import co.com.mirai.jgcr.chat.entities.Usuario;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsuarioChat
 *
 */
@Entity

public class ChatUsuarioPermisos implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Usuario usuario;
	private Chat chat;
	private boolean permisos;
	private static final long serialVersionUID = 1L;

	public ChatUsuarioPermisos() {
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
	public Chat getChat() {
		return this.chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public boolean isPermisos() {
		return permisos;
	}
	public void setPermisos(boolean permisos) {
		this.permisos = permisos;
	}
   
}
