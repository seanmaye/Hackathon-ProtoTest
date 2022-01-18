package ProtoTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.SwingConstants;import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class TeacherRegisterGui {

	private JFrame frame;
	private JTextField Email;
	private JTextField Username;
	private JTextField Password;
	private JTextField Name;
	private JLabel lblIsInUse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherRegisterGui window = new TeacherRegisterGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherRegisterGui() {
		frame = new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblTeacherRegistration = new JLabel("Register As Teacher");
		lblTeacherRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherRegistration.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTeacherRegistration.setForeground(Color.BLACK);
		lblTeacherRegistration.setBounds(10, 11, 414, 39);
		frame.getContentPane().add(lblTeacherRegistration);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setBounds(10, 137, 132, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(10, 168, 132, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(10, 107, 132, 14);
		frame.getContentPane().add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(152, 104, 163, 20);
		frame.getContentPane().add(Email);
		Email.setColumns(10);
		
		Username = new JTextField();
		Username.setBounds(152, 134, 163, 20);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(152, 165, 163, 20);
		frame.getContentPane().add(Password);
		Password.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(152, 73, 163, 20);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 76, 132, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblIsInUse = new JLabel("The Username is Taken or a Field is Empty");
		lblIsInUse.setBounds(203, 196, 46, 14);
		lblIsInUse.setForeground(new Color(240,240,240));
		frame.getContentPane().add(lblIsInUse);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(152, 227, 163, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "ProtoTest/Accounts/Teachers/"+Username.getText();
				File f = new File(path);
				
				if((f.exists() && !f.isDirectory())||Username.getText().equals("")||Name.getText().equals("")||Password.getText().equals("")||Email.getText().equals("")) {
					lblIsInUse.setForeground(new Color(0,0,0));
				}else{
					WriteClassObject writer = new WriteClassObject(path+".txt");
					writer.pLine("Name: "+Name.getText());
					writer.pLine("Username: "+Username.getText());
					writer.pLine("Password: "+Password.getText());
					writer.pLine("Email: "+Email.getText());
					writer.pClose();
					ProtoTestWelcome ptw = new ProtoTestWelcome();
					frame.dispose();
				}
			}});
		frame.getContentPane().add(btnNewButton);
		
		
	}
}