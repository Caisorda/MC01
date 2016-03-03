package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AgrarianController;
import model.AgrarianHousehold;

public class AgrarianReform extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private AgrarianController agrarianController;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AgrarianReform frame = new AgrarianReform();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AgrarianReform() {
		this.agrarianController = new AgrarianController();
		setResizable(false);
		setTitle("Town Specialty");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 694, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		this.model = new DefaultTableModel() {

			public boolean isFocusable(int rowIndex, int mColIndex) {
				return false;
			}

			public boolean isCellSelectable(int rowIndex, int mColIndex) {
				return false;
			}
		};
        this.model.setColumnIdentifiers(new String[]{"Household ID", "Carabao", "Cow", "Chicken", "Duck", "Goat", "Pig", "Other Livestock", "Fish", "Crops"});
        this.table.setModel(model);
		scrollPane.setViewportView(table);
		updateTable();
	}
	
	public void clearTable(){

		for (int i = 0; i < this.model.getRowCount(); i++) {
			for (int j = 0; j < this.model.getColumnCount(); j++) {
				this.model.setValueAt(null, i, j);
			}
			this.model.removeRow(i);
		}

		this.model.setRowCount(0);
		this.model.getDataVector().removeAllElements();
		this.model.fireTableDataChanged(); 
	} 
	
	public void updateTable(){
        clearTable();
        for(Iterator i = this.agrarianController.getOptimized(); i.hasNext();){
        	AgrarianHousehold house = ((AgrarianHousehold)i.next());
        	model.setRowCount(model.getRowCount() + 1);
        	model.setValueAt(house.getId(), model.getRowCount() - 1, 0);
        	model.setValueAt(house.getCarabao(), model.getRowCount() - 1, 1);
        	model.setValueAt(house.getChicken(), model.getRowCount() - 1, 2);
        	model.setValueAt(house.getCow(), model.getRowCount() - 1, 3);
        	model.setValueAt(house.getDuck(), model.getRowCount() - 1, 4);
        	model.setValueAt(house.getGoat(), model.getRowCount() - 1, 5);
        	model.setValueAt(house.getPig(), model.getRowCount() - 1, 6);
        	model.setValueAt(house.getOther(), model.getRowCount() - 1, 7);
        	model.setValueAt(house.getFish(), model.getRowCount() - 1, 8);
        	model.setValueAt(house.getCrops(), model.getRowCount() - 1, 9);
        }
        scrollPane.repaint();
        scrollPane.revalidate();
	}

}
