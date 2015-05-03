package user;

import java.io.IOException;

import server.SocketServer;
import client.SocketClient;

public class User
{
	private String username, password;
	
	private boolean admin = false;
	
	private SocketServer server = null;
	private SocketClient client = null;
	
	public User(String user, String pass){
		this.username = user;
		this.password = pass;
		
		client = new SocketClient("camlaptop",username,6780);
	}
	
	public boolean checkUpdate(){
		return true;
	}
	
	public void sendServerInfo(int numPeople, String name, String password){
		try {
			client.connect(); // connection reset issue?!?
			client.sendServerInfo(numPeople, name, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public String getPassword(){
		return password;
	}
	
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
	
	public boolean getAdmin(){
		return admin;
	}
	
}
