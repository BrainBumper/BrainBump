package model;

import user.User;

public class MainClientModel {

	private User user;
	
	public MainClientModel(User user){
		this.user = user;
	}
	
	public boolean isAdmin(){
		return (user.getAdmin());
	}
	
	public String getUsername(){
		return (user.getUsername());
	}
}
