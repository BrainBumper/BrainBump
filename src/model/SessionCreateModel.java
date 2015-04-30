package model;

import server.SocketServer;
import user.User;

public class SessionCreateModel {
	private User user;
	
	public SessionCreateModel(User user){
		this.user = user;
	}
	
	public void setServer(int port, int numPeople, String name, String password){
		user.sendServerInfo(numPeople, name, password);
		//user.setServer(new SocketServer(port, numPeople, name, password));
	}
}
