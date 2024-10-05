package OsGrillTraining;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Pages implements ActionListener
{
	JFrame openF = new JFrame();
	JButton createMemberButton = new JButton("Create New Member");
	JButton exsistingMemberButton = new JButton("Exsisting Member");

	Pages()
	{
		createMemberButton.setBounds(125,200,100,25);
		createMemberButton.setFocusable(false);
		createMemberButton.addActionListener(this);
			
		exsistingMemberButton.setBounds(225,200,100,25);
		exsistingMemberButton.setFocusable(false);
		exsistingMemberButton.addActionListener(this);
			
		openF.add(exsistingMemberButton);
		openF.add(createMemberButton);
		openF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openF.setSize(420,420);
		openF.setLocationRelativeTo(null);
		openF.setLayout(null);
		openF.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent b) 
	{
		if(b.getSource()==exsistingMemberButton)
		{
			IDandPasswords idandPasswords = new IDandPasswords();
			LoginPage slave = new LoginPage(idandPasswords.getLoginInfo());
			
		}
		if(b.getSource()==createMemberButton)
		{
			IDandPasswords idandPasswords = new IDandPasswords();
			CreateMemberPage slut = new CreateMemberPage(idandPasswords.getLoginInfo());
			
		}
	}
}
class LoginPage extends Pages
{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("username not found");
			}
		}
	}	
}
class CreateMemberPage extends Pages
{
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> newMemberInfo = new HashMap<String,String>();
	String userID;
	String password;
	IDandPasswords x = new IDandPasswords();
	
	CreateMemberPage(HashMap<String,String> newMemberInfoOriginal)
	{
		
		newMemberInfo = newMemberInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton) {
			userID = userIDField.getText();
			password = String.valueOf(userPasswordField.getPassword());	
			IDandPasswords idandPasswords = new IDandPasswords();
			LoginPage slave = new LoginPage(idandPasswords.getLoginInfo())
			
			/*HashMap<String,String> newMemberInfo = x.getLoginInfo();
			newMemberInfo.put(userID, password);
			System.out.println(newMemberInfo);*/
		}
	}
}