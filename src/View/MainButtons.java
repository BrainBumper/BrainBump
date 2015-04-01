package View;
import java.awt.*;
import javax.swing.*;


public class MainButtons extends JPanel
{
	public MainButtons()
	{
		super(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		centerPanel.add(new JButton("Add Idea"));
		
		centerPanel.add(new JLabel("Sort By:"));
		
		String[] orgOptions = {"Newest", "Oldest", "Most Popular", "Starred"};
		centerPanel.add(new JComboBox(orgOptions));
		
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new FlowLayout());
		
		eastPanel.add(new JButton("Toggle Chat View"));
		eastPanel.add(new JButton("Start/End Chat"));
		
		add(eastPanel, BorderLayout.EAST);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new FlowLayout());
		
		westPanel.add(new JButton("Quit"));
		westPanel.add(new JButton("Lock/Unlock Session"));
		
		add(westPanel, BorderLayout.WEST);
	}
}
