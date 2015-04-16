package model;

public class LoginModel{
	
	private String username, password;
	
	public LoginModel(){}
	
	public void setUser(String user){
		this.username = user;
	}
	
	public void setPass(String pass){
		this.password = pass;
	}
	
	public String getUser(){
		return username;
	}
	
	public String getPass(){
		return password;
	}
	
	public boolean validate()
	{
		//if username and password match what is stored then return true
		//System.out.println("Username: " + username + "\nPassword: " + password);
		return true;
	}
}
