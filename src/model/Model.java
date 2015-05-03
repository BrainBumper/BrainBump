package model;

import javax.accessibility.AccessibleContext;
import javax.swing.JTextArea;

import view.ChatView;
import user.User;

//JRE System Library [CDC-1.1/Foundation-1.1] Change

public class Model {
	
	String name;
	Idea[] ideas;
	User[] users;
	int numUsers = 0, numIdeas = 0;
	Idea[][] groups;
	ChatView chat;
	
	public Model(){
		
		name = "BrainBumpTest";
		//chat = new ChatView();
		numIdeas=0;
		numUsers=0;
		
	}
	
	
	public void showInfo(){
		
		for(int i = 0; i < numIdeas;i++){
			Idea cur = ideas[i];
			System.out.println(cur.getString()+"|"+cur.getRating()+"|"+cur.getDoc().getPath());
		}
		for(int i = 0; i < numUsers;i++){
			User cur = users[i];
			System.out.println(cur.getUsername()+"|"+cur.getPassword());
		}
		
		JTextArea textArea = chat.getTextArea();
		String chatText = textArea.getText();
		String[] texts = chatText.split("<");
		for(int i = 1; i < texts.length;i++){
			System.out.println("<"+texts[i]);
		}
	}
	
	
	public ChatView getChatView() {
		return chat;
	}

	public void setChatView(ChatView chat) {
		this.chat = chat;
	}

	public Idea[][] getGroups(){
		return groups;
	}
	
	public int getNumIdeas() {
		return numIdeas;
	}

	public void setNumIdeas(int numIdeas) {
		this.numIdeas = numIdeas;
	}

	public String getName(){
		return name;
	}
	
	public Idea[] getIdeas(){
		return ideas;
	}
	public void addIdea(Idea i){
		ideas[numIdeas] = i;
	}
	
	public User[] getUsers(){
		return users;
	}
	public void addUser(User u){
		users[numUsers] = u;
	}

	public int getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(int numUsers) {
		this.numUsers = numUsers;
	}
	
	
	public static void main(String[] args){
		
		Model mm = new Model();
		JTextArea ta = mm.chat.getTextArea();
		ta.setText("<Username>: Other words. \n <New line user>: other stuff");
		
		JTextArea textArea = ta;
		String chatText = textArea.getText();
		String[] texts = chatText.split("<");
		for(int i = 1; i < texts.length;i++){
			System.out.println("<"+texts[i]);
		}
		
	}
}
