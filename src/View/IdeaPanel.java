package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

import model.MainClientModel;


public class IdeaPanel extends JPanel
{
	private String ideaText;
	private int rating;
	
	private boolean addIdeaPage = false;
	
	private boolean starred = false;
	
	JPanel ratingPanel, adminPanel;
	JLabel ratingLabel;
	JButton idea, upButton, dButton, starButton, removeButton;
	
	private MainClientModel model;
	
	public IdeaPanel(String ideaText, int rating, MainClientModel model)
	{
		super (new BorderLayout());
		this.model = model;
		setBorder(new TextBubbleBorder(Color.blue, 3, 10, 0));
		
		this.ideaText = ideaText;
		this.rating = rating;
		
		idea = new JButton(ideaText);
		idea.addActionListener(new ActionListener(){ // action Listen for JButton #2
			public void actionPerformed(ActionEvent e) {
				addIdeaPage = true;
				setVisible(false);	
			}		
		});
		idea.setBackground(Color.LIGHT_GRAY);
		add(idea, BorderLayout.CENTER);
		
		ratingPanel = new JPanel();
		setRatingPanel(ratingPanel);
		add(ratingPanel, BorderLayout.EAST);
		
		if (model.isAdmin()){
			adminPanel = new JPanel();
			setAdminPanel(adminPanel);
			add(adminPanel, BorderLayout.WEST);
		}
	}
	
	private void setRatingPanel(JPanel ratingPanel)
	{
		ratingPanel.setLayout(new GridLayout(3,0));
		
		upButton = new JButton();
		upButton.addActionListener(new ActionListener(){ // action Listen for JButton #2
			public void actionPerformed(ActionEvent e) { // 
				setRatingLabel(1);		
			}		
		});
		upButton.setIcon(new ImageIcon("src/Resources/upArrow.png"));
		
		ratingPanel.add(upButton);
		
		ratingLabel = new JLabel(Integer.toString(rating));
		ratingPanel.add(ratingLabel);
		
		dButton = new JButton();
		dButton.addActionListener(new ActionListener(){ // action Listen for JButton #2
			public void actionPerformed(ActionEvent e) { // 
				setRatingLabel(-1);		
			}		
		});
		dButton.setIcon(new ImageIcon("src/Resources/downArrow.png"));
		
		ratingPanel.add(dButton);
	}
	
	private void setAdminPanel(JPanel adminPanel)
	{
		adminPanel.setLayout(new GridLayout(2,0));
		
		starButton = new JButton();
		starButton.addActionListener(new ActionListener(){ // action Listen for JButton #2
			public void actionPerformed(ActionEvent e) { // 
				swapIcon();		
			}		
		});
		starButton.setIcon(new ImageIcon("src/Resources/star.png"));
		
		adminPanel.add(starButton);
		
		removeButton = new JButton("Remove Idea");
		
		adminPanel.add(removeButton);
	}
	
	private void swapIcon(){
		if (!starred){
			starButton.setIcon(new ImageIcon("src/Resources/star2.png"));
			starred = !starred;
		}
		else{
			starButton.setIcon(new ImageIcon("src/Resources/star.png"));
			starred = !starred;
		}
	}
	
	private void setRatingLabel(int add){
		ratingLabel.setText(Integer.toString(rating += add));
	}
	
	public boolean getAddIdeaPage(){
		return addIdeaPage;
	}
}