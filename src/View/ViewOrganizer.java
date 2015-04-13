package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.*;
import user.User;

public class ViewOrganizer extends JPanel implements ComponentListener
{
	public static JFrame window;
	private static JPanel mainPanel = new JPanel();
	
	private static LoginView loginView;
	private static RegisterView regView;
	private static SessionListView sessionListView;
	private static SessionCreateView sessionCreateView;
	private static MainClientView mainClientView;
	private static MainClientView mainAdminView;
	private static IdeaPageView ideaPageView;
	private static TextCreateView textCreateView;
	
	public User user;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				window = new JFrame("BrainBump");
				window.add(new ViewOrganizer().getMainPanel());
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				window.pack();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
	}
	
	public JPanel getMainPanel(){
		return mainPanel;
	}
	
	public ViewOrganizer(){
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(getLoginView(), BorderLayout.CENTER);
		setVisible(true);
	}
	
	public LoginView getLoginView(){
		loginView = new LoginView(new LoginModel());
		loginView.addComponentListener(this);
		loginView.setPreferredSize(loginView.getSize());
		return(loginView);
	}
	
	public RegisterView getRegView(){
		regView = new RegisterView();
		regView.addComponentListener(this);
		regView.setPreferredSize(regView.getSize());
		return(regView);
	}
	
	public SessionListView getSessionListView(){
		sessionListView = new SessionListView(new SessionListModel(user));
		sessionListView.addComponentListener(this);
		sessionListView.setPreferredSize(sessionListView.getSize());
		return(sessionListView);
	}
	
	public SessionCreateView getSessionCreateView(){
		sessionCreateView = new SessionCreateView(
				new SessionCreateModel(user));
		sessionCreateView.addComponentListener(this);
		sessionCreateView.setPreferredSize(sessionCreateView.getSize());
		return(sessionCreateView);
	}
	
	public MainClientView getMainClientView(){
		mainClientView = new MainClientView();
		mainClientView.addComponentListener(this);
		mainClientView.setPreferredSize(mainClientView.getSize());
		return(mainClientView);
	}
	
	public IdeaPageView getIdeaPageView(){
		ideaPageView = new IdeaPageView();
		ideaPageView.addComponentListener(this);
		ideaPageView.setPreferredSize(ideaPageView.getSize());
		return(ideaPageView);
	}
	
	public TextCreateView getTextCreateView(){
		textCreateView = new TextCreateView();
		textCreateView.addComponentListener(this);
		textCreateView.setPreferredSize(textCreateView.getSize());
		return(textCreateView);
		
	}	
	@Override
	public void componentHidden(ComponentEvent e){
		if (e.getSource() == loginView){
			mainPanel.remove(loginView);
			if(loginView.addRegPanel()){
				mainPanel.add(getRegView(), BorderLayout.CENTER);
			}
			else{
				user = new User(loginView.getModel().getUser(),
						loginView.getModel().getPass());
				mainPanel.add(getSessionListView(), BorderLayout.CENTER);
			}
		}		
		if (e.getSource() == regView){
			mainPanel.remove(regView);
			if(regView.addLoginPanel()){
				mainPanel.add(getLoginView(), BorderLayout.CENTER);
			}
		}
		if (e.getSource() == sessionListView){
			mainPanel.remove(sessionListView);
			if (sessionListView.addLogOut()){
				mainPanel.add(getLoginView(), BorderLayout.CENTER);
			}
		}
		
		if (e.getSource() == sessionListView){
			mainPanel.remove(sessionListView);
			if (sessionListView.addCreateNewSesh()){
				mainPanel.add(getSessionCreateView(), BorderLayout.CENTER);
			}
		}
		
		if (e.getSource() == sessionListView){
			mainPanel.remove(sessionListView);
			if(sessionListView.joinNewSesh()){
				mainPanel.add(getMainClientView(), BorderLayout.CENTER);
			}
		}
		
		if (e.getSource() == sessionCreateView){
			mainPanel.remove(sessionCreateView);
			if(sessionCreateView.addCancel()){
				mainPanel.add(getSessionListView(),BorderLayout.CENTER);
			}
			else{
				mainPanel.add(getMainClientView(), BorderLayout.CENTER);
			}
		}
		window.validate();
		window.pack();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		window.validate();
		window.pack();
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
