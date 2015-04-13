package view;
import java.awt.*;

import javax.swing.*;


public class MainClientView extends JPanel
{
	public MainClientView()
	{
		super(new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		setSize(1200, 600);
		
		add(new TabbedCenterPanes(), BorderLayout.CENTER);
		add(new MainButtons(), BorderLayout.SOUTH);
		add(new UserListView(), BorderLayout.WEST);
		add(new ChatView(), BorderLayout.EAST);
	}
}
