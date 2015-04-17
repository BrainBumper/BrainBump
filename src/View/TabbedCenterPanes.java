package view;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;


public class TabbedCenterPanes extends JTabbedPane implements ComponentListener
{
	private JComponent main, group;
	public TabbedCenterPanes()
	{
		main = new MainIdeaGrid();
		main.addComponentListener(this);
		addTab("Main", null, main,
                "Main Page for Ideas");
		
		group = new IdeaGroupGrid();
		group.addComponentListener(this);
		addTab("Groups", null, group,
				"Idea Groupings");
		
		setVisible(true);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		if (e.getSource() == main){
			//setVisible(false);
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
