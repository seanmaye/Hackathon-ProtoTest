package ProtoTest;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.EventQueue;
import javax.*;
import javafx.*;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TestQuiz implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JButton btnBeginTest;
	private JLabel lblTestLocationIs;
	
	private ReadClassObject reader;
	
	private ArrayList<String> lines;
	private ArrayList<String> answers;	
	private ArrayList<String> questions;
	
	MChoiceQuestion question;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					TestQuiz window = new TestQuiz();
					window.frame.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public TestQuiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lines = new ArrayList<String>();
		answers = new ArrayList<String>();
		questions = new ArrayList<String>();
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTakeATest = new JLabel("Take A Test!");
		lblTakeATest.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakeATest.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTakeATest.setBounds(10, 11, 414, 34);
		frame.getContentPane().add(lblTakeATest);
		
		textField = new JTextField();
		textField.setBounds(10, 87, 414, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheLocation = new JLabel("Enter the Location of the Test");
		lblEnterTheLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheLocation.setBounds(20, 56, 404, 14);
		frame.getContentPane().add(lblEnterTheLocation);
		
		btnBeginTest = new JButton("Begin Test");
		btnBeginTest.setBounds(138, 203, 152, 23);
		frame.getContentPane().add(btnBeginTest);
		btnBeginTest.addActionListener(this);
		
		lblTestLocationIs = new JLabel("Test Location Is Not Valid");
		lblTestLocationIs.setForeground(new Color(240,240,240));
		lblTestLocationIs.setBounds(10, 147, 414, 14);
		frame.getContentPane().add(lblTestLocationIs);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		File f = new File(textField.getText());
	
		if(f.exists() && !f.isDirectory()) { 
		    lblTestLocationIs.setForeground(new Color(240,240,240));
		    
		    try {
				reader = new ReadClassObject(textField.getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		    
		    lines = reader.getInfo();
		    
		    int n = 0;
		    
		    for(String l : lines){
		    	
		    	if(l.lastIndexOf("Answer: ") != -1){	
		    		if(l.lastIndexOf("Right") != -1)
		    			answers.add(l.substring(l.lastIndexOf("Answer: ") + 8) + "*");
		    		else
		    			answers.add(l.substring(l.lastIndexOf("Answer: ") + 8));
		    	}
		    	else if(l.lastIndexOf("Question: ") != -1){
		    		questions.add(l.substring(l.lastIndexOf("Question: ") + 10));
		    	}
		    }
		    
		    startQuiz();
		}else if(!f.exists()){
			lblTestLocationIs.setForeground(new Color(0,0,0));
		}
	}
	public void startQuiz(){
		int qnum = 1;
		for(String qs : questions){
			String q = questions.get(0+(qnum-1));
			String a1 = answers.get(0+((qnum-1)*5));
			String a2 = answers.get(1+((qnum-1)*5));
			String a3 = answers.get(2+((qnum-1)*5));
			String a4 = answers.get(3+((qnum-1)*5));
			String ra = answers.get(4+((qnum-1)*5));
			String rar = ra.substring(0,ra.length()-1);
			question = new MChoiceQuestion(qnum,q,rar,a1,a2,a3,a4);
			
			/*if(!questionSpawner.QSisAnswered()){
				System.out.println("Question Not Answered");
			}else{
				System.out.println("Question Answered");
			}*/
			
			
			
			qnum++;
		}
		frame.dispose();
		
	}
	
}
