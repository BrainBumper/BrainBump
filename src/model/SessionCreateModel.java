package model;

import server.SocketServer;
import user.User;

public class SessionCreateModel {
	private User user;
	
	public SessionCreateModel(User user){
		this.user = user;
	}
	
	public void setServer(SocketServer server){
		user.setServer(server);
	}
}
