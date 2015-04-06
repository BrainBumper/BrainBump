
import java.awt.*;
import javax.swing.*;


public class TabbedCenterPanes extends JTabbedPane
{
	public TabbedCenterPanes()
	{
		JComponent main = new MainIdeaGrid();
		addTab("Main", null, main,
                "Main Page for Ideas");
		
		JComponent group = new IdeaGroupGrid();
		addTab("Groups", null, group,
				"Idea Groupings");
		
	}
}
