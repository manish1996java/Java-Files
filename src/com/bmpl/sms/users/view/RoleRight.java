package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bmpl.sms.users.DAO.UserRoleDAO;
import com.bmpl.sms.users.DTO.UserRoleDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoleRight extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int uid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoleRight frame = new RoleRight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void dataFromTextbox()
	{
		int index = table.getSelectedRow();
		
		uid = Integer.parseInt(table.getModel().getValueAt(index, 0).toString());
		
	}
	
	public void vanishJtable()
	{
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnCount(0);
	}
	
	public void enableUser()
	{
		vanishJtable();
		try {
			urdao.doEnableUser(uid);
			userRoleRowdata();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rowsColumnCreation()
	{
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "role", "status"
				}
			));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(2).setPreferredWidth(432);
		
	}
	
	public void disableUser()
	{
		vanishJtable();
		try {
			urdao.doDisableUser(uid);
			userRoleRowdata();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	UserRoleDAO urdao;
	public void userRoleRowdata()
	{
		rowsColumnCreation();
		urdao = new UserRoleDAO();
		try {
			ArrayList<UserRoleDTO> list = urdao.userRole();
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			Object[] rowData = new Object[4];
			
			for(int i=0;i<list.size();i++){
				rowData[0] = list.get(i).getId();
				rowData[1] = list.get(i).getUser();
				rowData[2] = list.get(i).getRole();
				rowData[3] = list.get(i).getStatus();
				dtm.addRow(rowData);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public RoleRight() {
		setTitle("AdminView");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1047, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 1021, 474);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		tabbedPane.addTab("Roles", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dataFromTextbox();
			}
		});
		
		
		table.setBounds(10, 11, 850, 229);
//		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 996, 394);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnAdduser = new JButton("AddUser");
		btnAdduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser adduser = new AddUser();
				adduser.setVisible(true);
			}
		});
		btnAdduser.setBounds(903, 11, 89, 23);
		panel.add(btnAdduser);
		
		JButton btnNewButton_1 = new JButton("Enable");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableUser();
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnDesable = new JButton("Disable");
		btnDesable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableUser();
			}
		});
		btnDesable.setBounds(111, 11, 89, 23);
		panel.add(btnDesable);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(914, 28, 89, 23);
		contentPane.add(btnNext);
		userRoleRowdata();
	}
}
