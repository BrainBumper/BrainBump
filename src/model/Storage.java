import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
	
	Session sesh;
	File file;
	Collection ideas, users, chat;
	
	public Storage() throws IOException{	//Test constructor
		sesh = new Session();
		save();
		System.out.println("\n=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		sesh = new Session(1);
		open(sesh.getName());
	}
	
	public void save(){				//Key Symbols: | splitter * comment splitter
		FileWriter saveFile = null;
		
		try {
			saveFile = new FileWriter(sesh.getName()+".txt");	//File creation
		} catch (IOException e) {
			System.out.println("File creation failed");
			e.printStackTrace();
		}
		
		String[] compactIdeas = new String[sesh.getNumIdeas()];		//Putting info into String[]
		System.out.println(sesh.getNumIdeas());
		for(int i = 0; i < sesh.getNumIdeas(); i++){	//Idea
			Idea focus = sesh.getIdeas()[i];
			String current = focus.getString()+"|"+focus.getAuthor()+"|"+focus.getGroupNum()+"|"+focus.getRating()+"|"+focus.getNum()+"|"+focus.getDoc()+"|"+Boolean.toString(focus.isFav())+"|";
			for(int q = 0; q<focus.getcNum();q++){
				current=current+focus.getComments()[q]+"*";
			}
			compactIdeas[i] = current;
		}
		
		String[] compactUsers = new String[sesh.getNumUsers()];		//Users
		for(int i = 0; i < sesh.getNumUsers(); i++){
			compactUsers[i] = sesh.getUsers()[i].getID()+"|"+sesh.getUsers()[i].getPass();
		}
		
		String[] compactChat = new String[sesh.getChatWindow().getNumComments()];	//Chat
		for(int i = 0; i < sesh.getChatWindow().getNumComments(); i++){
			compactChat[i] = sesh.getChatWindow().getComments()[i];
		}
		
		try{		//Writing into the file
			
			
			for(int i = 0; i < compactIdeas.length;i++){
				saveFile.write("\nIdeas:");	//ideas
				saveFile.write(compactIdeas[i]);
				System.out.print("\nIdeas:"+compactIdeas[i]);
			}
			
			for(int i = 0; i < compactUsers.length;i++){
				saveFile.write("\nUsers:");	//Users
				saveFile.write(compactUsers[i]);
				System.out.print("\nUsers:"+compactUsers[i]);
			}
			
			for(int i = 0; i < compactChat.length;i++){
				saveFile.write("\nChat:");	//Chat comments
				saveFile.write(compactChat[i]);
				System.out.print("\nChat:"+compactChat[i]);
			}
			saveFile.close();
			
		}catch(Exception e){
			System.out.println("File saving failed");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void open(String sessionName) throws IOException{
		
		BufferedReader saveFile = new BufferedReader(new FileReader(sessionName+".txt"));
		String line = saveFile.readLine(), what;
		
		while(line!= null){
			
			String working;
			
			if(line.indexOf(":")-1<0)	//Blank lines
				what = "skip";
			else
				what = line.substring(0, line.indexOf(":")-1);
			if(what.equals("Idea")){							//Reload idea
				Idea curr = new Idea(1);
				working = line.substring(line.indexOf(":")+1);
				String[] parts = working.split("\\|");
				curr.setString(parts[0]);
				curr.setAuthor(parts[1]);
//				parts[2]; 										//group
				curr.setRating(Integer.parseInt(parts[3]));
				curr.setNum(Integer.parseInt(parts[4]));
//				curr.setDoc(parts[5]);							//Attach
				curr.setFav(Boolean.getBoolean(parts[6]));
				String[] comm = parts[7].split("\\*");
				curr.setComments(comm);
				curr.setcNum(comm.length);
				sesh.addIdea(curr);
			}else if(what.equals("User")){						//Reload user
				User curr = new User(1);
				working = line.substring(line.indexOf(":")+1);
				String[] sp = working.split("\\|");
				curr.setID(sp[0]);
				curr.setPass(sp[1]);
				sesh.addUser(curr);
			}else if(what.equals("Cha")){						//Reload chat comments
				ChatWindow curr = sesh.getChatWindow();
				working = line.substring(line.indexOf(":")+1);
				curr.addCom(working);
			}
			line = saveFile.readLine();
		}
		saveFile.close();
//		sesh.showInfo();			//Check reloaded content
	}
	
	public static void main(String[] args){
		try {
			new Storage();
		} catch (IOException e) {
			System.out.println("Save failed");
			e.printStackTrace();
		}
	}
	
}
