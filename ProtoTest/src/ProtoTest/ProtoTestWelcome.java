package ProtoTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.*;

public class ProtoTestWelcome {

	private JFrame frame;
	private JTextField txtUsernameT;
	private JTextField txtUsernameS;
	private JTextField txtPasswordT;
	private JTextField txtPasswordS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProtoTestWelcome window = new ProtoTestWelcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//dir 10 means directory stage 1 filenumber 0.
		String dir10 = "ProtoTest";
		String dir20 = "ProtoTest/src";
		String dir21 = "ProtoTest//Accounts";
		String dir30 = "ProtoTest//Accounts//Teachers";
		String dir31 = "ProtoTest//Accounts//Students";
		String dir40 = "ProtoTest//Accounts//Teachers//Quizzes";
		makeDir(dir10);
		makeDir(dir20);
		makeDir(dir21);
		makeDir(dir30);
		makeDir(dir31);
		makeDir(dir40);
	}
	
	public static void makeDir(String dir){
		try{
            //String strManyDirectories="dir1/dir2/dir3";
            if(new File(dir).isDirectory()){
                System.out.println("Unable to Create "+dir+", Directory Already Exists.");
            }else{
                // Create one directory
                boolean success = (new File(dir)).mkdir();
                if (success) {
                    System.out.println("Directory: " + dir + " created");
                } 
            }
            /* // Create multiple directories
            boolean success = (new File(strManyDirectories)).mkdirs();
            if (success) {
                System.out.println("Directories: " + strManyDirectories + " created");
            }
            */

        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
		
	}
	
	/**
	 * Create the application.
	 */
	public ProtoTestWelcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToPrototest = new JLabel("Welcome to ProtoTest");
		lblWelcomeToPrototest.setBounds(0, 0, 434, 32);
		lblWelcomeToPrototest.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcomeToPrototest.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblWelcomeToPrototest);
		
		JButton btnLoginAsTeacher = new JButton("Login As Teacher");
		btnLoginAsTeacher.setBounds(20, 43, 158, 23);
		btnLoginAsTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.getContentPane().add(btnLoginAsTeacher);
		
		JButton btnLoginAsStudent = new JButton("Login As Student");
		btnLoginAsStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestQuiz tq = new TestQuiz();
				frame.dispose();
			}
		});
		btnLoginAsStudent.setBounds(266, 43, 158, 23);
		frame.getContentPane().add(btnLoginAsStudent);
		
		JLabel lblUsername = new JLabel("<-- Username -->");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(163, 80, 118, 14);
		frame.getContentPane().add(lblUsername);
		
		txtUsernameT = new JTextField();
		txtUsernameT.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsernameT.setText("Username");
		txtUsernameT.setBounds(20, 77, 133, 20);
		frame.getContentPane().add(txtUsernameT);
		txtUsernameT.setColumns(10);
		
		txtUsernameS = new JTextField();
		txtUsernameS.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsernameS.setText("Username");
		txtUsernameS.setColumns(10);
		txtUsernameS.setBounds(291, 77, 133, 20);
		frame.getContentPane().add(txtUsernameS);
		
		JLabel lblPassword = new JLabel("<-- Password -->");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(163, 117, 118, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPasswordT = new JTextField();
		txtPasswordT.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordT.setText("Password");
		txtPasswordT.setColumns(10);
		txtPasswordT.setBounds(20, 114, 133, 20);
		frame.getContentPane().add(txtPasswordT);
		
		txtPasswordS = new JTextField();
		txtPasswordS.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordS.setText("Password");
		txtPasswordS.setColumns(10);
		txtPasswordS.setBounds(291, 114, 133, 20);
		frame.getContentPane().add(txtPasswordS);
		
		JButton btnRegisterAsTeacher = new JButton("Register as Teacher");
		btnRegisterAsTeacher.setBounds(20, 177, 158, 23);
		btnRegisterAsTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherRegisterGui trg = new TeacherRegisterGui();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnRegisterAsTeacher);
		
		JButton btnRegisterAsStudent = new JButton("Register as Student");
		btnRegisterAsStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRegisterGui srg = new StudentRegisterGui();
				frame.dispose();
			}
		});
		btnRegisterAsStudent.setBounds(266, 177, 149, 23);
		frame.getContentPane().add(btnRegisterAsStudent);
	}
}
