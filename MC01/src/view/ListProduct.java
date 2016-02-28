package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

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
import controller.MunicipalityController;
import model.Municipality;

public class ListProduct extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private ListProductController listProductController;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ListProduct frame = new ListProduct();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public ListProduct(){
		setResizable(false);
		setBounds(100, 100, 150, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String[] muns = new String[]{"1", "2", "3", "4", "5", "6", "7", 
									 "8", "9", "10", "11", "12", "13", 
									 "14", "15", "16", "17", "18", "19", 
									 "20", "21", "22", "23", "24"};
		JComboBox cbProduce = new JComboBox(muns);
		//subject to change
		JLabel lblSelectProduce = new JLabel("Select Town");
		
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
		
		this.table = new JTable();
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
		
		cbProduce.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event) {
                updateTable((String)cbProduce.getSelectedItem());
            }
        });
		listProductController = new ListProductController();
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
	
	public void updateTable(String town){
		ArrayList<String> products = new ArrayList();
		products.addAll(listProductController.get(town));
        clearTable();
        for(String product: products){
        	if(product!=null&&!product.equals("")){
        		model.setRowCount(model.getRowCount() + 1);
        		model.setValueAt(product, model.getRowCount() - 1, 0);
        	}
        }
        scrollPane.repaint();
        scrollPane.revalidate();
	}
}

