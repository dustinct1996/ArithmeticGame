import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ArithmeticHelperMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArithmeticHelperMain frame = new ArithmeticHelperMain();
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
	public ArithmeticHelperMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(174, 62, 56, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of Problems:");
		lblNewLabel_1.setBounds(89, 93, 126, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Number of Digits:");
		lblNewLabel_2.setBounds(110, 124, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to the Arithmetic Helper!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 414, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type of Operation:");
		lblNewLabel_4.setBounds(105, 156, 115, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(232, 59, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 90, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(232, 121, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setRequestFocusEnabled(false);
		comboBox.setName("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Addition", "Subtraction", "Multiplication", "Division", "Random"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setSelectedItem("--Select--");
		comboBox.setBounds(232, 152, 96, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using the Arithmetic Helper!");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start start = new Start();
				start.setTitle(comboBox.getSelectedIndex());
				start.setTextField(textField.getText());
				start.setTextField1(textField_1.getText());
				start.setTextField2(textField_2.getText());
				dispose();
				start.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(328, 227, 96, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("About");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " Dustin Thompson\n UCF College of Engineering and Computer Sciences\n Class of 2020\n");
			}
		});
		btnNewButton_2.setBounds(169, 227, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
