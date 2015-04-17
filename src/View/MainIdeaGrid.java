package view;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;


public class MainIdeaGrid extends JPanel implements ComponentListener
{
	JPanel gridPanel = new JPanel();
	private IdeaPanel[] ideas = new IdeaPanel[50];
	
	public MainIdeaGrid()
	{
		super(new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		JButton topic = new JButton("TOPIC: Lemonade Stands");
		add(topic, BorderLayout.NORTH);
		
		gridPanel.setLayout(new GridLayout(2,2));
		placeIdeas(gridPanel);
		
		add(gridPanel, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	private void placeIdeas(JPanel grid)
	{
		ideas[0] = (IdeaPanel) grid.add(new IdeaPanel("Lemonade stands at bus stops", 1));
		ideas[0].addComponentListener(this);
		ideas[1] = (IdeaPanel) grid.add(new IdeaPanel("Use limes instead of lemons", -5));
		ideas[1].addComponentListener(this);
		ideas[2] = (IdeaPanel) grid.add(new IdeaPanel("Put puppies near the lemonade", 4));
		ideas[2].addComponentListener(this);
		ideas[3] = (IdeaPanel) grid.add(new IdeaPanel("Use hands instead of cups", -3));
		ideas[3].addComponentListener(this);
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		for(int i = 0; i < ideas.length; i++){
			if (e.getSource() == ideas[i]){
				//setVisible(false);
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
