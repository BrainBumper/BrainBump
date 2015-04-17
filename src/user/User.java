package user;

import server.SocketServer;
import client.SocketClient;

public class User
{
	private String username, password;
	
	private SocketServer server = null;
	private SocketClient client = null;
	
	public User(String user, String pass){
		this.username = user;
		this.password = pass;
		
		client = new SocketClient("camlaptop",username,6780);
	}
	
	public void setServer(SocketServer server){
		this.server = server;
	}
	
	public void setSocketClient(SocketClient client){
		this.client = client;
	}
	
	public String getUsername(){
		return username;
	}
	
}
