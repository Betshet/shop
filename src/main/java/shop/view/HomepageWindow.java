package shop.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shop.controller.DAOAuthentification;
import shop.controller.windowControl;
import shop.model.Aisle;
import shop.model.User;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HomepageWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	/**
	 * Create the frame.
	 */
	public HomepageWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblShopHomepage = new JLabel("Shop homepage");
		
		JLabel lblUsername = new JLabel("Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOAuthentification daoAuth = new DAOAuthentification();
				User checkAuth = daoAuth.checkAuth(textField.getText(),textField_1.getText());
				if(checkAuth != null) {
					windowControl.launchArticleWindow(checkAuth.getAisle());
				}
				else {
					@SuppressWarnings("unused")
					ErrorPopup err = new ErrorPopup("Authentification failed");
				}
			}
		});
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInPopup popup = new SignInPopup();
				DAOAuthentification daoAuth = new DAOAuthentification();
				
				try {
					daoAuth.signIn(popup.getTextField().getText(),popup.getTextField_1().getText(),(Aisle)popup.getComboBox().getSelectedItem(),popup.getChckbxManager().isSelected());
				} catch (Exception e1) {
					@SuppressWarnings("unused")
					ErrorPopup err = new ErrorPopup("Error");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblUsername)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblShopHomepage)))
					.addContainerGap(130, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(164, Short.MAX_VALUE)
					.addComponent(btnConfirm)
					.addGap(74)
					.addComponent(btnSignIn))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblShopHomepage)
					.addGap(45)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addGap(11)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignIn)
						.addComponent(btnConfirm))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	public void afficher()
	{
		setVisible(true);
	}
}
