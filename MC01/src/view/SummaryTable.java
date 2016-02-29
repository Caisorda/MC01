package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SummaryTable {

	private JFrame frmSummaryTable;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SummaryTable window = new SummaryTable();
//					window.frmSummaryTable.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SummaryTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSummaryTable = new JFrame();
		frmSummaryTable.setTitle("Summary Table");
		frmSummaryTable.setBounds(100, 100, 800, 175);
//		frmSummaryTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmSummaryTable.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		table = new JTable();
		this.model = new DefaultTableModel() {

			public boolean isFocusable(int rowIndex, int mColIndex) {
				return false;
			}

			public boolean isCellSelectable(int rowIndex, int mColIndex) {
				return false;
			}
		};
        this.model.setColumnIdentifiers(new String[]{"Query Number", "Description", "Unoptimized Runtime", "Optimized Runtime"});
        this.table.setModel(model);
		scrollPane.setViewportView(table);
		frmSummaryTable.getContentPane().setLayout(groupLayout);
		initializeTable();
		frmSummaryTable.setVisible(true);
	}
	
	public void initializeTable(){
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("1", model.getRowCount() - 1, 0);
		model.setValueAt("Number of households that produce each product", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("2", model.getRowCount() - 1, 0);
		model.setValueAt("Number of towns that produce each product", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("3", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("4", model.getRowCount() - 1, 0);
		model.setValueAt("List of products produced by each town", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("5", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce crops", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("6", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce aquatic products", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("7", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce livestock", model.getRowCount() - 1, 1);
	}
}
