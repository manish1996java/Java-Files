package com.bmpl.testengin.user.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.testengin.user.userDTO.RightDTO;
import com.bmpl.testengin.user.userDTO.UserDTO;
import com.bmpl.testengin.user.utils.CommonConstants;

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

	/**
	 * Create the frame.
	 */
	
	public void createMenuBar(String username,ArrayList<RightDTO> rights)
	{
		
		
		for(RightDTO right:rights)
		{
			JMenuItem menuitem = new JMenuItem(right.getRight());
			menuitem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String screenName = right.getScreen();
					String fullClassName = CommonConstants.packageName+screenName;
					loadScreen(fullClassName);
				}
				
			});
			menu.add(menuitem);	
		}
	}
	
	
	public void loadScreen(String fullClassName) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the class name");
//		String ProjectName ="com.bmpl.testengin.user.view.";
//		String className = scan.next();
		
		try {
			
			Object object = Class.forName(fullClassName).newInstance();
			Method method = object.getClass().getMethod("setVisible", boolean.class);
				method.invoke(object, true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public DashBoard(UserDTO userDTO) {
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 470);
		
		createMenuBar(userDTO.getUserid(),userDTO.getRight());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
