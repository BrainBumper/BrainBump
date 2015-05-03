package model;

import server.SocketServer;
import user.User;

public class SessionCreateModel {
	private User user;
	
	public SessionCreateModel(User user){
		this.user = user;
	}
	
	public void setServer(int port, int numPpl, String name, String password){
		user.setServer(new SocketServer(port, numPpl, name, password));
	}
}
