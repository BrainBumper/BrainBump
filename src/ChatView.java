import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChatView extends JPanel
{
	JTextField messageBox;
	JButton sendMessage;
	JTextArea chatBox;
	
	public ChatView()
	{
		super (new BorderLayout());
		setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		
		JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
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

//        GridBagConstraints left = new GridBagConstraints();
//        left.anchor = GridBagConstraints.LINE_START;
//        left.fill = GridBagConstraints.HORIZONTAL;
//        left.weightx = 512.0D;
//        left.weighty = 1.0D;
//
//        GridBagConstraints right = new GridBagConstraints();
//        right.insets = new Insets(0, 10, 0, 0);
//        right.anchor = GridBagConstraints.LINE_END;
//        right.fill = GridBagConstraints.NONE;
//        right.weightx = 1.0D;
//        right.weighty = 1.0D;

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
                chatBox.append("<" + "Kramgrond" + ">:  " + messageBox.getText()
                        + "\n");
                messageBox.setText("");
            }
            messageBox.requestFocusInWindow();
        }
    }
}