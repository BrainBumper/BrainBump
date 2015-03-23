import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;


public class SessionListView extends JPanel
{
	private boolean DEBUG = false;
	
	public SessionListView()
	{
		super(new BorderLayout());
		setSize(500,300);
		this.setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		 JTable table = new JTable(new MyTableModel());
	        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
	        table.setFillsViewportHeight(true);
	        
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.setDefaultRenderer(String.class, centerRenderer); 
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
	 
	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);
	 
	        //Add the scroll pane to this panel.
	        add(scrollPane);
	        
	        add(table, BorderLayout.NORTH);
	        
	        JPanel southPanel = new JPanel();
	        
	        southPanel.add(new JButton("Log Out"));
	        southPanel.add(new JButton("Create New Session"));
	        southPanel.add(new JButton("Join Session"));
	        
	        add(southPanel, BorderLayout.SOUTH);
	}
	
	 class MyTableModel extends AbstractTableModel {
		 
		private String[] columnNames = {"Server Name", 
										"Available Spots",
										"Password Protected"};
		
		private Object[][] data = {
				{"Test Server", new Integer(20), "Y"}
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
            if (col < 2) {
                return false;
            } else {
                return true;
            }
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
