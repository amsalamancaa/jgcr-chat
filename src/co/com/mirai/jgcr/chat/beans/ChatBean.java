package co.com.mirai.jgcr.chat.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.event.FileUploadEvent;

import co.com.mirai.jgcr.chat.entities.Chat;
import co.com.mirai.jgcr.chat.entities.Mensaje;
import co.com.mirai.jgcr.chat.entities.MensajesUsuario;

@ManagedBean
public class ChatBean {

	private String chatId;
	private Chat chat;
	private String mensaje;
	private List<Mensaje> mensajes;
	
	public void enviarMensajePredeterminado(ActionEvent actionEvent) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		long idSearch = Long.parseLong(id);
		
		MensajesUsuario mensaje = em.find(MensajesUsuario.class, idSearch);
		
		this.mensaje= mensaje.getMensaje();
		enviarMensaje(actionEvent);
		
		em.close();
		emf.close();

	}

	public void enviarMensaje(ActionEvent actionEvent) {
		FacesContext context = FacesContext.getCurrentInstance();
		LoginBean b = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		Mensaje m = new Mensaje(b.getUsuario(), mensaje, chat.getId());
		

		/////////////////////////////
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(m);
		tx.commit();

		em.close();
		emf.close();
		/////////////////////////////
		refreshMensajes();
		this.mensaje = "";
	}

	public void refreshMensajes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();

		String jpql = "SELECT m FROM Mensaje m WHERE m.chat = ?1 ORDER BY m.fecha DESC";
		Query query = em.createQuery(jpql);
		query.setParameter(1, this.chat.getId());
		mensajes = query.getResultList();
		em.close();
		emf.close();
	}

	public ChatBean() {
		this.mensaje = "";
	}

	public String getChatId() {
		return chatId;
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		String fileName = event.getFile().getFileName();
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public void setChatId(String chatId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
		EntityManager em = emf.createEntityManager();
		long id = Long.parseLong(chatId);
		this.chat = em.find(Chat.class, id);
		refreshMensajes();
		em.close();
		emf.close();
		this.chatId = chatId;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

}
