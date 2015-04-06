import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ViewOrganizer extends JPanel implements ComponentListener
{
	private JPanel mainPanel = new JPanel();
	
	private static JPanel loginView;
	private JPanel regView;
	private JPanel sessionListView;
	
	private JPanel sessionCreateView;
	
	private JPanel mainClientView;
	private JPanel mainAdminView;
	
	private JPanel ideaPageView;
	private JPanel textCreateView;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame window = new JFrame("BrainBump");
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
		loginView = new LoginView();
		regView = new RegisterView();
		sessionListView = new SessionListView();
		sessionCreateView = new SessionCreateView();
		mainClientView = new MainClientView();
		ideaPageView = new IdeaPageView();
		textCreateView = new TextCreateView();
		
		mainPanel.add(loginView, BorderLayout.CENTER);
		
	}
	
	public void LoginView(){
		loginView.addComponentListener(this);
		loginView.setPreferredSize(loginView.getSize());
	}
	
	public void regView(){
		regView.addComponentListener(this);
		regView.setPreferredSize(regView.getSize());
	}
	
	public void sessionListView(){
		sessionListView.addComponentListener(this);
		sessionListView.setPreferredSize(sessionListView.getSize());
	}
	
	public void sessionCreateView(){
		sessionCreateView.addComponentListener(this);
		sessionCreateView.setPreferredSize(sessionListView.getSize());
	}
	
	public void mainClientView(){
		mainClientView.addComponentListener(this);
		mainClientView.setPreferredSize(mainClientView.getSize());
	}
	
	public void ideaPageView(){
		ideaPageView.addComponentListener(this);
		ideaPageView.setPreferredSize(ideaPageView.getSize());
	}
	
	public void textCreateView(){
		textCreateView.addComponentListener(this);
		textCreateView.setPreferredSize(textCreateView.getSize());
		
	}
	
	public void hideLoginView(){
		
	}
	
	
	
	
	@Override
	public void componentHidden(ComponentEvent e){
		if (e.getSource() == loginView){
			
				
	
		}
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
