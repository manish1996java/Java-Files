package com.bmpl.testengin.user.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class TakeTest extends JFrame {

	Timer timer;
	int count = 60;
	Integer counta = 50;
	
	JLabel TimeLeft = new JLabel();
	private void timeLeft()
	{
		
	timer = new Timer(1000,new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			if(count == 0)
			{
				timer.stop();
			}
			TimeLeft.setText("TimeLeft :" + count);
			count--;
		}
	});
	
	timer.start();
	}
	
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeTest frame = new TakeTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	ButtonGroup bg = new ButtonGroup();
	
	JRadioButton rdbtnNewRadioButton = new JRadioButton("");
	
	JRadioButton radioButton = new JRadioButton("");
	
	JRadioButton radioButton_1 = new JRadioButton("");
	
	JRadioButton radioButton_2 = new JRadioButton("");
	
	/**
	 * Create the frame.
	 */
	public TakeTest() {
		
		setTitle("TakeTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 613, 153);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		rdbtnNewRadioButton.setBounds(35, 241, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton);
		
		radioButton.setBounds(35, 277, 109, 23);
		contentPane.add(radioButton);
		bg.add(radioButton);
		
		radioButton_1.setBounds(35, 315, 109, 23);
		contentPane.add(radioButton_1);
		bg.add(radioButton_1);
		
		radioButton_2.setBounds(35, 353, 109, 23);
		contentPane.add(radioButton_2);
		bg.add(radioButton_2);
		
		JButton btnNewButton = new JButton("Prev");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(23, 411, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNext.setBounds(135, 411, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnEndTest = new JButton("End Test");
		btnEndTest.setBounds(534, 411, 89, 23);
		contentPane.add(btnEndTest);
		
		
		TimeLeft.setBounds(548, 11, 75, 16);
		contentPane.add(TimeLeft);
		
		this.timeLeft();
	}
}
