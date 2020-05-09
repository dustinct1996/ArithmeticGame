import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Problem extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_6, lblNewLabel_7;
	private JTextField textField;
	private int numDigits, randEqMode, numProblems, i, numCorrect, correctAnswer, opNum;
	private long startTime;
	private String playerName;
	
	public void setLabel(String x) {
		this.lblNewLabel.setText(x);
	}
	
	public void setNumDigits(int x) {
		Random rand = new Random();
		this.lblNewLabel_2.setText(Integer.toString(rand.nextInt(9*(int) Math.pow(10, x-1)) + (int) Math.pow(10, x-1)));
		this.lblNewLabel_4.setText(Integer.toString(rand.nextInt(9*(int) Math.pow(10, x-1)) + (int) Math.pow(10, x-1)));
		this.numDigits = x;
	}
	
	public void setOperation(int x) {
		if(x==0)
			this.lblNewLabel_3.setText("+");
		else if(x==1)
			this.lblNewLabel_3.setText("-");
		else if(x==2) 
			this.lblNewLabel_3.setText("*");
		else if(x==3)
			this.lblNewLabel_3.setText("/");
		else if(x==4) {
			Random rand = new Random();
			this.randEqMode = rand.nextInt(4);
			if(this.randEqMode==0)
				this.lblNewLabel_3.setText("+");
			else if(this.randEqMode==1)
				this.lblNewLabel_3.setText("-");
			else if(this.randEqMode==2)
				this.lblNewLabel_3.setText("*");
			else if(this.randEqMode==3)
				this.lblNewLabel_3.setText("/");
		}
		this.opNum = x;
	}
	
	public void setLabel6(int x) {
		this.lblNewLabel_6.setText(Integer.toString(x));
	}
	
	public void setLabel7(int x) {
		this.lblNewLabel_7.setText(Integer.toString(x));
	}
	
	public void setNum(int x) {
		this.numProblems = x;
	}
	
	public void setCounter(int x) {
		this.i = x;
	}
	
	public void setNumCorrect(int x) {
		this.numCorrect = x;
	}
	
	public void setPlayerName(String x) {
		this.playerName = x;
	}
	
	public void setStartTime(long x) {
		if(x==0) {
			this.startTime = System.currentTimeMillis();
		}
		else {
			this.startTime = x;
		}
	}
	
	public int getCorrectAnswer(int x, int y) {
		if(this.opNum==0)
			this.correctAnswer = x + y;
		else if(this.opNum==1)
			this.correctAnswer = x - y;
		else if(this.opNum==2) 
			this.correctAnswer = x * y;
		else if(this.opNum==3)
			this.correctAnswer = x / y;
		else if(this.opNum==4) {
			if(this.randEqMode==0)
				this.correctAnswer = x + y;
			else if(this.randEqMode==1)
				this.correctAnswer = x - y;
			else if(this.randEqMode==2)
				this.correctAnswer = x * y;
			else if(this.randEqMode==3)
				this.correctAnswer = x / y;
		}
		return this.correctAnswer;
	}
	
	public long getNewTime() {//
		return System.currentTimeMillis() - startTime;//
	}
	
	public int getCounter() {
		return this.i;
	}
	
	public int getNumProblems() {
		return this.numProblems;
	}
	
	public long getStartTime() {
		return this.startTime;
	}
	public void updateCounter() {
		this.i++;
	}
	
	public void history(int w, int x, int y, int z) throws IOException{
		FileWriter fileWriter = new FileWriter("src\\history.txt", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		for(int j=1; j<5; j++){
			if(j==1) {
				printWriter.printf("%d", w);
				printWriter.println();	
			}
			else if(j==2) {
				printWriter.printf("%d", x);
				printWriter.println();	
			}
			else if(j==3) {
				printWriter.printf("%d", y);
				printWriter.println();	
			}
			else if(j==4) {
				printWriter.printf("%d", z);
				printWriter.println();
			}
		}
		printWriter.close();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem frame = new Problem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Problem() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 414, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Problem      of   ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 58, 414, 23);
		contentPane.add(lblNewLabel_1);
			
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(66, 138, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(110, 138, 24, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");;
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(130, 138, 48, 14);
		contentPane.add(lblNewLabel_4);
			
		JLabel lblNewLabel_5 = new JLabel("=");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(174, 138, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(223, 62, 17, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(249, 62, 17, 14);
		contentPane.add(lblNewLabel_7);
			
		textField = new JTextField();
		textField.setBounds(243, 135, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
			
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCounter();
				try {
					if(Integer.parseInt(textField.getText())==getCorrectAnswer(Integer.parseInt(lblNewLabel_2.getText()), Integer.parseInt(lblNewLabel_4.getText()))) {
						numCorrect++;
					}
					history(Integer.parseInt(lblNewLabel_2.getText()), Integer.parseInt(lblNewLabel_4.getText()), 
						getCorrectAnswer(Integer.parseInt(lblNewLabel_2.getText()), Integer.parseInt(lblNewLabel_4.getText())), Integer.parseInt(textField.getText()));
					if(getCounter()<=getNumProblems()) {
						Problem problem = new Problem();
						problem.setLabel(lblNewLabel.getText());
						problem.setNumDigits(numDigits);
						problem.setOperation(opNum);
						problem.setLabel6(i);
						problem.setLabel7(numProblems);
						problem.setNum(numProblems);
						problem.setCounter(i);
						problem.setNumCorrect(numCorrect);
						problem.setPlayerName(playerName);
						problem.setStartTime(getStartTime());
						dispose();
						problem.setVisible(true);
					}
					else {
						Result result = new Result();
						new User(getNewTime(), numCorrect, playerName);
						result.setTextField1Label(getNewTime(), numProblems);
						result.setTextField(playerName);
						result.setTextField2(numCorrect);
						result.setTextField34567(numDigits, getNewTime(), (double) numCorrect, (double) numProblems);
						dispose();
						result.setVisible(true);
					}
				} 
				catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 227, 414, 23);
		contentPane.add(btnNewButton);
	}
}
