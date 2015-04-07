package View;
import java.awt.*;

import javax.swing.*;


public class IdeaPageView extends JPanel
{
	public IdeaPageView()
	{
		super(new GridLayout(4,0));
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		setSize(1200,600);
		
		JButton title = new JButton("Use hands instead of cups");
		add(title);
		
		JTextArea description = new JTextArea("Description: \n\tIf we use hands instead of cups "
				+ "we will save the money that we would have spent on cups. \nThis allows us"
				+ "to make more profit!");
		
		description.setEditable(false);
		add(description);
		
		JPanel commentPanel = new JPanel();
		setCommentPanel(commentPanel);
		add(commentPanel);
		
		JPanel buttonPanel = new JPanel();
		setButtonPanel(buttonPanel);
		add(buttonPanel);
		
	}

	private void setCommentPanel(JPanel commentPanel)
	{
		commentPanel.setLayout(new GridLayout(2,0));
		
		JPanel comment1 = new JPanel();
		comment1.setLayout(new BorderLayout());
		
		comment1.add(new JButton("What if the consumers lose the product when it"
				+ " slips between their fingers?"), BorderLayout.CENTER);
		
		JPanel ratingPanel1 = new JPanel();
		setRatingPanel(ratingPanel1, 6);
		comment1.add(ratingPanel1, BorderLayout.EAST);
		
		JPanel comment2 = new JPanel();
		comment2.setLayout(new BorderLayout());
		
		comment2.add(new JButton("This is one of the most intelligent ideas this company has ever seen, "
				+ "and I can't imagine anything less than this redefining the lemonade stand industry as "
				+ "we know it. Great work."), BorderLayout.CENTER);
		
		JPanel ratingPanel2 = new JPanel();
		setRatingPanel(ratingPanel2, 300);
		comment2.add(ratingPanel2, BorderLayout.EAST);
		
		commentPanel.add(comment1);
		commentPanel.add(comment2);
		
	}
	
	private void setRatingPanel(JPanel ratingPanel, int rating)
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
	
	private void setButtonPanel(JPanel buttonPanel)
	{
		buttonPanel.setLayout(new BorderLayout());
		
		buttonPanel.add(new JButton("Cancel"), BorderLayout.WEST);
		buttonPanel.add(new JButton("Add Comment"), BorderLayout.EAST);
		
	}
}
