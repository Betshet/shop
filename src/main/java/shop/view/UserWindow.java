package shop.view;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import shop.controller.DAOAuthentification;
import shop.controller.windowControl;
import shop.model.Aisle;
import shop.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class UserWindow
 * Displays the informations about the users in a given list.
 */
public class UserWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnDelete;
	private JButton btnEdit;
	

	/**
	 * Create the frame.
	 * @param userList
	 */
	public UserWindow(ArrayList<User> userList) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] columns = {"Username", "Aisle"};

		DefaultTableModel model = new DefaultTableModel(convert(userList),columns) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOAuthentification daoUser = new DAOAuthentification();
				daoUser.deleteUser(daoUser.getUserByName((String) table.getModel().getValueAt(table.getSelectedRow(), 0)));
				dispose();
				windowControl.launchUserWindow();
			}
		});
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInPopup popup = new SignInPopup("Edit info");
				DAOAuthentification daoUser = new DAOAuthentification();
				try {
					daoUser.editUser(daoUser.getUserByName((String) table.getModel().getValueAt(table.getSelectedRow(), 0)), new User(popup.getTextField().getText(),popup.getTextField_1().getText(),(Aisle)popup.getComboBox().getSelectedItem(),popup.getChckbxManager().isSelected() ));
					dispose();
					windowControl.launchUserWindow();
				} catch (Exception e1) {
					@SuppressWarnings("unused")
					ErrorPopup err = new ErrorPopup("Error");
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdit)
					.addGap(614))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnEdit))
					.addContainerGap(73, Short.MAX_VALUE))
		);


		contentPane.setLayout(gl_contentPane);

		
	}

	public void afficher()
	{
		setVisible(true);
	}
	
	/**
	 * Method convert
	 * Converts a User List to an Object matrix.
	 * @param userList
	 * @return Object matrix containing the users informations.
	 */
	public Object[][] convert(List<User> userList){
		Object[][] obj = new Object[userList.size()][3];
		for(int i = 0; i < userList.size(); i++) {
			User usr = userList.get(i);
			obj[i][0] = usr.getUsername();
			obj[i][1] = usr.getAisle().getName();
		}
		return obj;
	}

}
