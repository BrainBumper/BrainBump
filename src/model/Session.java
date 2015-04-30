import user.User;


public class Session {
	
	User aa = new User(1), bb = new User(1), cc = new User(1), dd = new User(1), ee = new User(1), ff = new User(1);
	Idea a = new Idea(1), b = new Idea(1), c = new Idea(1), d = new Idea(1), e = new Idea(1), f = new Idea(1), g= new Idea(1), h= new Idea(1);
	String name;
	Idea[] ideas = {a,b,c,d,e,f,g,h},group1, group2;
	User[] users = {aa, bb, cc, dd, ee, ff};
	int numUsers = 0, numIdeas = 0;
	Idea[][] groups;
	ChatWindow chatWindow;
	
	public Session(){
		
		numUsers = 6;
		numIdeas = 8;
		name = "BrainBumpTest";
		chatWindow = new ChatWindow();
		
	}
	
	public Session(int n){
		name = "BrainBumpTest";
		chatWindow = new ChatWindow(0);
		ideas = new Idea[100];
		numIdeas=0;
		numUsers=0;
		users = new User[50];
	}
	
	
	public void showInfo(){
		for(int i = 0; i < numIdeas;i++){
			Idea cur = ideas[i];
			System.out.println(cur.getString()+"|"+cur.getRating()+"|"+cur.getDoc().getPath());
		}
		for(int i = 0; i < numUsers;i++){
			User cur = users[i];
			System.out.println(cur.getID()+"|"+cur.getPass());
		}
		String[] coms = chatWindow.getComments();
		for(int i = 0; i < chatWindow.getNumComments();i++){
			System.out.println(coms[i]);
		}
	}
	
	
	public ChatWindow getChatWindow() {
		return chatWindow;
	}

	public void setChatWindow(ChatWindow chatWindow) {
		this.chatWindow = chatWindow;
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
		i.setOrder(numIdeas);
		ideas[numIdeas++] = i;
	}
	
	public User[] getUsers(){
		return users;
	}
	public void addUser(User u){
		users[numUsers++] = u;
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
