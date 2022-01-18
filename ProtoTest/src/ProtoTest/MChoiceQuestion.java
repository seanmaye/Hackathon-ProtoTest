package ProtoTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;

public class MChoiceQuestion implements ActionListener,FocusListener{
	
	static private int qnum;
	static private String question;
	static private String ranswer;
	static private String answer1;
	static private String answer2;
	static private String answer3;
	static private String answer4;
	private JRadioButton rdbtn5;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn1;
	private JFrame frmQuestion;
	
	private ReadClassObject reader;
	private boolean correct;
	private boolean answered = false;


	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		
	}
	*/

	/**
	 * Create the application.
	 */
	public MChoiceQuestion(int qn, String q, String ra, String a1, String a2, String a3, String a4) {
		qnum = qn;
		question = q;
		ranswer = ra;
		answer1 = a1;
		answer2 = a2;
		answer3 = a3;
		answer4 = a4;
		initialize();

		
		//MChoiceQuestion window = new MChoiceQuestion(qnum, question, ranswer, answer1, answer2, answer3, answer4);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//window.frmQuestion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		frmQuestion = new JFrame();
		frmQuestion.setVisible(true);
		frmQuestion.setTitle("Question #"+qnum);
		frmQuestion.setBounds(100, 100, 450, 300);
		frmQuestion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmQuestion.getContentPane().setLayout(null);
		addFocusListener(this);
		int y1 = 32;
		int y2 = 64;
		int y3 = 96;
		int y4 = 128;
		int y5 = 160;
		//Right answer is always the y5 value
		int random = (int)(Math.random() * 5 + 1);
		
		if(random==5){
			y1 = 32;
			y2 = 64;
			y3 = 96;
			y4 = 128;
			y5 = 160;
		}else if(random==1){
			y5 = 32;
			y1 = 64;
			y2 = 96;
			y3 = 128;
			y4 = 160;
		}else if(random==2){
			y4 = 32;
			y5 = 64;
			y1 = 96;
			y2 = 128;
			y3 = 160;
		}
		else if(random==3){
			y3 = 32;
			y4 = 64;
			y5 = 96;
			y1 = 128;
			y2 = 160;
		}
		else if(random==4){
			y2 = 32;
			y3 = 64;
			y4 = 96;
			y5 = 128;
			y1 = 160;
		}
		JLabel lbl1 = new JLabel(question);
		lbl1.setBounds(10, 11, 400, 14);
		frmQuestion.getContentPane().add(lbl1);
		
		rdbtn1 = new JRadioButton(answer4);
		rdbtn1.setBounds(10, y1, 400, 23);
		frmQuestion.getContentPane().add(rdbtn1);
		
		rdbtn2 = new JRadioButton(answer3);
		rdbtn2.setBounds(10, y2, 400, 23);
		frmQuestion.getContentPane().add(rdbtn2);
		
		rdbtn3 = new JRadioButton(answer2);
		rdbtn3.setBounds(10, y3, 400, 23);
		frmQuestion.getContentPane().add(rdbtn3);
		
		rdbtn4 = new JRadioButton(answer1);
		rdbtn4.setBounds(10, y4, 400, 23);
		frmQuestion.getContentPane().add(rdbtn4);
		
		rdbtn5 = new JRadioButton(ranswer);
		rdbtn5.setBounds(10, y5, 400, 23);
		frmQuestion.getContentPane().add(rdbtn5);
				
		JButton btnNextQuestion = new JButton("Next Question >>>");
		btnNextQuestion.setBounds(276, 227, 148, 23);
		frmQuestion.getContentPane().add(btnNextQuestion);
		btnNextQuestion.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
        group.add(rdbtn1);
        group.add(rdbtn2);
        group.add(rdbtn3);
        group.add(rdbtn4);
        group.add(rdbtn5);
        
	}
	public boolean correct(){
		return correct;
	}
	
	public void onTop(boolean x){
		frmQuestion.setAlwaysOnTop(x);
		
	}
	
	public void close(){
		frmQuestion.dispose();
		
	}
	
	public boolean isAnswered(){
		return answered;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Eventually Will Return A True/False To Main Program To Be Written To A .txt Doc
		if(!rdbtn5.isSelected()&&!rdbtn4.isSelected()&&!rdbtn3.isSelected()&&!rdbtn2.isSelected()&&!rdbtn1.isSelected()){
			
		}else{
			if(rdbtn5.isSelected()){
				//System.out.println("Right");
				correct = true;
				
			}else{
				//System.out.println("Wrong");
				correct = false;
			}
			answered = true;
			close();
		}
		

	
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Focus Gained on Question, Get to Work!");
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Focus Lost on Question, Stop Cheating.");
	}
}
