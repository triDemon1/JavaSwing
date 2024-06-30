package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import model.Mobile;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MobileManagerController;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.UIManager;

public class MobileManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Mobile mobiles;
	private JLabel lbID;
	private JTextField txbID;
	private JTextField txbName;
	private JTextField txbPrice;
	private JTextField txbTotal;
	private JTextField txbBattery;
	private JComboBox cbbColor;
	private JTextField txbBrand;
	private JTable tableList;
	private DefaultTableModel model;

	public JTable getTableList() {
		return tableList;
	}

	public void setTableList(JTable tableList) {
		this.tableList = tableList;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public String getTxbID() {
		return txbID.getText();
	}

	public void setTxbID(String id) {
		this.txbID.setText(id);
	}

	public String getTxbName() {
		return txbName.getText();
	}

	public void setTxbName(String txbName) {
		this.txbName.setText(txbName);
	}

	public String getTxbPrice() {
		return txbPrice.getText();
	}

	public void setTxbPrice(String txbPrice) {
		this.txbPrice.setText(txbPrice);
	}

	public String getTxbTotal() {
		return txbTotal.getText();
	}

	public void setTxbTotal(String txbTotal) {
		this.txbTotal.setText(txbTotal);
	}

	public String getTxbBattery() {
		return txbBattery.getText();
	}

	public void setTxbBattery(String txbBattery) {
		this.txbBattery.setText(txbBattery);
	}

	public String getTxbBrand() {
		return txbBrand.getText();
	}

	public void setTxbBrand(String txbBrand) {

		this.txbBrand.setText(txbBrand);
	}

	public String getCbbColor() {
		return cbbColor.getSelectedItem().toString();
	}

	public void setCbbColor(String cbbColor) {
		this.cbbColor.setSelectedItem(cbbColor);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MobileManagerView frame = new MobileManagerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MobileManagerView() {
		this.mobiles = new Mobile();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 678);
		ActionListener action = new MobileManagerController(this);
		ListSelectionListener list = new MobileManagerController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuBar.add(menuAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBounds(10, 10, 1013, 231);
		contentPane.add(panel);
		panel.setLayout(null);

		lbID = new JLabel("Product ID");
		lbID.setForeground(new Color(0, 0, 0));
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbID.setBounds(10, 48, 98, 15);
		panel.add(lbID);

		JLabel lbName = new JLabel("Product Name");
		lbName.setForeground(new Color(0, 0, 0));
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbName.setBounds(10, 100, 98, 15);
		panel.add(lbName);

		JLabel lbPrice = new JLabel("Product Price");
		lbPrice.setForeground(new Color(0, 0, 0));
		lbPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPrice.setBounds(10, 151, 98, 15);
		panel.add(lbPrice);

		JLabel lbTotal = new JLabel("Product Total");
		lbTotal.setForeground(new Color(0, 0, 0));
		lbTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTotal.setBounds(10, 203, 98, 15);
		panel.add(lbTotal);

		JLabel lbColor = new JLabel("Color");
		lbColor.setForeground(new Color(0, 0, 0));
		lbColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbColor.setBounds(422, 48, 98, 15);
		panel.add(lbColor);

		JLabel lbBattery = new JLabel("Battery Life");
		lbBattery.setForeground(new Color(0, 0, 0));
		lbBattery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbBattery.setBounds(422, 100, 98, 15);
		panel.add(lbBattery);

		JLabel lbBrand = new JLabel("Brand");
		lbBrand.setForeground(new Color(0, 0, 0));
		lbBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbBrand.setBounds(422, 151, 98, 15);
		panel.add(lbBrand);

		txbID = new JTextField();
		txbID.setBounds(137, 38, 176, 28);
		panel.add(txbID);
		txbID.setColumns(10);

		txbName = new JTextField();
		txbName.setColumns(10);
		txbName.setBounds(137, 96, 176, 28);
		panel.add(txbName);

		txbPrice = new JTextField();
		txbPrice.setColumns(10);
		txbPrice.setBounds(137, 147, 176, 28);
		panel.add(txbPrice);

		txbTotal = new JTextField();
		txbTotal.setColumns(10);
		txbTotal.setBounds(137, 199, 176, 28);
		panel.add(txbTotal);

		cbbColor = new JComboBox();
		String color[] = { "BLUE", "RED", "PURPLE", "YELLOW", "PINK" };
		for (String a : color) {
			cbbColor.addItem(a);
		}
		cbbColor.setBounds(530, 37, 178, 26);
		panel.add(cbbColor);

		txbBattery = new JTextField();
		txbBattery.setColumns(10);
		txbBattery.setBounds(532, 96, 176, 28);
		panel.add(txbBattery);

		txbBrand = new JTextField();
		txbBrand.setColumns(10);
		txbBrand.setBounds(532, 147, 176, 28);
		panel.add(txbBrand);

		JLabel lblProductLabel = new JLabel("Product Information");
		lblProductLabel.setBounds(0, 0, 178, 28);
		panel.add(lblProductLabel);
		lblProductLabel.setForeground(new Color(0, 0, 0));
		lblProductLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		tableList = new JTable(this.model);
		tableList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NAME", "PRICE", "TOTAL", "COLOR", "BATTERY", "BRAND" }));
		tableList.setBounds(0, 0, 1, 1);
		tableList.getSelectionModel().addListSelectionListener(list);
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.setBounds(10, 274, 1019, 247);
		contentPane.add(scrollPane);
		
		JLabel lbList = new JLabel("List Product");
		lbList.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbList.setBounds(10, 247, 163, 25);
		contentPane.add(lbList);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 531, 1019, 78);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		Button btnInsert = new Button("Insert");
		btnInsert.addActionListener(action);
		btnInsert.setBackground(SystemColor.activeCaptionBorder);
		btnInsert.setForeground(SystemColor.desktop);
		btnInsert.setFont(new Font("Dialog", Font.BOLD, 12));
		btnInsert.setBounds(73, 35, 136, 41);
		panel_1.add(btnInsert);

		JLabel lblNewLabel = new JLabel("Function");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 82, 29);
		panel_1.add(lblNewLabel);

		Button btnUpdate = new Button("Update");
		btnUpdate.addActionListener(action);
		btnUpdate.setForeground(SystemColor.desktop);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUpdate.setBackground(SystemColor.activeCaptionBorder);
		btnUpdate.setBounds(236, 35, 136, 41);
		panel_1.add(btnUpdate);

		Button btnRemove = new Button("Delete");
		btnRemove.addActionListener(action);
		btnRemove.setForeground(SystemColor.desktop);
		btnRemove.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRemove.setBackground(SystemColor.activeCaptionBorder);
		btnRemove.setBounds(410, 35, 136, 41);
		panel_1.add(btnRemove);

		Button btnSort = new Button("Sort");
		btnSort.addActionListener(action);
		btnSort.setForeground(SystemColor.desktop);
		btnSort.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSort.setBackground(SystemColor.activeCaptionBorder);
		btnSort.setBounds(584, 35, 136, 41);
		panel_1.add(btnSort);

		Button btnSearch = new Button("Search");
		btnSearch.addActionListener(action);
		btnSearch.setForeground(SystemColor.desktop);
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSearch.setBackground(SystemColor.activeCaptionBorder);
		btnSearch.setBounds(750, 35, 136, 41);
		panel_1.add(btnSearch);
	}

	public void reset() {
		txbID.setText("");
		txbName.setText("");
		txbPrice.setText("");
		txbTotal.setText("");
		txbBattery.setText("");
		txbBrand.setText("");
		cbbColor.setSelectedIndex(0);
	}


	// ham them
	public boolean insert(Mobile m) {
		return this.mobiles.addMobile(m);
	}
	
	// ham xoa
	public boolean remove(Mobile m) {
		return this.mobiles.delMobile(m);
	}
	
	// ham hien thi
	public void display(JTable table) {
		if (model == null) {
			for (Mobile m : this.mobiles.mobileInventory) {
				model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { m.getProduct_id() + "", m.getProduct_name(), m.getProduct_price() + "",
						m.getProduct_total() + "", m.getColor(), m.getBatteryLife() + "", m.getBrand() });
			}
		} else {
			model.setRowCount(0);
			for (Mobile m : this.mobiles.mobileInventory) {
				model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { m.getProduct_id() + "", m.getProduct_name(), m.getProduct_price() + "",
						m.getProduct_total() + "", m.getColor(), m.getBatteryLife() + "", m.getBrand() });
			}
		}
	}
	// ham sap xep
	public void Sort(JTable table) {
		ArrayList<Mobile> sortedList = this.mobiles.sortedMobile(0);
		for (Mobile m : sortedList) {
			model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { m.getProduct_id() + "", m.getProduct_name(), m.getProduct_price() + "",
					m.getProduct_total() + "", m.getColor(), m.getBatteryLife() + "", m.getBrand() });
		}
	}
	
	// ham tim kiem
	public boolean SearchName(String a, JTable table) {
		// TODO Auto-generated method stub
		ArrayList<Mobile> searchList = this.mobiles.searchMobile(a);
		if (searchList == null) {
			return false;
		} else {
			model.setRowCount(0);
			for (Mobile m : searchList) {
				model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { m.getProduct_id() + "", m.getProduct_name(), m.getProduct_price() + "",
						m.getProduct_total() + "", m.getColor(), m.getBatteryLife() + "", m.getBrand() });
			}
		}
		return true;
	}

	// ham luu file
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream(this.mobiles.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.mobiles.mobileInventory);
            //closing the stream
            oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// ham doc file
	public void openFile() {
		List<Mobile> list = new ArrayList<Mobile>();
		try {
			FileInputStream fis = new FileInputStream(this.mobiles.getFileName());
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					list = (ArrayList<Mobile>) ois.readObject();
				} catch (EOFException eof) {
					// Kết thúc tệp tin, thoát vòng lặp
					break;
				}
			}
			this.mobiles.mobileInventory = list;
			ois.close();
			display(tableList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
