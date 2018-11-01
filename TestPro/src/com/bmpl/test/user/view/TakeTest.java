package com.bmpl.test.user.view;

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
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class TakeTest extends JFrame {

	private JPanel contentPane;
	Timer timer;
	
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
	
	
	JLabel lblNewLabel = new JLabel(" ");
	private int counter = 60;
	private void TimeLeft()
	{
		System.out.println("no");
		timer = new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(counter == 0)
				{
					timer.stop();
				}
				
				lblNewLabel.setText("Time left : "+counter);
				counter--;
			}
			
		});
		timer.start();
	}
	
	ButtonGroup kk = new ButtonGroup();
	
	
	JRadioButton rdbtnNewRadioButton = new JRadioButton(" ");
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(" ");
	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(" ");
	JRadioButton radioButton = new JRadioButton(" ");
	
	

	/**
	 * Create the frame.
	 */
	public TakeTest() {
		setTitle("TakeTest");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 691, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		TimeLeft();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 655, 208);
		contentPane.add(scrollPane);
		
		
		rdbtnNewRadioButton.setBounds(25, 291, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		kk.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1.setBounds(25, 331, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		kk.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2.setBounds(25, 370, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		kk.add(rdbtnNewRadioButton_2);
		
		radioButton.setBounds(25, 414, 109, 23);
		contentPane.add(radioButton);
		kk.add(radioButton);
		
		JButton btnNewButton = new JButton("Prev");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		btnNewButton.setBounds(39, 495, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		btnNext.setBounds(152, 495, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnFinishtest = new JButton("FinishTest");
		btnFinishtest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Result result = new Result();
				result.setVisible(true);
			}
			
		});
		btnFinishtest.setBounds(550, 495, 89, 23);
		contentPane.add(btnFinishtest);
		
		
		lblNewLabel.setBounds(564, 11, 75, 23);
		contentPane.add(lblNewLabel);
	}
}