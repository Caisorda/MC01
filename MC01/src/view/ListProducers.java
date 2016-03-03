package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ListProductController;
import controller.TownProduceController;

public class ListProducers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private TownProduceController townProduceController;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ListProducers frame = new ListProducers();
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
	public ListProducers() {
		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		townProduceController = new TownProduceController();
		String[] produce = new String[]{"Pig", "Cow", "Goat", "Duck", "Chicken", 
				"Carabao", "Sugar Cane", 
				"Palay", "Corn", "Other Crops", "Tilapia", 
				"Milkfish", "Catfish", "Mudfish", "Carp", 
				"Other Aquatic Produce"};
		JComboBox cbProduce = new JComboBox(produce);
		
		JLabel lblSelectProduce = new JLabel("Select Produce");
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectProduce)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(cbProduce, 0, 104, Short.MAX_VALUE)))
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSelectProduce)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbProduce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
        this.model.setColumnIdentifiers(new String[]{"Produce"});
        this.table.setModel(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		cbProduce.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                updateTable((String)cbProduce.getSelectedItem());
			}
        });
		updateTable((String)cbProduce.getSelectedItem());
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
	
	public void updateTable(String produce){
		String result;
		clearTable();
		for(Iterator i = townProduceController.getOptimized(produce); i.hasNext();){
			result = ((String)i.next());
			if(result!=null&&!result.equals("")){
        		model.setRowCount(model.getRowCount() + 1);
        		model.setValueAt(result, model.getRowCount() - 1, 0);
        	}
		}
        scrollPane.repaint();
        scrollPane.revalidate();
	}
}
