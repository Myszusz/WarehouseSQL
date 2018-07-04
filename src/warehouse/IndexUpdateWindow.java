package warehouse;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class IndexUpdateWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IndexTxt;
	private JTextField NameTxt;
	private JTextField PriceTxt;
	private int id;

	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	IndexJDBCTemplate indexJDBCTemplate = (IndexJDBCTemplate)context.getBean("studentJDBCTemplate");
	/**
	 * Create the dialog.
	 */
	public IndexUpdateWindow() {
		setBounds(100, 100, 523, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			IndexTxt = new JTextField();
			IndexTxt.setBounds(12, 40, 481, 29);
			contentPanel.add(IndexTxt);
			IndexTxt.setColumns(10);
		}
		{
			NameTxt = new JTextField();
			NameTxt.setBounds(12, 116, 481, 29);
			contentPanel.add(NameTxt);
			NameTxt.setColumns(10);
		}
		{
			PriceTxt = new JTextField();
			PriceTxt.setToolTipText("Podaj warto\u015Bc po przecinku");
			PriceTxt.setBounds(12, 215, 481, 29);
			contentPanel.add(PriceTxt);
			PriceTxt.setColumns(10);
		}
		{
			JLabel lblIndex = new JLabel("Index");
			lblIndex.setBounds(12, 13, 56, 16);
			contentPanel.add(lblIndex);
		}
		{
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(12, 87, 56, 16);
			contentPanel.add(lblName);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setBounds(12, 186, 56, 16);
			contentPanel.add(lblPrice);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						indexJDBCTemplate.update(id, IndexTxt.getText(), NameTxt.getText(), Double.parseDouble(PriceTxt.getText()));
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
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setData(Object[] row) {
		id = (Integer) row[0];
		IndexTxt.setText((String) row[1]);
		NameTxt.setText((String) row[2]);
		Double price = (Double) row[3];
		PriceTxt.setText(price.toString());
	}
}
