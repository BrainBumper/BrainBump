package model;

import java.io.File;


public class Idea {
	
	String idea, author;
	int rating = 0, order, numComments = 0, group=-1;
	boolean favorited;
	String[] comments = new String[50];
	File doc;
	
	public Idea(){
		
	}
	
	
	public Idea(String idea, String author, File doc){
		
		boolean valid;
		if(idea.length() < 1000||idea.contains("\\|")||idea.contains("\\*"))
			valid = false;
		else
			valid = true;
		this.idea = idea;
		this.author = author;
		this.doc = doc;
		
	}
	
	
	public Idea(String idea, String author, int group, int rating, int order
			, String path, boolean favorited, int numComments, String[] comments){
		
		this.idea = idea;
		this.author = author;
		this.rating = rating;
		this.order = order;
		this.numComments = numComments;
		this.group = group;
		this.favorited = favorited;
		this.comments = comments;
		doc = new File(path);
		
	}
	
	public Idea(int notNeeded){	//Creates an idea with random data
		
		rating = (int)(Math.random()*100);
		idea = "Idea Saved "+rating;
		for(int i = 0; i < 5;i++){
			comments[i] = "Idea comments "+order+" "+rating+" "+i;
		}
		doc = new File("attached.txt");
		
	}
	
	public int getGroupNum(){
		return group;
	}
	
	public String getString(){
		return idea;
	}

	public void setString(String idea) {
		this.idea = idea;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int num) {
		this.order = num;
	}

	public boolean isFav() {
		return favorited;
	}

	public void setFav(boolean fav) {
		this.favorited = fav;
	}

	public String[] getComments() {
		return comments;
	}

	public void setComments(String[] comments) {
		this.comments = comments;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumComments() {
		return numComments;
	}

	public void setNumComments(int cNum) {
		this.numComments = cNum;
	}

	public void setGroup(int num) {
		group = num;
		
	}
	
}
