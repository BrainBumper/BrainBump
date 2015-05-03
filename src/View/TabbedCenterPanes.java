package view;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import model.MainClientModel;


public class TabbedCenterPanes extends JTabbedPane implements ComponentListener
{
	private MainIdeaGrid main;
	private IdeaGroupGrid group;
	
	private MainClientModel model;
	
	public TabbedCenterPanes(MainClientModel model)
	{
		this.model = model;
		main = new MainIdeaGrid(model);
		addTab("Main", null, main,
                "Main Page for Ideas");
		main.addComponentListener(this);
		
		group = new IdeaGroupGrid(model);
		addTab("Groups", null, group,
				"Idea Groupings");
		group.addComponentListener(this);
		
		setVisible(true);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		if (e.getSource() == main){
			if (main.getAddIdeaPage()){
				setVisible(false);	
			}
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
