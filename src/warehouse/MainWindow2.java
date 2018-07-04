package warehouse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow2 {

	private JFrame frame;
	private JTextField txtInputIndex;
	private JTable table;
	private JTextField txtInputPZ;
	private JTextField txtInputRW;
	private JTextField txtInputZZ;
	private JTextField txtInputProjects;
	private JTextField txtInputClients;
	private JTextField txtInputSuppliers;
	private JTextField txtInputWarehouse;
	Object[][] arrPZ;
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	IndexJDBCTemplate indexJDBCTemplate = (IndexJDBCTemplate)context.getBean("studentJDBCTemplate");
	PZJDBCTemplate PZJDBCTemplate = (PZJDBCTemplate)context.getBean("PZJDBCTemplate");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow2 window = new MainWindow2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1591, 875);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel IndexButtonPanel = new JPanel();
		IndexButtonPanel.setVisible(false);
		IndexButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(IndexButtonPanel);
		IndexButtonPanel.setLayout(null);
		
		JButton btnAddIndex = new JButton("Add Row");
		btnAddIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IndexAddWindow dialog = new IndexAddWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
		btnAddIndex.setBounds(0, 0, 674, 44);
		IndexButtonPanel.add(btnAddIndex);
		
		JButton btnUpdateIndex = new JButton("Update Row");
		btnUpdateIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IndexUpdateWindow dialog = new IndexUpdateWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
					
					Object[] row = arrPZ[table.getSelectedRow()];
					
					dialog.setData(row);
					
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnUpdateIndex.setBounds(0, 40, 674, 44);
		IndexButtonPanel.add(btnUpdateIndex);
		
		JButton btnRemoveIndex = new JButton("Remove Row");
		btnRemoveIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexJDBCTemplate.delete(Integer.parseInt(txtInputIndex.getText()));
			}
		});
		btnRemoveIndex.setBounds(0, 81, 543, 44);
		IndexButtonPanel.add(btnRemoveIndex);
		
		JLabel lblInputIndex = new JLabel("Input Id to remove:");
		lblInputIndex.setBounds(555, 81, 119, 16);
		IndexButtonPanel.add(lblInputIndex);
		
		txtInputIndex = new JTextField();
		txtInputIndex.setBounds(555, 108, 116, 17);
		IndexButtonPanel.add(txtInputIndex);
		txtInputIndex.setColumns(10);
		
		JLabel lblIdindex = new JLabel("Id_Index");
		lblIdindex.setBounds(0, 156, 56, 16);
		IndexButtonPanel.add(lblIdindex);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setBounds(352, 156, 56, 16);
		IndexButtonPanel.add(lblIndex);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(704, 156, 56, 16);
		IndexButtonPanel.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(1056, 156, 56, 16);
		IndexButtonPanel.add(lblPrice);
		
		final JPanel PZButtonPanel = new JPanel();
		PZButtonPanel.setVisible(false);
		PZButtonPanel.setLayout(null);
		PZButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(PZButtonPanel);
		
		JButton btnAddPZ = new JButton("Add Row");
		btnAddPZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PZAddWindow dialog = new PZAddWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception b) {
					b.printStackTrace();
				}
			}
		});
		btnAddPZ.setBounds(0, 0, 674, 44);
		PZButtonPanel.add(btnAddPZ);
		
		JButton btnUpdatePZ = new JButton("Update Row");
		btnUpdatePZ.setBounds(0, 40, 674, 44);
		PZButtonPanel.add(btnUpdatePZ);
		
		JButton btnRemovePZ = new JButton("Remove Row");
		btnRemovePZ.setBounds(0, 81, 543, 44);
		PZButtonPanel.add(btnRemovePZ);
		
		JLabel lblInputPZ = new JLabel("Input Id to remove:");
		lblInputPZ.setBounds(555, 81, 119, 16);
		PZButtonPanel.add(lblInputPZ);
		
		txtInputPZ = new JTextField();
		txtInputPZ.setColumns(10);
		txtInputPZ.setBounds(555, 108, 116, 17);
		PZButtonPanel.add(txtInputPZ);
		
		JLabel lblNewLabel = new JLabel("ID_PZ");
		lblNewLabel.setBounds(0, 156, 56, 16);
		PZButtonPanel.add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(282, 156, 56, 16);
		PZButtonPanel.add(lblNumber);
		
		JLabel lblIdindex_1 = new JLabel("ID_Index");
		lblIdindex_1.setBounds(564, 156, 56, 16);
		PZButtonPanel.add(lblIdindex_1);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(846, 156, 56, 16);
		PZButtonPanel.add(lblQuantity);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(1128, 156, 56, 16);
		PZButtonPanel.add(lblValue);
		
		final JPanel RWButtonPanel = new JPanel();
		RWButtonPanel.setVisible(false);
		RWButtonPanel.setLayout(null);
		RWButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(RWButtonPanel);
		
		JButton btnAddRW = new JButton("Add Row");
		btnAddRW.setBounds(0, 0, 674, 44);
		RWButtonPanel.add(btnAddRW);
		
		JButton btnUpdateRW = new JButton("Update Row");
		btnUpdateRW.setBounds(0, 40, 674, 44);
		RWButtonPanel.add(btnUpdateRW);
		
		JButton btnRemoveRW = new JButton("Remove Row");
		btnRemoveRW.setBounds(0, 81, 543, 44);
		RWButtonPanel.add(btnRemoveRW);
		
		JLabel lblInputRW = new JLabel("Input Id to remove:");
		lblInputRW.setBounds(555, 81, 119, 16);
		RWButtonPanel.add(lblInputRW);
		
		txtInputRW = new JTextField();
		txtInputRW.setColumns(10);
		txtInputRW.setBounds(555, 108, 116, 17);
		RWButtonPanel.add(txtInputRW);
		
		JLabel label = new JLabel("ID_PZ");
		label.setBounds(0, 156, 56, 16);
		RWButtonPanel.add(label);
		
		JLabel label_1 = new JLabel("Number");
		label_1.setBounds(282, 156, 56, 16);
		RWButtonPanel.add(label_1);
		
		JLabel label_2 = new JLabel("ID_Index");
		label_2.setBounds(564, 156, 56, 16);
		RWButtonPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Quantity");
		label_3.setBounds(846, 156, 56, 16);
		RWButtonPanel.add(label_3);
		
		JLabel label_4 = new JLabel("Value");
		label_4.setBounds(1128, 156, 56, 16);
		RWButtonPanel.add(label_4);
		
		final JPanel ZZButtonPanel = new JPanel();
		ZZButtonPanel.setVisible(false);
		ZZButtonPanel.setLayout(null);
		ZZButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(ZZButtonPanel);
		
		JButton btnAddZZ = new JButton("Add Row");
		btnAddZZ.setBounds(0, 0, 674, 44);
		ZZButtonPanel.add(btnAddZZ);
		
		JButton btnUpdateZZ = new JButton("Update Row");
		btnUpdateZZ.setBounds(0, 40, 674, 44);
		ZZButtonPanel.add(btnUpdateZZ);
		
		JButton btnRemoveZZ = new JButton("Remove Row");
		btnRemoveZZ.setBounds(0, 81, 543, 44);
		ZZButtonPanel.add(btnRemoveZZ);
		
		JLabel lblInputZZ = new JLabel("Input Id to remove:");
		lblInputZZ.setBounds(555, 81, 119, 16);
		ZZButtonPanel.add(lblInputZZ);
		
		txtInputZZ = new JTextField();
		txtInputZZ.setColumns(10);
		txtInputZZ.setBounds(555, 108, 116, 17);
		ZZButtonPanel.add(txtInputZZ);
		
		JLabel label_5 = new JLabel("ID_PZ");
		label_5.setBounds(0, 156, 56, 16);
		ZZButtonPanel.add(label_5);
		
		JLabel label_6 = new JLabel("Number");
		label_6.setBounds(282, 156, 56, 16);
		ZZButtonPanel.add(label_6);
		
		JLabel label_7 = new JLabel("ID_Index");
		label_7.setBounds(564, 156, 56, 16);
		ZZButtonPanel.add(label_7);
		
		JLabel label_8 = new JLabel("Quantity");
		label_8.setBounds(846, 156, 56, 16);
		ZZButtonPanel.add(label_8);
		
		JLabel label_9 = new JLabel("Value");
		label_9.setBounds(1128, 156, 56, 16);
		ZZButtonPanel.add(label_9);
		
		final JPanel ProjectsButtonPanel = new JPanel();
		ProjectsButtonPanel.setVisible(false);
		ProjectsButtonPanel.setLayout(null);
		ProjectsButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(ProjectsButtonPanel);
		
		JButton btnAddProjects = new JButton("Add Row");
		btnAddProjects.setBounds(0, 0, 674, 44);
		ProjectsButtonPanel.add(btnAddProjects);
		
		JButton btnUpdateProjects = new JButton("Update Row");
		btnUpdateProjects.setBounds(0, 40, 674, 44);
		ProjectsButtonPanel.add(btnUpdateProjects);
		
		JButton btnRemoveProjects = new JButton("Remove Row");
		btnRemoveProjects.setBounds(0, 81, 543, 44);
		ProjectsButtonPanel.add(btnRemoveProjects);
		
		JLabel lblInputProjects = new JLabel("Input Id to remove:");
		lblInputProjects.setBounds(555, 81, 119, 16);
		ProjectsButtonPanel.add(lblInputProjects);
		
		txtInputProjects = new JTextField();
		txtInputProjects.setColumns(10);
		txtInputProjects.setBounds(555, 108, 116, 17);
		ProjectsButtonPanel.add(txtInputProjects);
		
		JLabel lblID_Projects = new JLabel("ID_Projects");
		lblID_Projects.setBounds(0, 156, 56, 16);
		ProjectsButtonPanel.add(lblID_Projects);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(235, 156, 56, 16);
		ProjectsButtonPanel.add(lblCustomerName);
		
		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(470, 156, 56, 16);
		ProjectsButtonPanel.add(lblMaterial);
		
		JLabel lblMaterialQuantity = new JLabel("Material Quantity");
		lblMaterialQuantity.setBounds(705, 156, 56, 16);
		ProjectsButtonPanel.add(lblMaterialQuantity);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(940, 156, 56, 16);
		ProjectsButtonPanel.add(lblProduct);
		
		JLabel lblProductsQuantity = new JLabel("Products Quantity");
		lblProductsQuantity.setBounds(1175, 156, 56, 16);
		ProjectsButtonPanel.add(lblProductsQuantity);
		
		final JPanel ClientsButtonPanel = new JPanel();
		ClientsButtonPanel.setVisible(false);
		ClientsButtonPanel.setLayout(null);
		ClientsButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(ClientsButtonPanel);
		
		JButton btnAddClients = new JButton("Add Row");
		btnAddClients.setBounds(0, 0, 674, 44);
		ClientsButtonPanel.add(btnAddClients);
		
		JButton btnUpdateClients = new JButton("Update Row");
		btnUpdateClients.setBounds(0, 40, 674, 44);
		ClientsButtonPanel.add(btnUpdateClients);
		
		JButton btnRemoveClients = new JButton("Remove Row");
		btnRemoveClients.setBounds(0, 81, 543, 44);
		ClientsButtonPanel.add(btnRemoveClients);
		
		JLabel lblInputClinets = new JLabel("Input Id to remove:");
		lblInputClinets.setBounds(555, 81, 119, 16);
		ClientsButtonPanel.add(lblInputClinets);
		
		txtInputClients = new JTextField();
		txtInputClients.setColumns(10);
		txtInputClients.setBounds(555, 108, 116, 17);
		ClientsButtonPanel.add(txtInputClients);
		
		JLabel lblIdclients = new JLabel("ID_Clients");
		lblIdclients.setBounds(0, 156, 56, 16);
		ClientsButtonPanel.add(lblIdclients);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(352, 156, 56, 16);
		ClientsButtonPanel.add(lblName_1);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(704, 156, 56, 16);
		ClientsButtonPanel.add(lblAdress);
		
		JLabel lblSalesman = new JLabel("Salesman");
		lblSalesman.setBounds(1057, 156, 56, 16);
		ClientsButtonPanel.add(lblSalesman);
		
		final JPanel SuppliersButtonPanel = new JPanel();
		SuppliersButtonPanel.setVisible(false);
		SuppliersButtonPanel.setLayout(null);
		SuppliersButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(SuppliersButtonPanel);
		
		JButton btnAddSuppliers = new JButton("Add Row");
		btnAddSuppliers.setBounds(0, 0, 674, 44);
		SuppliersButtonPanel.add(btnAddSuppliers);
		
		JButton btnUpdateSuppliers = new JButton("Update Row");
		btnUpdateSuppliers.setBounds(0, 40, 674, 44);
		SuppliersButtonPanel.add(btnUpdateSuppliers);
		
		JButton btnRemoveSuppliers = new JButton("Remove Row");
		btnRemoveSuppliers.setBounds(0, 81, 543, 44);
		SuppliersButtonPanel.add(btnRemoveSuppliers);
		
		JLabel lblInputSuppliers = new JLabel("Input Id to remove:");
		lblInputSuppliers.setBounds(555, 81, 119, 16);
		SuppliersButtonPanel.add(lblInputSuppliers);
		
		txtInputSuppliers = new JTextField();
		txtInputSuppliers.setColumns(10);
		txtInputSuppliers.setBounds(555, 108, 116, 17);
		SuppliersButtonPanel.add(txtInputSuppliers);
		
		JLabel lblIdsuppliers = new JLabel("ID_Suppliers");
		lblIdsuppliers.setBounds(0, 156, 56, 16);
		SuppliersButtonPanel.add(lblIdsuppliers);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(470, 156, 56, 16);
		SuppliersButtonPanel.add(lblName_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(940, 156, 56, 16);
		SuppliersButtonPanel.add(lblAddress);
		
		final JPanel WarehouseButtonPanel = new JPanel();
		WarehouseButtonPanel.setVisible(false);
		WarehouseButtonPanel.setLayout(null);
		WarehouseButtonPanel.setBounds(163, 0, 1410, 185);
		frame.getContentPane().add(WarehouseButtonPanel);
		
		JButton btnAddWarehouse = new JButton("Add Row");
		btnAddWarehouse.setBounds(0, 0, 674, 44);
		WarehouseButtonPanel.add(btnAddWarehouse);
		
		JButton btnUpdateWarehouse = new JButton("Update Row");
		btnUpdateWarehouse.setBounds(0, 40, 674, 44);
		WarehouseButtonPanel.add(btnUpdateWarehouse);
		
		JButton btnRemoveWarehouse = new JButton("Remove Row");
		btnRemoveWarehouse.setBounds(0, 81, 543, 44);
		WarehouseButtonPanel.add(btnRemoveWarehouse);
		
		JLabel lblInputWarehouse = new JLabel("Input Id to remove:");
		lblInputWarehouse.setBounds(555, 81, 119, 16);
		WarehouseButtonPanel.add(lblInputWarehouse);
		
		txtInputWarehouse = new JTextField();
		txtInputWarehouse.setColumns(10);
		txtInputWarehouse.setBounds(555, 108, 116, 17);
		WarehouseButtonPanel.add(txtInputWarehouse);
		
		JLabel lblIdwarehouse = new JLabel("ID_Warehouse");
		lblIdwarehouse.setBounds(0, 156, 56, 16);
		WarehouseButtonPanel.add(lblIdwarehouse);
		
		JLabel lblIndex_1 = new JLabel("Index");
		lblIndex_1.setBounds(470, 156, 56, 16);
		WarehouseButtonPanel.add(lblIndex_1);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setBounds(940, 156, 56, 16);
		WarehouseButtonPanel.add(lblQuantity_1);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBounds(0, 0, 164, 828);
		frame.getContentPane().add(MenuPanel);
		GridBagLayout gbl_MenuPanel = new GridBagLayout();
		gbl_MenuPanel.columnWidths = new int[]{33, 97, 0};
		gbl_MenuPanel.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_MenuPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_MenuPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		MenuPanel.setLayout(gbl_MenuPanel);
		
		JButton btnListIndex = new JButton("List index");
		btnListIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IndexButtonPanel.setVisible(true);
				PZButtonPanel.setVisible(false);
				RWButtonPanel.setVisible(false);
				ZZButtonPanel.setVisible(false);
				ProjectsButtonPanel.setVisible(false);
				ClientsButtonPanel.setVisible(false);
				SuppliersButtonPanel.setVisible(false);
				WarehouseButtonPanel.setVisible(false);
				
				List<Index> index = indexJDBCTemplate.listIndex();
				
				arrPZ = new Object[index.size()][4];
				int count = 0;
				
				for(Index i : index){
					arrPZ[count] = i.getArray();
					count++;
				}
				
				String[] columns = new String[4];
				columns[0] = "ID_Index";
				columns[1] = "Index";
				columns[2] = "Name";
				columns[3] = "Price";
				
				DefaultTableModel dtm = new DefaultTableModel(arrPZ, columns);
				table.setModel(dtm);
				dtm.fireTableDataChanged();
			}
		});
		GridBagConstraints gbc_btnListIndex = new GridBagConstraints();
		gbc_btnListIndex.insets = new Insets(0, 0, 5, 0);
		gbc_btnListIndex.anchor = GridBagConstraints.NORTH;
		gbc_btnListIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListIndex.gridx = 1;
		gbc_btnListIndex.gridy = 5;
		MenuPanel.add(btnListIndex, gbc_btnListIndex);
		
		JButton btnListPz = new JButton("List PZ");
		btnListPz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IndexButtonPanel.setVisible(false);
				PZButtonPanel.setVisible(true);
				RWButtonPanel.setVisible(false);
				ZZButtonPanel.setVisible(false);
				ProjectsButtonPanel.setVisible(false);
				ClientsButtonPanel.setVisible(false);
				SuppliersButtonPanel.setVisible(false);
				WarehouseButtonPanel.setVisible(false);
				
				List<PZ> pz = PZJDBCTemplate.listPZ();
				
				arrPZ = new Object[pz.size()][4];
				int count = 0;
				
				for(PZ i : pz){
					arrPZ[count] = i.getArray();
					count++;
				}
				
				String[] columns = new String[6];
				columns[0] = "ID_PZ";
				columns[1] = "Number";
				columns[2] = "Date";
				columns[3] = "Details";
				columns[4] = "Suma";
				columns[5] = "ID_ZZ-HEADER";
				
				DefaultTableModel dtm = new DefaultTableModel(arrPZ, columns);
				table.setModel(dtm);
				dtm.fireTableDataChanged();
			}
		});
		GridBagConstraints gbc_btnListPz = new GridBagConstraints();
		gbc_btnListPz.insets = new Insets(0, 0, 5, 0);
		gbc_btnListPz.fill = GridBagConstraints.BOTH;
		gbc_btnListPz.gridx = 1;
		gbc_btnListPz.gridy = 6;
		MenuPanel.add(btnListPz, gbc_btnListPz);
		
		JButton btnListRw = new JButton("List RW");
		GridBagConstraints gbc_btnListRw = new GridBagConstraints();
		gbc_btnListRw.insets = new Insets(0, 0, 5, 0);
		gbc_btnListRw.fill = GridBagConstraints.BOTH;
		gbc_btnListRw.gridx = 1;
		gbc_btnListRw.gridy = 7;
		MenuPanel.add(btnListRw, gbc_btnListRw);
		
		JButton btnListZz = new JButton("List ZZ");
		GridBagConstraints gbc_btnListZz = new GridBagConstraints();
		gbc_btnListZz.insets = new Insets(0, 0, 5, 0);
		gbc_btnListZz.fill = GridBagConstraints.BOTH;
		gbc_btnListZz.gridx = 1;
		gbc_btnListZz.gridy = 8;
		MenuPanel.add(btnListZz, gbc_btnListZz);
		
		JButton btnListProjects = new JButton("List Projects");
		GridBagConstraints gbc_btnListProjects = new GridBagConstraints();
		gbc_btnListProjects.insets = new Insets(0, 0, 5, 0);
		gbc_btnListProjects.fill = GridBagConstraints.BOTH;
		gbc_btnListProjects.gridx = 1;
		gbc_btnListProjects.gridy = 9;
		MenuPanel.add(btnListProjects, gbc_btnListProjects);
		
		JButton btnListClients = new JButton("List Clients");
		GridBagConstraints gbc_btnListClients = new GridBagConstraints();
		gbc_btnListClients.insets = new Insets(0, 0, 5, 0);
		gbc_btnListClients.fill = GridBagConstraints.BOTH;
		gbc_btnListClients.gridx = 1;
		gbc_btnListClients.gridy = 10;
		MenuPanel.add(btnListClients, gbc_btnListClients);
		
		JButton btnListSuppliers = new JButton("List Suppliers");
		GridBagConstraints gbc_btnListSuppliers = new GridBagConstraints();
		gbc_btnListSuppliers.insets = new Insets(0, 0, 5, 0);
		gbc_btnListSuppliers.fill = GridBagConstraints.BOTH;
		gbc_btnListSuppliers.gridx = 1;
		gbc_btnListSuppliers.gridy = 11;
		MenuPanel.add(btnListSuppliers, gbc_btnListSuppliers);
		
		JButton btnSpplies = new JButton("Supplies");
		GridBagConstraints gbc_btnSpplies = new GridBagConstraints();
		gbc_btnSpplies.fill = GridBagConstraints.BOTH;
		gbc_btnSpplies.gridx = 1;
		gbc_btnSpplies.gridy = 12;
		MenuPanel.add(btnSpplies, gbc_btnSpplies);
		
		JPanel TablePanel = new JPanel();
		TablePanel.setBounds(163, 185, 1410, 643);
		frame.getContentPane().add(TablePanel);
		TablePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		TablePanel.add(table);
	}
}
