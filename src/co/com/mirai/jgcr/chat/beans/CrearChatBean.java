package co.com.mirai.jgcr.chat.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.event.FlowEvent;

import co.com.mirai.jgcr.chat.entities.Chat;
import co.com.mirai.jgcr.chat.entities.Momento;
import co.com.mirai.jgcr.chat.entities.Usuario;

@ManagedBean
public class CrearChatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Chat chat;
	private List<Usuario> usuarios;
	private Usuario usuario;
	private Usuario tempUsuario;
	private String chatId;
	private String invitado;

	private Momento momento;

	public CrearChatBean() {

		FacesContext context = FacesContext.getCurrentInstance();
		LoginBean b = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		this.usuario = new Usuario();
		this.tempUsuario = new Usuario();

		this.chat = new Chat();
		this.chat.getMomentos().add(new Momento("Inicio"));
		this.momento = new Momento();
		this.chat.setAdministrador(b.getUsuario());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT u FROM Usuario u";
		Query query = em.createQuery(jpql);
		List<Usuario> resultados = query.getResultList();
		em.close();
		emf.close();
	}

	public void agregarMomento() {
		this.chat.getMomentos().add(this.momento);
		this.momento = new Momento();
	}

	public void agregarInvitado(ActionEvent actionEvent) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();

		Usuario u = em.find(Usuario.class, this.invitado);
		if (u == null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			this.usuario.setCorreos(this.invitado);
			em.persist(this.usuario);
			tx.commit();
		} else {
			this.usuario = u;
		}
		em.close();
		emf.close();

		this.chat.getUsuarios().add(this.usuario);
		this.usuario = new Usuario();
		this.invitado = "";
	}

	public void agregarMomento(ActionEvent actionEvent) {
		this.chat.getMomentos().add(this.momento);
		this.momento = new Momento();
	}

	public void quitarMomento(Momento momento) {
		this.chat.getMomentos().remove(momento);
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public void guardar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		for (Momento m : this.chat.getMomentos()) {
			tx.begin();
			em.persist(m);
			tx.commit();
		}
		tx.begin();
		em.persist(this.chat);
		tx.commit();
		em.close();
		emf.close();
	}

	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getTempUsuario() {
		return tempUsuario;
	}

	public void setTempUsuario(Usuario tempUsuario) {
		this.tempUsuario = tempUsuario;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public Momento getMomento() {
		return momento;
	}

	public void setMomento(Momento momento) {
		this.momento = momento;
	}

	public String getInvitado() {
		return invitado;
	}

	public void setInvitado(String invitado) {
		this.invitado = invitado;
	}

}
