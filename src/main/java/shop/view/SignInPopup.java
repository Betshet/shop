package shop.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import shop.controller.DAOAisle;
import shop.model.Aisle;

public class SignInPopup extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Aisle> comboBox;
	private JCheckBox chckbxManager;
	
	

	public SignInPopup() 
	{
		JLabel lblUsername = new JLabel("Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAisle = new JLabel("Aisle");
		
		DAOAisle daoAisle = new DAOAisle();
		comboBox = new JComboBox<Aisle>(new DefaultComboBoxModel<Aisle>(daoAisle.convert(daoAisle.getAllAisles())));
		
		chckbxManager = new JCheckBox("Manager");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(177)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxManager)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAisle)
						.addComponent(lblPassword)
						.addComponent(lblUsername)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAisle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(chckbxManager)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		JOptionPane.showConfirmDialog(
				null,
				this,
                "Sign in",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE
                );
	}


	public JTextField getTextField() {
		return textField;
	}


	public JTextField getTextField_1() {
		return textField_1;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JComboBox<Aisle> getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox<Aisle> comboBox) {
		this.comboBox = comboBox;
	}


	public JCheckBox getChckbxManager() {
		return chckbxManager;
	}


	public void setChckbxManager(JCheckBox chckbxManager) {
		this.chckbxManager = chckbxManager;
	}

}