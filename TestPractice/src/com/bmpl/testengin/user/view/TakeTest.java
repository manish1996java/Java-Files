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

import com.bmpl.testengin.utils.CommonConstants;

public class TakeTest extends JFrame {

	private JPanel contentPane;
	private int count = 60;
	private Timer timer;
	
	
	/**
	 * Launch the application.
	 */
	
	
	JLabel timeleft = new JLabel("");
	public void timeLeft()
	{
		timer = new Timer(CommonConstants.DELAY,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeleft.setText("TimeLeft :"+count);
				if(count==0) {
					
					timer.stop();
				}
				count--;
			}

		});
		timer.start();
	}
	
	
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

	ButtonGroup bg = new ButtonGroup();  // for grouping two or more button
	
	
	/**
	 * Create the frame.
	 */
	public TakeTest() {
		setTitle("TakeTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 42, 585, 179);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setRowHeaderView(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		bg.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(20, 255, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("");
		bg.add(radioButton);
		radioButton.setBounds(20, 291, 109, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		bg.add(radioButton_1);
		radioButton_1.setBounds(20, 327, 109, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		bg.add(radioButton_2);
		radioButton_2.setBounds(20, 361, 109, 23);
		contentPane.add(radioButton_2);
		
		JButton prev = new JButton("Prev");
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prev.setBounds(20, 420, 89, 23);
		contentPane.add(prev);
		
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		next.setBounds(126, 420, 89, 23);
		contentPane.add(next);
		
		JButton finish = new JButton("Finish");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		finish.setBounds(516, 420, 89, 23);
		contentPane.add(finish);
		
		
		timeleft.setBounds(516, 11, 76, 20);
		contentPane.add(timeleft);
		
		timeLeft();
	}
}
