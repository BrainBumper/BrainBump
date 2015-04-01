package View;
import javax.swing.*;

import java.awt.*;


public class TextCreateView extends JPanel
{
	public TextCreateView()
	{
		super(new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		setSize(900,450);
		
		JTextArea input = new JTextArea();
		input.setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		add(input,BorderLayout.CENTER);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		
		buttons.add(new JButton("Cancel"), BorderLayout.WEST);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		centerPanel.add(new JButton("Clear Text"));
		centerPanel.add(new JButton("Attach Document"));
		
		buttons.add(centerPanel, BorderLayout.CENTER);
		
		buttons.add(new JButton("Submit"), BorderLayout.EAST);
		
		add(buttons, BorderLayout.SOUTH);
	}
}
