package co.com.mirai.jgcr.chat.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import co.com.mirai.jgcr.chat.entities.Chat;

@ManagedBean
public class ChatsBean {
	private List<Chat> chats;
	
	public ChatsBean() {
		this.chats = new ArrayList<Chat>();
	}
	
	public void startChat(Chat chat){
		chat.setPosition(chats.size());
		chats.add(chat);
	}
	
	public Chat getChat(int id) {
		return chats.get(id);
	}

	public void closeChat (Chat chat) {
		chats.remove(chat);
	}
}
