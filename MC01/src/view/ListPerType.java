package view;

import controller.MunicipalityController;
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
import javax.swing.DefaultComboBoxModel;
import model.Municipality;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Crop;
import model.Fish;
import model.Livestock;

public class ListPerType extends JFrame {

	private JPanel contentPane;
	private JTable table;
        private JComboBox typesCB;
        private JTextField typesTA;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ListPerType frame = new ListPerType();
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
	public ListPerType() {
		setResizable(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 190, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox cbProduce = new JComboBox();
		cbProduce.setModel(new DefaultComboBoxModel(new String[] {"", "Agricultural", "Livestock", "Aquatic/Fishery"}));
                cbProduce.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        JComboBox comboBox = (JComboBox) event.getSource();
                        Object item = event.getItem();

                        MunicipalityController mc = new MunicipalityController();
                        DefaultTableModel model = new DefaultTableModel();
                        ArrayList<Municipality> result = new ArrayList<>();
                        
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            switch(item.toString()){
                                case "Agricultural": result = mc.optimizedProduceCrops();
                                                     typesCB.setModel(new DefaultComboBoxModel(new String[] {"All", "Sugarcane", "Palay", "Corn", "Coffee", "Others"}));
                                                     typesTA.setText("");
                                                     typesTA.setEditable(false);   
                                                     break;
                                case "Livestock": result = mc.optimizedProduceLivestock();
                                                  typesCB.setModel(new DefaultComboBoxModel(new String[] {"All", "Hog", "Goat", "Carabao", "Cow", "Chicken", "Duck", "Others"}));
                                                  typesTA.setText("");
                                                  typesTA.setEditable(false);  
                                                  break;
                                case "Aquatic/Fishery": result = mc.optimizedProduceFish();
                                                        typesCB.setModel(new DefaultComboBoxModel(new String[] {"All", "Tilapa", "Milkfish", "Catfish", "Mudfish", "Carp", "Others"}));
                                                        typesTA.setText("");
                                                        typesTA.setEditable(false);
                                                        break;
                                default: result = new ArrayList<>();
                                         typesTA.setText("");
                                         typesTA.setEditable(false);         
                                         typesCB.setModel(new DefaultComboBoxModel(new String[] {}));
                            }
                            String[] towns = new String[result.size()];
                            for(int i = 0; i < result.size() ; i++){
                                towns[i] = result.get(i).getMunNum();
                            }
                            model.addColumn("Town Name",towns);
                            table.setModel(model);
                        }
                    }
                });
		
		JLabel lblSelectProduce = new JLabel("Select Type");
		
		JScrollPane scrollPane = new JScrollPane();
		
		typesCB = new JComboBox();
                typesCB.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        JComboBox comboBox = (JComboBox) event.getSource();
                        Object item = event.getItem();

                        MunicipalityController mc = new MunicipalityController();
                        DefaultTableModel model = new DefaultTableModel();
                        ArrayList<Municipality> result = new ArrayList<>();
                        
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            switch((String)cbProduce.getSelectedItem()){
                                case "Agricultural": switch(item.toString()){
                                                        case "All": result = mc.optimizedProduceCrops();
                                                                    typesTA.setText("");
                                                                    typesTA.setEditable(false);
                                                                 break;
                                                        case "Sugarcane": result = mc.optimizedProduceCrops(Crop.SUGARCANE_KEY);
                                                                          typesTA.setText("");
                                                                          typesTA.setEditable(false);
                                                                 break;
                                                        case "Palay": result = mc.optimizedProduceCrops(Crop.PALAY_KEY);
                                                                      typesTA.setText("");
                                                                      typesTA.setEditable(false);
                                                                 break;
                                                        case "Corn": result = mc.optimizedProduceCrops(Crop.CORN_KEY);
                                                                     typesTA.setText("");
                                                                     typesTA.setEditable(false);
                                                                 break;
                                                        case "Coffee": result = mc.optimizedProduceCrops(Crop.COFFEE_KEY);
                                                                       typesTA.setText("");
                                                                       typesTA.setEditable(false);
                                                                 break;
                                                        case "Others": typesTA.setEditable(true);
                                                                 break;
                                                     }
                                                        break;
                                case "Livestock": switch(item.toString()){
                                                        case "All": result = mc.optimizedProduceLivestock();
                                                                    typesTA.setText("");
                                                                    typesTA.setEditable(false);
                                                                 break;
                                                        case "Hog": result = mc.optimizedProduceLivestock(Livestock.HOG_KEY);
                                                                          typesTA.setText("");
                                                                          typesTA.setEditable(false);
                                                                 break;
                                                        case "Goat": result = mc.optimizedProduceLivestock(Livestock.GOAT_KEY);
                                                                      typesTA.setText("");
                                                                      typesTA.setEditable(false);
                                                                 break;
                                                        case "Carabao": result = mc.optimizedProduceLivestock(Livestock.CARABAO_KEY);
                                                                     typesTA.setText("");
                                                                     typesTA.setEditable(false);
                                                                 break;
                                                        case "Cow": result = mc.optimizedProduceLivestock(Livestock.COW_KEY);
                                                                       typesTA.setText("");
                                                                       typesTA.setEditable(false);
                                                                 break;
                                                        case "Chicken": result = mc.optimizedProduceLivestock(Livestock.CHICKEN_KEY);
                                                                       typesTA.setText("");
                                                                       typesTA.setEditable(false);
                                                                 break;
                                                        case "Duck": result = mc.optimizedProduceLivestock(Livestock.DUCK_KEY);
                                                                       typesTA.setText("");
                                                                       typesTA.setEditable(false);
                                                                 break;
                                                        case "Others": typesTA.setEditable(true);
                                                                 break;
                                                     }
                                                    break;
                                case "Aquatic/Fishery": switch(item.toString()){
                                                        case "All": result = mc.optimizedProduceFish();
                                                                    typesTA.setText("");
                                                                    typesTA.setEditable(false);
                                                                 break;
                                                        case "Tilapa": result = mc.optimizedProduceFish(Fish.TILAPIA_KEY);
                                                                          typesTA.setText("");
                                                                          typesTA.setEditable(false);
                                                                 break;
                                                        case "Milkfish": result = mc.optimizedProduceFish(Fish.MILKFISH_KEY);
                                                                      typesTA.setText("");
                                                                      typesTA.setEditable(false);
                                                                 break;
                                                        case "Catfish": result = mc.optimizedProduceFish(Fish.CATFISH_KEY);
                                                                     typesTA.setText("");
                                                                     typesTA.setEditable(false);
                                                                 break;
                                                        case "Mudfish": result = mc.optimizedProduceFish(Fish.MUDFISH_KEY);
                                                                       typesTA.setText("");
                                                                       typesTA.setEditable(false);
                                                                 break;
                                                        case "Carp": result = mc.optimizedProduceFish(Fish.CARP_KEY);
                                                                       typesTA.setText("");
                                                                       typesTA.setEditable(false);
                                                                 break;
                                                        case "Others": typesTA.setEditable(true);
                                                                 break;
                                                     }
                                                        break;
                                default: result = new ArrayList<>();
                                                  typesCB.setModel(new DefaultComboBoxModel(new String[] {}));
                            }
                            String[] towns = new String[result.size()];
                            for(int i = 0; i < result.size() ; i++){
                                towns[i] = result.get(i).getMunNum();
                            }
                            model.addColumn("Town Name",towns);
                            table.setModel(model);
                        }
                    }
                });
		
		typesTA = new JTextField();
                typesTA.setEditable(false);
                typesTA.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField textField = (JTextField) e.getSource();
                        MunicipalityController mc = new MunicipalityController();
                        DefaultTableModel model = new DefaultTableModel();
                        ArrayList<Municipality> result = new ArrayList<>();
                        switch((String)cbProduce.getSelectedItem()){
                            case "Agricultural": result = mc.optimizedProduceCrops(textField.getText());
                                                 break;
                            case "Livestock": result = mc.optimizedProduceLivestock(textField.getText());
                                              break;
                            case "Aquatic/Fishery": result = mc.optimizedProduceFish(textField.getText());
                                                    break;
                        }
                        String[] towns = new String[result.size()];
                        for(int i = 0; i < result.size() ; i++){
                            towns[i] = result.get(i).getMunNum();
                        }
                        model.addColumn("Town Name",towns);
                        table.setModel(model);
                    }
                });
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(typesCB, 0, 144, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(typesTA, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSelectProduce)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbProduce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(typesCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(typesTA, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Town Name"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}