package co.com.mirai.jgcr.chat.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-06T14:22:42.340-0500")
@StaticMetamodel(ChatUsuarioPermisos.class)
public class ChatUsuarioPermisos_ {
	public static volatile SingularAttribute<ChatUsuarioPermisos, Long> id;
	public static volatile SingularAttribute<ChatUsuarioPermisos, Usuario> usuario;
	public static volatile SingularAttribute<ChatUsuarioPermisos, Chat> chat;
	public static volatile SingularAttribute<ChatUsuarioPermisos, Boolean> permisos;
}
