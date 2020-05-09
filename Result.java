import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_4;
	private JTextField textField, textField_1, textField_2, textField_3, textField_4, 
		textField_5, textField_6, textField_7;
	
	ArrayList<Scores> array = new ArrayList<Scores>();
	
	public void setTextField1Label(long x, int y) {
		this.lblNewLabel_4.setText(String.format("%.4f", ((double) x / y) / 1000 / 60));
		this.textField_1.setText(Integer.toString(y));
	}
	
	public void setTextField(String x) {
		this.textField.setText(x);;
	}
	
	public void setTextField2(int x) {
		this.textField_2.setText(Integer.toString(x));
	}
	
	public void setTextField34567 (int w, long x, double y, double z) {
		this.textField_3.setText(Long.toString(x / 1000 / 60 / 60));
		this.textField_4.setText(String.format("%.0f", y / z * 100));
		this.textField_5.setText(Integer.toString(((int) Math.pow((y / z * 100), 1.5) * (int) Math.pow(w, 2)) / (int) (x / 1000 / z)));
		this.textField_6.setText(Long.toString(x / 1000 / 60));
		this.textField_7.setText(Long.toString((x / 1000) - (60 * (x / 1000 / 60))));
	}
	
	class Scores { 
	    int score; 
	    String name;

	    public Scores(String name, int score) { 
	        this.score = score; 
	        this.name = name;
	    } 
	  
	    public String toString() { 
	        return this.name + "                    " + this.score;
	    } 
	}
	
	class sortByScore implements Comparator<Scores> {
		
	    public int compare(Scores a, Scores b) { 
	        return a.score - b.score; 
	    }
	}
	
	public void leaderboard(String x, int y) throws IOException{
		array.add(new Scores(x, y));
		
		try {
			Scanner input = new Scanner(new File ("src\\leaderboard.txt"));
			while(input.hasNext()) {
				String previousScore = input.nextLine();
				String[] splits = previousScore.split("                    ");
				String name = splits[0].trim();
				String score = splits[1].trim();
				array.add(new Scores(name, Integer.parseInt(score)));
			}
			input.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
		Collections.sort(array, new sortByScore()); 
		
		FileWriter fileWriter = new FileWriter("src\\leaderboard.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		for (int i=array.size(); i>0; i--) 
            printWriter.println(array.get(i-1));
		printWriter.close();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Results");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Player Name:");
		lblNewLabel_1.setBounds(75, 58, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Problems Given:");
		lblNewLabel_2.setBounds(58, 83, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Problems Solved:");
		lblNewLabel_3.setBounds(52, 108, 112, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblTotalTimeTaken = new JLabel("Total Time Taken:");
		lblTotalTimeTaken.setBounds(52, 133, 112, 14);
		contentPane.add(lblTotalTimeTaken);
		
		lblNewLabel_4 = new JLabel("0.9348");
		lblNewLabel_4.setBounds(165, 161, 72, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("It took on average ");
		lblNewLabel_5.setBounds(58, 161, 106, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("minutes for you to solve each problem.");
		lblNewLabel_6.setBounds(208, 161, 226, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Percent Correct:");
		lblNewLabel_7.setBounds(58, 185, 106, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Total Score");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(317, 58, 96, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Hours");
		lblNewLabel_9.setBounds(195, 133, 37, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Minutes");
		lblNewLabel_10.setBounds(255, 133, 52, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Seconds");
		lblNewLabel_11.setBounds(322, 132, 55, 14);
		contentPane.add(lblNewLabel_11);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(174, 55, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(174, 80, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(174, 105, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(174, 130, 20, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(174, 182, 31, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(317, 80, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(234, 130, 20, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBounds(303, 130, 20, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					leaderboard(textField.getText(), Integer.parseInt(textField_5.getText()));
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				History history = new History();
				dispose();
				history.setVisible(true);
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					leaderboard(textField.getText(), Integer.parseInt(textField_5.getText()));
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Thank you for using the Arithmetic Helper!");
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
