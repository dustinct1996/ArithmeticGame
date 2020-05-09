import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField, textField_1, textField_2;
	private int title;
	
	public void setTitle(int x) {
		if(x==0)
			this.lblNewLabel.setText("Addition Helper");
		else if(x==1)
		 	this.lblNewLabel.setText("Subtraction Helper");
		else if(x==2) 
			this.lblNewLabel.setText("Multiplication Helper");
		else if(x==3)
			this.lblNewLabel.setText("Division Helper");
		else if(x==4) 
			this.lblNewLabel.setText("Random Mode");
		this.title = x;
	}
	
	public void setTextField(String x) {
		this.textField.setText(x);
	}
	
	public void setTextField1(String x) {
		this.textField_1.setText(x);
	}
	
	public void setTextField2(String x) {
		this.textField_2.setText(x);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Okay,");
		lblNewLabel_1.setBounds(68, 56, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("you will solve ");
		lblNewLabel_2.setBounds(68, 81, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("equations containing");
		lblNewLabel_3.setBounds(188, 81, 123, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Good luck!");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 132, 414, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("digits.");
		lblNewLabel_5.setBounds(353, 81, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(",");
		lblNewLabel_6.setBounds(205, 56, 48, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(109, 53, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(153, 78, 25, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(318, 78, 25, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Begin Quiz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Problem problem = new Problem();
					problem.setLabel(lblNewLabel.getText());
					problem.setNumDigits(Integer.parseInt(textField_2.getText()));
					problem.setOperation(title);
					problem.setLabel6(1);
					problem.setLabel7(Integer.parseInt(textField_1.getText()));
					problem.setNum(Integer.parseInt(textField_1.getText()));
					problem.setCounter(1);
					problem.setNumCorrect(0);
					problem.setPlayerName(textField.getText());
					problem.setStartTime(0);
					dispose();
					problem.setVisible(true);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please input proper values");
				}
			}
		});
		btnNewButton.setBounds(10, 227, 414, 23);
		contentPane.add(btnNewButton);
	}
}
