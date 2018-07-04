package warehouse;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class IndexAddWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	IndexJDBCTemplate indexJDBCTemplate = (IndexJDBCTemplate)context.getBean("studentJDBCTemplate");
	private JTextField IndexTxt;
	private JTextField NameTxt;
	private JTextField PriceTxt;
	/**
	 * Create the dialog.
	 */
	public IndexAddWindow() {
		setBounds(100, 100, 582, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIndex = new JLabel("Index");
			lblIndex.setBounds(12, 20, 56, 16);
			contentPanel.add(lblIndex);
		}
		{
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(12, 120, 56, 16);
			contentPanel.add(lblName);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setBounds(12, 218, 56, 16);
			contentPanel.add(lblPrice);
		}
		
		IndexTxt = new JTextField();
		IndexTxt.setBounds(12, 46, 540, 28);
		contentPanel.add(IndexTxt);
		IndexTxt.setColumns(10);
		
		NameTxt = new JTextField();
		NameTxt.setBounds(12, 144, 540, 28);
		contentPanel.add(NameTxt);
		NameTxt.setColumns(10);
		
		PriceTxt = new JTextField();
		PriceTxt.setBounds(12, 240, 540, 28);
		contentPanel.add(PriceTxt);
		PriceTxt.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					indexJDBCTemplate.create(IndexTxt.getText(), NameTxt.getText(), Double.parseDouble(PriceTxt.getText()));
				}
			});
			buttonPane.add(btnAdd);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						indexJDBCTemplate.create(IndexTxt.getText(), NameTxt.getText(), Double.parseDouble(PriceTxt.getText()));
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
