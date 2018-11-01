package co.com.mirai.jgcr.chat.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Momento
 *
 */
@Entity

public class Momento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	private static final long serialVersionUID = 1L;

	public Momento(Date fecha) {
		inicio = fecha;
		nombre = "Inicio";
	}

	public Momento() {
		super();
	}

	public Momento(String string) {
		this.nombre = string;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

}
