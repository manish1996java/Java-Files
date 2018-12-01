package com.bmpl.sms.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface CommonMethods {

	public static void asktoClose(JFrame frame)
	{
		int cnfrm = JOptionPane.showConfirmDialog(frame, "Do you want to close", "Upload", JOptionPane.YES_NO_OPTION);
		if(cnfrm == JOptionPane.YES_OPTION) {
			frame.setVisible(false);
			frame.dispose();
		}
	}

}
