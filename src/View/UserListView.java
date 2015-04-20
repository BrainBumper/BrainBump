package view;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import model.MainClientModel;


public class UserListView extends JPanel
{
	private boolean DEBUG = false;
	
	private JTable userTable;
	
	private JPanel southPanel;
	
	private MainClientModel model;
	
	public UserListView(MainClientModel model)
	{
		super(new BorderLayout());
		this.model = model;
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		userTable = new JTable(new MyTableModel());
        userTable.setPreferredScrollableViewportSize(new Dimension(200, 250));
        userTable.setFillsViewportHeight(true);
        
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		userTable.setDefaultRenderer(String.class, centerRenderer); 
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(userTable);
        
        add(scrollPane, BorderLayout.NORTH);
        
        southPanel = new JPanel();
        
        if (model.isAdmin())
        	southPanel.add(new JButton("Remove User"));
        
        add(southPanel, BorderLayout.SOUTH);
	}
	
	class MyTableModel extends AbstractTableModel {

		 private String[] columnNames = {"User", 
				 						"Status"};

		 private Object[][] data = {
				 {"Cameron Cole", "Online"},
				 {"Russell Brown", "Online"},
				 {"Matthew Oliver", "Offline"}
		 };

		 @Override
		 public int getColumnCount() {
			 return columnNames.length;
		 }

		 @Override
		 public int getRowCount() {
			 return data.length;
		 }

		 public String getColumnName(int col)
		 {
			 return columnNames[col];
		 }

		 public Object getValueAt(int row, int col)
		 {
			 return data[row][col];
		 }

		 /*
		  * JTable uses this method to determine the default renderer/
		  * editor for each cell.  If we didn't implement this method,
		  * then the last column would contain text ("true"/"false"),
		  * rather than a check box.
		  */
		 public Class getColumnClass(int c) {
			 return getValueAt(0, c).getClass();
		 }

		 /*
		  * Don't need to implement this method unless your table's
		  * editable.
		  */
		 public boolean isCellEditable(int row, int col) {
			 //Note that the data/cell address is constant,
			 //no matter where the cell appears onscreen.
			 return false;
		 }

		 /*
		  * Don't need to implement this method unless your table's
		  * data can change.
		  */
		 public void setValueAt(Object value, int row, int col) {
			 if (DEBUG) {
				 System.out.println("Setting value at " + row + "," + col
						 + " to " + value
						 + " (an instance of "
						 + value.getClass() + ")");
			 }

			 data[row][col] = value;
			 fireTableCellUpdated(row, col);

			 if (DEBUG) {
				 System.out.println("New value of data:");
				 printDebugData();
			 }
		 }

		 private void printDebugData() {
			 int numRows = getRowCount();
			 int numCols = getColumnCount();

			 for (int i=0; i < numRows; i++) {
				 System.out.print("    row " + i + ":");
				 for (int j=0; j < numCols; j++) {
					 System.out.print("  " + data[i][j]);
				 }
				 System.out.println();
			 }
			 System.out.println("--------------------------");
		 }

	 }
}
