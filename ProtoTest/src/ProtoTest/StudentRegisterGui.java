package ProtoTest;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.io.File;

public class StudentRegisterGui {

	private JFrame frame;
	private JTextField TextUName;
	private JTextField TextPass;
	private JTextField TextEmail;
	private JTextField TextName;
	private JTextField TextPhone;
	private JLabel lblRegisterAsStudent;
	private JLabel lblInUse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegisterGui window = new StudentRegisterGui();
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
	public StudentRegisterGui() {
		frame = new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(75, 75, 475, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		TextName = new JTextField();
		TextName.setColumns(10);
		TextName.setBounds(168, 61, 131, 20);
		frame.getContentPane().add(TextName);
		
		TextUName = new JTextField();
		TextUName.setBounds(168, 92, 131, 20);
		frame.getContentPane().add(TextUName);
		TextUName.setColumns(10);
		
		TextPass = new JTextField();
		TextPass.setColumns(10);
		TextPass.setBounds(168, 123, 131, 20);
		frame.getContentPane().add(TextPass);
		
		TextEmail = new JTextField();
		TextEmail.setColumns(10);
		TextEmail.setBounds(168, 154, 131, 20);
		frame.getContentPane().add(TextEmail);
		
		TextPhone = new JTextField();
		TextPhone.setColumns(10);
		TextPhone.setBounds(168, 185, 131, 20);
		frame.getContentPane().add(TextPhone);
		
		JLabel LabelFullName = new JLabel("Full Name");
		LabelFullName.setHorizontalAlignment(SwingConstants.TRAILING);
		LabelFullName.setBounds(20, 64, 120, 14);
		frame.getContentPane().add(LabelFullName);
		
		JLabel LabelUserName = new JLabel("User Name");
		LabelUserName.setHorizontalAlignment(SwingConstants.TRAILING);
		LabelUserName.setBounds(20, 95, 120, 14);
		frame.getContentPane().add(LabelUserName);
		
		JLabel LabelPass = new JLabel("Password");
		LabelPass.setHorizontalAlignment(SwingConstants.TRAILING);
		LabelPass.setBounds(20, 126, 120, 14);
		frame.getContentPane().add(LabelPass);
		
		JLabel LabelEmail = new JLabel("Email");
		LabelEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		LabelEmail.setBounds(20, 157, 120, 14);
		frame.getContentPane().add(LabelEmail);
		
		JLabel LabelPhone = new JLabel("Phone");
		LabelPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		LabelPhone.setBounds(20, 188, 120, 14);
		frame.getContentPane().add(LabelPhone);
		
		JButton btnConfirm = new JButton("Register");
		btnConfirm.setBounds(168, 216, 131, 23);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "ProtoTest/Accounts/Students/"+TextUName.getText();
				File f = new File(path);
				
				if((f.exists() && !f.isDirectory())||TextUName.getText().equals("")||TextName.getText().equals("")||TextPass.getText().equals("")||TextEmail.getText().equals("")||TextPhone.getText().equals("")) {
					lblInUse.setForeground(new Color(0,0,0));
				}else{
					WriteClassObject writer = new WriteClassObject(path+".txt");
					writer.pLine("Name: "+TextName.getText());
					writer.pLine("Username: "+TextUName.getText());
					writer.pLine("Password: "+TextPass.getText());
					writer.pLine("Email: "+TextEmail.getText());
					writer.pLine("Phone Number: "+TextPhone.getText());
					writer.pClose();
					ProtoTestWelcome ptw = new ProtoTestWelcome();
					frame.dispose();
				}
			}});
		frame.getContentPane().add(btnConfirm);
		
		lblRegisterAsStudent = new JLabel("Register As Student");
		lblRegisterAsStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterAsStudent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegisterAsStudent.setBounds(10, 11, 439, 37);
		frame.getContentPane().add(lblRegisterAsStudent);
		
		lblInUse = new JLabel("Username is in use or a section is not filled in.");
		lblInUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblInUse.setBounds(10, 250, 439, 14);
		lblInUse.setForeground(new Color(240,240,240));
		frame.getContentPane().add(lblInUse);
	}
}