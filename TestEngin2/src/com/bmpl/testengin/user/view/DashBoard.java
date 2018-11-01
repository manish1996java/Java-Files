package com.bmpl.testengin.user.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.testengin.user.dto.RightDTO;
import com.bmpl.testengin.user.dto.UserDTO;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DashBoard frame = new DashBoard();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void createMenuBar(ArrayList<RightDTO> rights,String rolename)
	{
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu(rolename);
		
		
		for(RightDTO right:rights)
		{
			JMenuItem menuitem = new JMenuItem(right.getRightName());
			mnFile.add(menuitem);
		}
		menuBar.add(mnFile);
		
//		JMenu mnEdit = new JMenu("Edit");
//		menuBar.add(mnEdit);
		
	}
	/**
	 * Create the frame.
	 */
	public DashBoard(UserDTO userDTO) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		createMenuBar(userDTO.getRights(), userDTO.getRoleName());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
