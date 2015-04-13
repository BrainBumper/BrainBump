package model;

import client.SocketClient;
import user.User;

public class SessionListModel {
	private User user;
	
	public SessionListModel(User user){
		this.user = user;
	}
	
	public void setClient(String hostname, int port){
		user.setSocketClient(new SocketClient(hostname, user.getUsername(), port));
	}
}
