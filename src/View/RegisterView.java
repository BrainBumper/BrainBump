package View;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;


public class RegisterView extends JPanel
{
	public RegisterView()
	{
		this.setLayout(new BorderLayout());
		
		setSize(310, 160);
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		placeComponents(panel);
	}

	private static void placeComponents(JPanel panel)
	{
		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(130, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);
		
		JLabel passwordConfirmLabel = new JLabel("Confirm Password");
		passwordConfirmLabel.setBounds(10, 75, 110, 25);
		panel.add(passwordConfirmLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(130, 40, 160, 25);
		panel.add(passwordText);
		
		JPasswordField passwordConfirmText = new JPasswordField(20);
		passwordConfirmText.setBounds(130, 75, 160, 25);
		panel.add(passwordConfirmText);
		
		JButton registerButton = new JButton("Create Account");
		registerButton.setBounds(90, 120, 140, 25);
		panel.add(registerButton);
	}
}
