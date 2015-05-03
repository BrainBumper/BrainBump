package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.MainClientModel;


public class MainButtons extends JPanel
{
	private MainClientModel model;
	
	private boolean removeChatView = false, isAddIdea = false, isQuit = false;
	
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
		addIdea.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		isAddIdea = true;
        		setVisible(false);
        	}
        });
		
		centerPanel.add(new JLabel("Sort By:"));
		
		String[] orgOptions = {"Newest", "Oldest", "Most Popular", "Starred"};
		centerPanel.add(options = new JComboBox(orgOptions));
		
		add(centerPanel, BorderLayout.CENTER);
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new FlowLayout());
		
		eastPanel.add(toggleView = new JButton("Toggle Chat View"));
		toggleView.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		removeChatView = !removeChatView;
        		setVisible(false);
        	}
        });
		
		if(model.isAdmin())
			eastPanel.add(startChat = new JButton("Start/End Chat"));
		
		add(eastPanel, BorderLayout.EAST);
		
		westPanel = new JPanel();
		westPanel.setLayout(new FlowLayout());
		
		westPanel.add(quit = new JButton("Quit"));
		quit.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		isQuit = true;
        		setVisible(false);
        	}
        });

		
		if (model.isAdmin())
			westPanel.add(lockSesh = new JButton("Lock/Unlock Session"));
		
		add(westPanel, BorderLayout.WEST);
	}
	
	public boolean isRemoveChat(){
		return removeChatView;
	}
	
	public boolean isAddIdea(){
		return isAddIdea;
	}
	
	public boolean isQuit(){
		return isQuit;
	}
}
