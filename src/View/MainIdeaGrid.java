package view;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import model.MainClientModel;


public class MainIdeaGrid extends JPanel implements ComponentListener
{
	JPanel gridPanel = new JPanel();
	private IdeaPanel[] ideas = new IdeaPanel[50];
	
	private boolean addIdeaPage = false;
	
	private MainClientModel model;
	
	public MainIdeaGrid(MainClientModel model)
	{
		super(new BorderLayout());
		this.model = model;
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		JButton topic = new JButton("TOPIC: Lemonade Stands");
		add(topic, BorderLayout.NORTH);
		
		gridPanel.setLayout(new GridLayout(2,2));
		placeIdeas();
		
		add(gridPanel, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	private void placeIdeas()
	{
		ideas[0] = (new IdeaPanel("Lemonade stands at bus stops", 1, model));
		ideas[0].addComponentListener(this);
		ideas[1] = (new IdeaPanel("Use limes instead of lemons", -5, model));
		ideas[1].addComponentListener(this);
		ideas[2] = (new IdeaPanel("Put puppies near the lemonade", 4, model));
		ideas[2].addComponentListener(this);
		ideas[3] = (new IdeaPanel("Use hands instead of cups", -3, model));
		ideas[3].addComponentListener(this);
		
		int i = 0;
		
		while (ideas[i] != null){
			gridPanel.add(ideas[i]);
			i++;
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		int i = 0;
		while (ideas[i] != null){
			if (e.getSource() == ideas[i]){
				if (ideas[i].getAddIdeaPage()){
					addIdeaPage = true;
					setVisible(false);
				}
			}
			i++;
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
	
	public boolean getAddIdeaPage(){
		return addIdeaPage;
	}
}
