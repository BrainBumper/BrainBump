package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.LoginModel;


public class LoginView extends JPanel
{
	private LoginModel model;
	
	private boolean addReg = false; 
	
	private JTextField userText;
	private JPasswordField passwordText;

	public LoginView(LoginModel model){
		this.model = model;
		
		this.setLayout(new BorderLayout());
		setSize(280, 130);
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setBorder(new TextBubbleBorder(Color.blue, 5, 10, 0));
		placeComponents(panel);
		setVisible(true);
	}
	
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				controlModel();	
			}		
		});
		panel.add(loginButton);
		
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { // 
				addReg = true;
				hidePanel();			
			}		
		});
		panel.add(registerButton);
	}
	
	private void controlModel(){
		model.setUser(userText.getText());
		model.setPass(passwordText.getText());
		if(model.validate())
			hidePanel();
	}
	
	public boolean addRegPanel(){
		return addReg;
	}

	private void hidePanel(){
		setVisible(false);
	}
	
	public LoginModel getModel(){
		return model;
	}

}
