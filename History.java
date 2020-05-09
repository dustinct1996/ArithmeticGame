import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public void printHistory(DefaultTableModel dtm) {
		try {
			Scanner input = new Scanner(new File ("src\\history.txt"));
			while(input.hasNext()) {
				Object[] row = {input.next(), input.next(), input.next(), input.next()};
				dtm.addRow(row);
			}
			input.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void resetHistory() throws IOException{
		FileWriter fileWriter = new FileWriter("src\\history.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.printf("");
		printWriter.close();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	public History() {
		Object[] title = {"Operand 1", "Operand 2", "Correct Answer", "Your Answer"};
	    DefaultTableModel dtm = new DefaultTableModel();
	    dtm.setColumnIdentifiers(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("History");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 414, 160);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.setRowSelectionAllowed(false);
	    table.setModel(dtm);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		printHistory(dtm);
	    
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resetHistory();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Thank you for using the Arithmetic Helper!");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leaderboard");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resetHistory();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				RankList rankList = new RankList();
				dispose();
				rankList.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(317, 227, 107, 23);
		contentPane.add(btnNewButton_1);
	}
}
