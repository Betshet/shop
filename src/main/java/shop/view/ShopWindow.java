package shop.view;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import shop.controller.DAOAisle;
import shop.controller.windowControl;
import shop.model.Aisle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class ShopWindow
 * Displays all the id and name of all aisles in a given list.
 *
 */
public class ShopWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private DAOAisle daoAisle;
	private JButton btnManageAccounts;
	

	/**
	 * Create the frame.
	 * @param aisleList
	 */
	public ShopWindow(List<Aisle> aisleList) {
		daoAisle = new DAOAisle();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] columns = {"ID", "Aisle"};

		DefaultTableModel model = new DefaultTableModel(convert(aisleList),columns) {
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
		
		btnManageAccounts = new JButton("Manage accounts");
		btnManageAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowControl.launchUserWindow();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnManageAccounts)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnManageAccounts)
					.addContainerGap(73, Short.MAX_VALUE))
		);


		contentPane.setLayout(gl_contentPane);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	if(!event.getValueIsAdjusting()) {
		            windowControl.launchArticleWindow(daoAisle.getAisleById((Integer) table.getValueAt(table.getSelectedRow(), 0)));
	        	}
	        }
	    });
	}

	public void afficher()
	{
		setVisible(true);
	}
	/**
	 * Method convert
	 * Converts a List of aisles in an object matrix.
	 * @param aisleList
	 * @return Object matrix containing the aisle information.
	 */
	public Object[][] convert(List<Aisle> aisleList){
		Object[][] obj = new Object[aisleList.size()][3];
		for(int i = 0; i < aisleList.size(); i++) {
			Aisle art = aisleList.get(i);
			obj[i][0] = art.getId();
			obj[i][1] = art.getName();
		}
		return obj;
	}

}
