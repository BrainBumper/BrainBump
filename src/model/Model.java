
public class Model {
	
	
	User aa = new User(1), bb = new User(1), cc = new User(1), dd = new User(1), ee = new User(1), ff = new User(1);
	Idea a = new Idea(1), b = new Idea(1), c = new Idea(1), d = new Idea(1), e = new Idea(1), f = new Idea(1), g= new Idea(1), h= new Idea(1);
	String name;
	Collection ideas;
	Collection users;
	int numUsers = 0, numIdeas = 0;
	Collection[] groups;
	ChatView chat;
	
	public Model(){
		
		name = "BrainBumpTest";
		chat = new ChatView();
		a.setOrder(0);
		b.setOrder(1);
		c.setOrder(2);
		d.setOrder(3);
		e.setOrder(4);
		f.setOrder(5);
		g.setOrder(6);
		h.setOrder(7);
		
	}
	
	public Model(int n){
		name = "BrainBumpTest";
		chat = new ChatView();
		numIdeas=0;
		numUsers=0;
	}
	
	
	public void showInfo(){
		for(int i = 0; i < numIdeas;i++){
			Idea cur = (Idea) ideas.getElement(i);
			System.out.println(cur.getString()+"|"+cur.getRating()+"|");
		}
		for(int i = 0; i < numUsers;i++){
			User cur = (User) users.getElement(i);
			System.out.println(cur.getID()+"|"+cur.getPass());
		}
		String[] coms = chat.getAccesible();	//Get text from JTextArea and store the data
		for(int i = 0; i < chat.getNumComments();i++){
			System.out.println(coms[i]);
		}
	}
	
	
	public ChatView getChatView() {
		return chat;
	}

	public void setChatView(ChatView chat) {
		this.chat = chat;
	}

	public Collection[] getGroups(){
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
	
	public Collection getIdeas(){
		return ideas;
	}
	public void addIdea(Idea i){
		ideas.add(i);
	}
	
	public Collection getUsers(){
		return users;
	}
	public void addUser(User u){
		users.add(u);
	}

	public int getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(int numUsers) {
		this.numUsers = numUsers;
	}
	
	
	public static void main(String[] args){
		
	}
}
