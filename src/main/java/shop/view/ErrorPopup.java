package shop.view;

import javax.swing.*;
/**
 * Class ErrorPopup
 * Displays a popup with a customizable message.
 *
 */
public class ErrorPopup extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Create and display the frame.
	 * @param errorMsg
	 */
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