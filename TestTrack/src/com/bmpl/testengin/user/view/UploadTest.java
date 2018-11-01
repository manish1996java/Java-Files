package com.bmpl.testengin.user.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.testengin.question.questionDTO.QuestionDTO;
import com.bmpl.testengin.user.utils.ExcelReader;

public class UploadTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadTest frame = new UploadTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String path;
	JLabel lblNewLabel = new JLabel("");
	JButton btnNewButton_1 = new JButton("Upload");
	private void browse() {
		JFileChooser open = new JFileChooser("Libraries\\Documents");
		open.showOpenDialog(this);
		File file = open.getSelectedFile();
		path = file.getAbsolutePath();
		lblNewLabel.setText(path);
		if(path.trim().length()>0) {
			btnNewButton_1.setEnabled(true);
		}
	}
	
	private void upload() {
		ExcelReader reader = new ExcelReader();
		
//		ArrayList<QuestionDTO> questionDTOs = ExcelReader.
	}
	
//	private void upload() {
//		ArrayList<QuestionDTO> question
//	}

	/**
	 * Create the frame.
	 */
	public UploadTest() {
		setTitle("UploadTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browse();
			}
		});
		btnNewButton.setBounds(41, 59, 108, 23);
		contentPane.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upload();
			}
		});
		
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(221, 59, 108, 23);
		contentPane.add(btnNewButton_1);
		
		
		lblNewLabel.setBounds(49, 120, 323, 23);
		contentPane.add(lblNewLabel);
	}
}
