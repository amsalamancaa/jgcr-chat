package co.com.mirai.jgcr.chat.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import co.com.mirai.jgcr.chat.entities.Chat;
import co.com.mirai.jgcr.chat.entities.Usuario;


@ManagedBean
public class ListaChatsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Chat> chats;
	private List<Chat> chatsInvitados;
	private List<Chat> chatsSacarInfo;
	@Inject
	private String email;
	@Inject
	private String image;
	@Inject
	private String nombre;

	private boolean primeraCarga;

	public ListaChatsBean() {
		this.primeraCarga = false;
	}

	public void obtenerChats() {

		if (!primeraCarga) {
			FacesContext context = FacesContext.getCurrentInstance();
			LoginBean b = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			if (email != null) {
				b.logOut();
			}
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jgcr-chat");
			EntityManager em = emf.createEntityManager();
			if (b.getUsuario().getCorreos() == null) {
				Usuario u = em.find(Usuario.class, email);
				if (u == null) {
					Usuario crear = new Usuario();
					crear.setCorreos(email);
					crear.setNombre(nombre);
					crear.setImage(image);
					EntityTransaction tx = em.getTransaction();
					tx.begin();
					em.persist(crear);
					tx.commit();
					b.setUsuario(crear);
				} else {
					if (image != null) {
						u.setImage(this.image);
						u.setNombre(this.nombre);
						EntityTransaction tx = em.getTransaction();
						tx.begin();
						em.persist(u);
						tx.commit();
					}
					b.setUsuario(u);
					this.nombre = b.getUsuario().getNombre();
					this.email = b.getUsuario().getCorreos();
					this.image = b.getUsuario().getImage();
				}
			}

			String jpql = "SELECT c FROM Chat c WHERE c.administrador=?1 AND c.fin>=?2";
			Query query = em.createQuery(jpql);
			query.setParameter(1, b.getUsuario());
			query.setParameter(2, Calendar.getInstance().getTime());
			this.chats = query.getResultList();

			jpql = "SELECT c FROM Chat c WHERE c.administrador=?1 AND c.fin<?2";
			query = em.createQuery(jpql);
			query.setParameter(1, b.getUsuario());
			query.setParameter(2, Calendar.getInstance().getTime());
			this.chatsSacarInfo = query.getResultList();

			jpql = "SELECT c FROM Chat c WHERE c.fin>=?1";
			query = em.createQuery(jpql);
			query.setParameter(1, Calendar.getInstance().getTime());
			List<Chat> chats = query.getResultList();
			this.chatsInvitados = new ArrayList<Chat>();
			for (Chat c : chats)
				if (c.getUsuarios().contains(b.getUsuario()))
					chatsInvitados.add(c);

			this.primeraCarga = true;

			em.close();
			emf.close();
		}

	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
		System.out.println("imagen");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Chat> getChatsInvitados() {
		return chatsInvitados;
	}

	public void setChatsInvitados(List<Chat> chatsInvitados) {
		this.chatsInvitados = chatsInvitados;
	}

	public List<Chat> getChatsSacarInfo() {
		return chatsSacarInfo;
	}

	public void setChatsSacarInfo(List<Chat> chatsSacarInfo) {
		this.chatsSacarInfo = chatsSacarInfo;
	}

}
