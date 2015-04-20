package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.MainClientModel;

public class ChatView extends JPanel
{
	JTextField messageBox;
	JButton sendMessage;
	JTextArea chatBox;
	
	JPanel mainPanel, southPanel;
	
	private MainClientModel model;
	
	public ChatView(MainClientModel model)
	{
		super (new BorderLayout());
		this.model = model;
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(10);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(new sendMessageButtonListener());

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        southPanel.add(messageBox);
        southPanel.add(sendMessage);

        mainPanel.add(BorderLayout.SOUTH, southPanel);
        
        add(mainPanel, BorderLayout.CENTER);
	}
	
	class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() < 1) {
                // do nothing
            } else if (messageBox.getText().equals(".clear")) {
                chatBox.setText("Cleared all messages\n");
                messageBox.setText("");
            } else {
                chatBox.append("<" + model.getUsername() + ">:  " + messageBox.getText()
                        + "\n");
                messageBox.setText("");
            }
            messageBox.requestFocusInWindow();
        }
    }
}
