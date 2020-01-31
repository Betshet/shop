package shop.view;

import javax.swing.*;

public class ErrorPopup extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public ErrorPopup(String errorMsg) 
	{
		
		
		JOptionPane.showConfirmDialog(
				null,
				errorMsg,
				"Error",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}

}