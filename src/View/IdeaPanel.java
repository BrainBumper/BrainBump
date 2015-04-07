package View;
import java.awt.*;

import javax.swing.*;


public class IdeaPanel extends JPanel
{
	private String ideaText;
	private int rating;
	
	public IdeaPanel(String ideaText, int rating)
	{
		super (new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 3, 10, 0));
		
		this.ideaText = ideaText;
		this.rating = rating;
		
		JButton idea = new JButton(ideaText);
		idea.setBackground(Color.LIGHT_GRAY);
		add(idea, BorderLayout.CENTER);
		
		JPanel ratingPanel = new JPanel();
		setRatingPanel(ratingPanel);
		add(ratingPanel, BorderLayout.EAST);
		
		JPanel adminPanel = new JPanel();
		setAdminPanel(adminPanel);
		add(adminPanel, BorderLayout.WEST);
	}
	
	private void setRatingPanel(JPanel ratingPanel)
	{
		ratingPanel.setLayout(new GridLayout(3,0));
		
		JButton upButton = new JButton();
		upButton.setIcon(new ImageIcon("src/Resources/upArrow.png"));
		
		ratingPanel.add(upButton);
		
		JLabel ratingLabel = new JLabel(Integer.toString(rating));
		ratingPanel.add(ratingLabel);
		
		JButton dButton = new JButton();
		dButton.setIcon(new ImageIcon("src/Resources/downArrow.png"));
		
		ratingPanel.add(dButton);
	}
	
	private void setAdminPanel(JPanel adminPanel)
	{
		adminPanel.setLayout(new GridLayout(2,0));
		
		JButton starButton = new JButton();
		starButton.setIcon(new ImageIcon("src/Resources/star.png"));
		
		adminPanel.add(starButton);
		
		JButton removeButton = new JButton("Remove Idea");
		
		adminPanel.add(removeButton);
	}
}
