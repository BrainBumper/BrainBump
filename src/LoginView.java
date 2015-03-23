import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;


public class LoginView extends JPanel
{

	public LoginView ()
	{
		this.setLayout(new BorderLayout());
		
		setSize(280, 130);
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		placeComponents(panel);
	}
	
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
	}

}
