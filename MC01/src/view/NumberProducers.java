package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import controller.NumberProducerController;
import model.NumberProducer;
public class NumberProducers extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private NumberProducerController numberProducerController;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NumberProducers frame = new NumberProducers();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
////				NumberProducerController  test = new NumberProducerController();
////				test.getHouseHoldCount();
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NumberProducers() {
		setResizable(false);
		setTitle("Number of Producers");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSet = new JLabel("Set Unit of Producer");
		
		JComboBox cbUnit = new JComboBox();
		cbUnit.setModel(new DefaultComboBoxModel(new String[] {"Household", "Town"}));
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSet)
					.addGap(18)
					.addComponent(cbUnit, 0, 108, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSet)
						.addComponent(cbUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
		);
		numberProducerController = new NumberProducerController();
		table = new JTable();
		this.model = new DefaultTableModel() {

			public boolean isFocusable(int rowIndex, int mColIndex) {
				return false;
			}

			public boolean isCellSelectable(int rowIndex, int mColIndex) {
				return false;
			}
		};
        this.model.setColumnIdentifiers(new String[]{"Produce", "Number"});
        this.table.setModel(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		cbUnit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                updateTable((String)cbUnit.getSelectedItem());
			}
        });
        updateTable((String)cbUnit.getSelectedItem());
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
	
	public void updateTable(String unit){
		Iterator i = numberProducerController.get(unit);
        clearTable();
		
		while(i.hasNext()){
			NumberProducer numProd = ((NumberProducer)i.next());
        	model.setRowCount(model.getRowCount() + 1);
        	model.setValueAt(numProd.getProduce(), model.getRowCount() - 1, 0);
        	model.setValueAt(numProd.getNumber(), model.getRowCount() - 1, 1);
        }
        scrollPane.repaint();
        scrollPane.revalidate();
	}
}
