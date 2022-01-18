package StudentGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Student {

	private JFrame frame;
	private JTextField TextUName;
	private JTextField TextPass;
	private JTextField TextEmail;
	private JTextField TextName;
	private JTextField TextPhone;
	private JTextField Title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextName = new JTextField();
		TextName.setColumns(10);
		TextName.setBounds(150, 61, 131, 20);
		frame.getContentPane().add(TextName);
		
		TextUName = new JTextField();
		TextUName.setBounds(150, 92, 131, 20);
		frame.getContentPane().add(TextUName);
		TextUName.setColumns(10);
		
		TextPass = new JTextField();
		TextPass.setColumns(10);
		TextPass.setBounds(150, 123, 131, 20);
		frame.getContentPane().add(TextPass);
		
		TextEmail = new JTextField();
		TextEmail.setColumns(10);
		TextEmail.setBounds(150, 154, 131, 20);
		frame.getContentPane().add(TextEmail);
		
		TextPhone = new JTextField();
		TextPhone.setColumns(10);
		TextPhone.setBounds(150, 185, 131, 20);
		frame.getContentPane().add(TextPhone);
		
		JLabel LabelFullName = new JLabel("Full Name");
		LabelFullName.setBounds(68, 64, 46, 14);
		frame.getContentPane().add(LabelFullName);
		
		JLabel LabelUserName = new JLabel("User Name");
		LabelUserName.setBounds(68, 95, 72, 14);
		frame.getContentPane().add(LabelUserName);
		
		JLabel LabelPass = new JLabel("Password");
		LabelPass.setBounds(68, 126, 46, 14);
		frame.getContentPane().add(LabelPass);
		
		JLabel LabelEmail = new JLabel("Email");
		LabelEmail.setBounds(68, 157, 46, 14);
		frame.getContentPane().add(LabelEmail);
		
		JLabel LabelPhone = new JLabel("Phone");
		LabelPhone.setBounds(68, 188, 46, 14);
		frame.getContentPane().add(LabelPhone);
		
		Title = new JTextField();
		Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Title.setText("Student Registration");
		Title.setBackground(SystemColor.menu);
		Title.setBounds(70, 11, 280, 39);
		frame.getContentPane().add(Title);
		Title.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(312, 122, 89, 23);
		frame.getContentPane().add(btnConfirm);
	}
}
