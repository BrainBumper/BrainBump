package view;
import java.awt.*;

import javax.swing.*;

import model.MainClientModel;


public class MainButtons extends JPanel
{
	private MainClientModel model;
	
	private JPanel centerPanel, eastPanel, westPanel;
	private JButton addIdea, toggleView, startChat, quit, lockSesh;
	private JComboBox options;
	
	public MainButtons(MainClientModel model)
	{
		super(new BorderLayout());
		this.model = model;
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		centerPanel.add(addIdea = new JButton("Add Idea"));
		
		centerPanel.add(new JLabel("Sort By:"));
		
		String[] orgOptions = {"Newest", "Oldest", "Most Popular", "Starred"};
		centerPanel.add(options = new JComboBox(orgOptions));
		
		add(centerPanel, BorderLayout.CENTER);
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new FlowLayout());
		
		eastPanel.add(toggleView = new JButton("Toggle Chat View"));
		
		if(model.isAdmin())
			eastPanel.add(startChat = new JButton("Start/End Chat"));
		
		add(eastPanel, BorderLayout.EAST);
		
		westPanel = new JPanel();
		westPanel.setLayout(new FlowLayout());
		
		westPanel.add(quit = new JButton("Quit"));
		
		if (model.isAdmin())
			westPanel.add(lockSesh = new JButton("Lock/Unlock Session"));
		
		add(westPanel, BorderLayout.WEST);
	}
}
