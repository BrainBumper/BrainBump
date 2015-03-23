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
	
	private JPanel loginView;
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
	
	public JPanel getMainPanel()
	{
		return mainPanel;
	}
	
	public ViewOrganizer()
	{
		mainPanel.setLayout(new BorderLayout());
		
		loginView = new LoginView();
		loginView.addComponentListener(this);
		loginView.setPreferredSize(loginView.getSize());
		
		regView = new RegisterView();
		regView.addComponentListener(this);
		regView.setPreferredSize(regView.getSize());
		
		sessionListView = new SessionListView();
		sessionListView.addComponentListener(this);
		sessionListView.setPreferredSize(sessionListView.getSize());
		
		sessionCreateView = new SessionCreateView();
		sessionCreateView.addComponentListener(this);
		sessionCreateView.setPreferredSize(sessionCreateView.getSize());
		
		mainClientView = new MainClientView();
		mainClientView.addComponentListener(this);
		mainClientView.setPreferredSize(mainClientView.getSize());
		
		ideaPageView = new IdeaPageView();
		ideaPageView.addComponentListener(this);
		ideaPageView.setPreferredSize(ideaPageView.getSize());
		
		textCreateView = new TextCreateView();
		textCreateView.addComponentListener(this);
		textCreateView.setPreferredSize(textCreateView.getSize());
		
		mainPanel.add(mainClientView, BorderLayout.CENTER);
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
