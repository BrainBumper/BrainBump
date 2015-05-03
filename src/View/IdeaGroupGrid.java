package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

import model.MainClientModel;

public class IdeaGroupGrid extends JPanel
{
	JPanel gridPanel = new JPanel();
	
	private MainClientModel model;
	
	public IdeaGroupGrid(MainClientModel model)
	{
		super(new BorderLayout());
		this.model = model;
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		JButton topic = new JButton("TOPIC: Lemonade Stands");
		add(topic, BorderLayout.NORTH);
		
		
		gridPanel.setLayout(new GridLayout(2,2));
		placeIdeas(gridPanel);
		
		add(gridPanel, BorderLayout.CENTER);
		
	}
	
	private void placeIdeas(JPanel grid)
	{
		grid.add(new IdeaPanel("Location", 3, model));
		grid.add(new IdeaPanel("Ingredients", 1, model));
		grid.add(new IdeaPanel("Marketing", 5, model));
	}
}
