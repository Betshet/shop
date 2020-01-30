package shop.view;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import shop.controller.DAOArticle;
import shop.controller.windowControl;
import shop.model.Article;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AisleWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Create the frame.
	 */
	public AisleWindow(List<Article> articleList) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] columns = {"ID", "Name", "Price"};

		DefaultTableModel model = new DefaultTableModel(convert(articleList),columns) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(186, Short.MAX_VALUE))
		);


		contentPane.setLayout(gl_contentPane);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	if(!event.getValueIsAdjusting()) {
		            windowControl.launchDetailWindow(DAOArticle.getArticleById((Integer) table.getValueAt(table.getSelectedRow(), 0)));
	        	}
	        }
	    });
	}

	public void afficher()
	{
		setVisible(true);
	}

	public Object[][] convert(List<Article> articleList){
		Object[][] obj = new Object[articleList.size()][3];
		for(int i = 0; i < articleList.size(); i++) {
			Article art = articleList.get(i);
			obj[i][0] = art.getId();
			obj[i][1] = art.getName();
			obj[i][2] = art.getPrice();
		}
		return obj;
	}

}
