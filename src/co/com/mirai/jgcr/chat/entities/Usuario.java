package co.com.mirai.jgcr.chat.entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	   
	
	private String nombre;
	@Id
	private String correos;
	private String image;
	private static final long serialVersionUID = 1L;
	
	
	public String getCorreos() {
		return correos;
	}
	public void setCorreos(String correos) {
		this.correos = correos;
	}



	public Usuario() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
