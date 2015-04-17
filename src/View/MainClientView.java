package view;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;


public class MainClientView extends JPanel implements ComponentListener
{
	TabbedCenterPanes tabbedPanes;
	
	public MainClientView()
	{
		super(new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		setSize(1200, 600);
		
		add(tabbedPanes = new TabbedCenterPanes(), BorderLayout.CENTER);
		tabbedPanes.addComponentListener(this);
		add(new MainButtons(), BorderLayout.SOUTH);
		add(new UserListView(), BorderLayout.WEST);
		add(new ChatView(), BorderLayout.EAST);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		if (e.getSource() == tabbedPanes){
			//setVisible(false);
		}
		
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
