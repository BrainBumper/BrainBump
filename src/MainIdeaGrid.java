import java.awt.*;
import javax.swing.*;


public class MainIdeaGrid extends JPanel
{
	JPanel gridPanel = new JPanel();
	
	public MainIdeaGrid()
	{
		super(new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		JButton topic = new JButton("TOPIC: Lemonade Stands");
		add(topic, BorderLayout.NORTH);
		
		
		gridPanel.setLayout(new GridLayout(2,2));
		placeIdeas(gridPanel);
		
		add(gridPanel, BorderLayout.CENTER);
		
	}
	
	private void placeIdeas(JPanel grid)
	{
		grid.add(new IdeaPanel("Lemonade stands at bus stops", 1));
		grid.add(new IdeaPanel("Use limes instead of lemons", -5));
		grid.add(new IdeaPanel("Put puppies near the lemonade", 4));
		grid.add(new IdeaPanel("Use hands instead of cups", -3));
	}
}
