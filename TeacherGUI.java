package RegisterGui;

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

public class TeacherGUI {

	private JFrame frame;
	private JTextField textField_email;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherGUI window = new TeacherGUI();
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
	public TeacherGUI() {
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
		
		JLabel lblTeacherRegistration = new JLabel("Teacher Registration");
		lblTeacherRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTeacherRegistration.setForeground(Color.BLACK);
		lblTeacherRegistration.setBounds(118, 11, 217, 39);
		frame.getContentPane().add(lblTeacherRegistration);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(77, 149, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 192, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(96, 107, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setBounds(152, 104, 163, 20);
		frame.getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		textField_username = new JTextField();
		textField_username.setBounds(152, 146, 163, 20);
		frame.getContentPane().add(textField_username);
		textField_username.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(152, 189, 163, 20);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(152, 61, 163, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(96, 64, 57, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(174, 220, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
