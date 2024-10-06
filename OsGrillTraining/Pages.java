package OsGrillTraining;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Pages implements ActionListener
{
	JFrame FirstFrame = new JFrame();
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
			
		FirstFrame.add(exsistingMemberButton);
		FirstFrame.add(createMemberButton);
		FirstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FirstFrame.setSize(420,420);
		FirstFrame.setLocationRelativeTo(null);
		FirstFrame.setLayout(null);
		FirstFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent b) 
	{
		if(b.getSource()==exsistingMemberButton)
		{
			IDandPasswords idandPasswords = new IDandPasswords();
			LoginPage slave = new LoginPage(idandPasswords.getLoginInfo());
			FirstFrame.dispose();
		}
		if(b.getSource()==createMemberButton)
		{
			IDandPasswords idandPasswords = new IDandPasswords();
			CreateMemberPage slut = new CreateMemberPage(idandPasswords.getLoginInfo());
			FirstFrame.dispose();
		}
	}
}