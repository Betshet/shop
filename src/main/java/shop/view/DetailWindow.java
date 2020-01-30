package shop.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shop.model.Article;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DetailWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DetailWindow(Article article) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblArticleName = new JLabel("Article name");
		
		JLabel label = new JLabel(article.getName());
		
		JLabel lblDescription = new JLabel("Description");
		
		JLabel label_1 = new JLabel(article.getDesc());
		
		JLabel lblStock = new JLabel("Stock");
		
		JLabel label_2 = new JLabel(Integer.toString(article.getStock()));
		
		JLabel lblPrice = new JLabel("Price");
		
		JLabel label_3 = new JLabel(Float.toString(article.getPrice()));
		
		JButton btnOrderMore = new JButton("Order more");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblArticleName)
									.addPreferredGap(ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
									.addComponent(lblStock))
								.addComponent(label)
								.addComponent(lblDescription)
								.addComponent(label_1)
								.addComponent(label_2, Alignment.TRAILING)
								.addComponent(lblPrice, Alignment.TRAILING)
								.addComponent(label_3, Alignment.TRAILING))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnOrderMore)
							.addGap(159))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArticleName)
						.addComponent(lblStock))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(lblPrice)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3)
							.addGap(5)
							.addComponent(lblDescription)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1))
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(btnOrderMore)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void afficher()
	{
		setVisible(true);
	}
}
