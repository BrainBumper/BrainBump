import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
	
	Session session;
	File file;
	
	public Storage(int n) throws IOException{	//Test constructor
		session = new Session();
		save();
		System.out.println("\n=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		session = new Session(1);
		open(session.getName());
	}
	
	public void save(){				//Key Symbols: | splitter * comment splitter
		FileWriter saveFile = null;
		
		try {
			saveFile = new FileWriter(session.getName()+".txt");	//File creation
		} catch (IOException e) {
			System.out.println("File creation failed");
			e.printStackTrace();
		}
		
		String[] compactIdeas = new String[session.getNumIdeas()];		//Puts data into a String[]
		System.out.println(session.getNumIdeas());
		for(int i = 0; i < session.getNumIdeas(); i++){	//Idea
			Idea focus = session.getIdeas()[i];
			String current = focus.getString()+"|"+focus.getAuthor()+"|"+focus.getGroupNum()+"|"+focus.getRating()+"|"+focus.getOrder()+"|"+focus.getDoc().getPath()+"|"+Boolean.toString(focus.isFav())+"|"+focus.getNumComments();
			for(int q = 0; q<focus.getNumComments();q++){
				current=current+focus.getComments()[q]+"*";
			}
			compactIdeas[i] = current;
		}
		
		String[] compactUsers = new String[session.getNumUsers()];		//Users
		for(int i = 0; i < session.getNumUsers(); i++){
			compactUsers[i] = session.getUsers()[i].getID()+"|"+session.getUsers()[i].getPass();
		}
		
		String[] compactChat = new String[session.getChatWindow().getNumComments()];	//Chat
		for(int i = 0; i < session.getChatWindow().getNumComments(); i++){
			compactChat[i] = session.getChatWindow().getComments()[i];
		}
		
		try{			//Writing into the file
			
			
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
		
		while(line!= null){		//Read through lines
			
			String working;		//The current string being loaded
			
			if(line.indexOf(":")<0)	//Blank lines
				what = "skip";
			else
				what = line.substring(0, line.indexOf(":"));
			if(what.equals("Ideas")){							//Stored idea
				
				working = line.substring(line.indexOf(":")+1);
				String[] parts = working.split("\\|");
				String[] comm = parts[7].split("\\*");
				Idea current = new Idea(parts[0],parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),parts[5],Boolean.getBoolean(parts[6]),comm.length,comm);
				
				session.addIdea(current);
			}else if(what.equals("Users")){						//Stored user
				User current = new User(1);
				working = line.substring(line.indexOf(":")+1);
				String[] sp = working.split("\\|");
				current.setID(sp[0]);
				current.setPass(sp[1]);
				session.addUser(current);
			}else if(what.equals("Chat")){						//Stored chat comments
				ChatWindow current = session.getChatWindow();
				working = line.substring(line.indexOf(":")+1);
				current.addCom(working);
			}
			line = saveFile.readLine();
		}
		saveFile.close();
		session.showInfo();			//Check reloaded content
	}
	
//	public static void main(String[] args){
//		try {
//			new Storage(1);
//		} catch (IOException e) {
//			System.out.println("Save failed");
//			e.printStackTrace();
//		}
//	}
	
}
