package co.com.mirai.jgcr.chat.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import co.com.mirai.jgcr.chat.entities.MensajesUsuario;
import co.com.mirai.jgcr.chat.entities.Usuario;

@ManagedBean
public class MensajesUsuarioBean {
	
	private Usuario usuario;
	private String mensaje;
	private List<MensajesUsuario> mensajesUsuario;
	
	private void buscarMensajesUsuario(EntityManagerFactory emf, EntityManager em) {
		String jpql = "SELECT mu FROM MensajesUsuario mu WHERE mu.usuario =?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, this.usuario);
		mensajesUsuario = query.getResultList();
	}
	
	public MensajesUsuarioBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		LoginBean b = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		this.usuario = b.getUsuario();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		
		buscarMensajesUsuario(emf,em);
		
		em.close();
		emf.close();
	}
	
	public void agregarMensaje(ActionEvent actionEvent) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		
		MensajesUsuario mensaje = new MensajesUsuario();
		mensaje.setMensaje(this.mensaje);
		mensaje.setUsuario(this.usuario);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(mensaje);
		tx.commit();
		
		buscarMensajesUsuario(emf,em);
		
		em.close();
		emf.close();

		this.mensaje = "";
	}
	
	public void borrarMensaje(ActionEvent actionEvent) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		long idSearch = Long.parseLong(id);
		
		MensajesUsuario mensaje = em.find(MensajesUsuario.class, idSearch);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(mensaje);
		tx.commit();

		buscarMensajesUsuario(emf,em);
		
		em.close();
		emf.close();

	}

	public Usuario getUsuario() {
		return usuario;
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

	public List<MensajesUsuario> getMensajesUsuario() {
		return mensajesUsuario;
	}

	public void setMensajesUsuario(List<MensajesUsuario> mensajesUsuario) {
		this.mensajesUsuario = mensajesUsuario;
	}

}
