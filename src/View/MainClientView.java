package view;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import model.MainClientModel;


public class MainClientView extends JPanel implements ComponentListener
{
	TabbedCenterPanes tabbedPanes;
	MainButtons mainButtons;
	UserListView userListView;
	ChatView chatView;
	IdeaPageView ideaPage;
	
	MainClientModel model;
	
	public MainClientView(MainClientModel model)
	{	
		super(new BorderLayout());
		this.model = model;
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		setSize(1200, 600);
		
		add(tabbedPanes = new TabbedCenterPanes(model), BorderLayout.CENTER);
		tabbedPanes.addComponentListener(this);
		add(mainButtons = new MainButtons(model), BorderLayout.SOUTH);
		add(userListView = new UserListView(model), BorderLayout.WEST);
		add(chatView = new ChatView(model), BorderLayout.EAST);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		if (e.getSource() == tabbedPanes){
			remove(tabbedPanes);
			add(ideaPage = new IdeaPageView(), BorderLayout.CENTER);
		}
		
		validate();	
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
