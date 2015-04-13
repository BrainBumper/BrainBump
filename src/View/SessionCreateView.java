package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import server.SocketServer;
import model.SessionCreateModel;

public class SessionCreateView extends JPanel
{
	private SessionCreateModel model;
	
	private boolean DEBUG = false;
	public boolean addCancel = false;
	
	private JButton cancelButton, createButton;
	
	private JTable table;
	
	public SessionCreateView(SessionCreateModel model)
	{		
		super(new BorderLayout());
		this.model = model;
		
		setSize(500,300);
		this.setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		 table = new JTable(new MyTableModel());
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
	        
	        table.setDefaultEditor(Integer.class, new IntegerEditor(0, 25));
	        
	        add(scrollPane, BorderLayout.NORTH);
	     
	        JPanel southPanel = new JPanel();
	        
	        cancelButton = (JButton) southPanel.add(new JButton("Cancel"));
	        cancelButton.addActionListener(new ActionListener(){ // action Listen for JButton #2
				public void actionPerformed(ActionEvent e) { // 
					addCancel = true;
					hidePanel();			
				}		
			});
	        
	        createButton = (JButton) southPanel.add(new JButton("Create Session"));
	        createButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e) {
	        		controlModel();
	        		hidePanel();
	        	}
	        });
	        
	        add(southPanel, BorderLayout.SOUTH);
	}
	
	private void controlModel(){
		model.setServer(new SocketServer(6780, (Integer)table.getValueAt(0, 1),
				(String)table.getValueAt(0,0), (String)table.getValueAt(0,2)));
	}
	
	 class MyTableModel extends AbstractTableModel {

		 private String[] columnNames = {"Session Name", 
				 						"Num. Participants (1-25)",
				 						"Password"};

		 private Object[][] data = {
				 {"MyServer", new Integer(25), ""}				
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
				return true;
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

	public boolean addCancel() {
		return addCancel;
	}
	
	public void hidePanel(){
		setVisible(false);
	}	    
	    
}
