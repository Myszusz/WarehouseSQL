package warehouse;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PZAddWindow extends JDialog {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	PZJDBCTemplate PZJDBCTemplate = (PZJDBCTemplate)context.getBean("PZJDBCTemplate");
	private final JPanel contentPanel = new JPanel();
	private JTextField NumberTxt;
	private JTextField DetailsTxt;
	private JTextField SumaTxt;
	private JTextField ID_ZZTxt;

	/**
	 * Create the dialog.
	 */
	public PZAddWindow() {
		setBounds(100, 100, 682, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			NumberTxt = new JTextField();
			NumberTxt.setBounds(12, 42, 629, 22);
			contentPanel.add(NumberTxt);
			NumberTxt.setColumns(10);
		}
		{
			DetailsTxt = new JTextField();
			DetailsTxt.setColumns(10);
			DetailsTxt.setBounds(12, 106, 629, 22);
			contentPanel.add(DetailsTxt);
		}
		{
			SumaTxt = new JTextField();
			SumaTxt.setColumns(10);
			SumaTxt.setBounds(12, 187, 629, 22);
			contentPanel.add(SumaTxt);
		}
		{
			ID_ZZTxt = new JTextField();
			ID_ZZTxt.setColumns(10);
			ID_ZZTxt.setBounds(12, 291, 629, 22);
			contentPanel.add(ID_ZZTxt);
		}
		{
			JLabel lblNumber = new JLabel("Number");
			lblNumber.setBounds(12, 13, 56, 16);
			contentPanel.add(lblNumber);
		}
		{
			JLabel lblDetails = new JLabel("Details");
			lblDetails.setBounds(12, 77, 56, 16);
			contentPanel.add(lblDetails);
		}
		{
			JLabel lblSuma = new JLabel("Suma");
			lblSuma.setBounds(12, 158, 56, 16);
			contentPanel.add(lblSuma);
		}
		{
			JLabel lblIdzz = new JLabel("ID_ZZ");
			lblIdzz.setBounds(12, 262, 56, 16);
			contentPanel.add(lblIdzz);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PZJDBCTemplate.create(Integer.parseInt(NumberTxt.getText()), DetailsTxt.getText(),
								Double.parseDouble(SumaTxt.getText()));
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

}
