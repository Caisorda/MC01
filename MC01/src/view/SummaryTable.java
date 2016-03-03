package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import model.AgrarianDAO;
import model.Household_ProduceDAO;
import model.ListProductDAO;
import model.ListTownPerProduceDAO;
import model.Municipality;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Crop;
import model.Fish;
import model.Livestock;

public class SummaryTable {

	private JFrame frmSummaryTable;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SummaryTable window = new SummaryTable();
					window.frmSummaryTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		testQueries();
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
		model.setValueAt("List of towns that produce each product (Hogs)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Carabao)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Chicken)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Cows)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Crops - Sugarcane)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Duck)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Fishes - Tilapia)", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce each product (Goat)", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("4", model.getRowCount() - 1, 0);
		model.setValueAt("List of products produced by each town", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("5", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce crops in general", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
                model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce crops using a pre-defined ID (Sugarcane ID as test case)", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
                model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce crops using a string ('cassava' as test case)", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("6", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce aquatic products in general", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
                model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce aquatic products using a pre-defined ID (Tilapia ID as test case)", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
                model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce aquatic products using a string ('bisugo' as test case)", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
		model.setValueAt("7", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce livestock in general", model.getRowCount() - 1, 1);
                model.setRowCount(model.getRowCount() + 1);
                model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce livestock using a pre-defined ID (Hog ID as test case)", model.getRowCount() - 1, 1);
		model.setRowCount(model.getRowCount() + 1);
                model.setValueAt("", model.getRowCount() - 1, 0);
		model.setValueAt("List of towns that produce livestock using a string ('aso' as test case)", model.getRowCount() - 1, 1);
	}
	
	public void testQueries(){
            Household_ProduceDAO hpDAO = new Household_ProduceDAO();
            AgrarianDAO aDAO = new AgrarianDAO();
            ListTownPerProduceDAO ltppDAO = new ListTownPerProduceDAO();
            ListProductDAO lpDao = new ListProductDAO();
            Municipality mDAO = new Municipality();
            
            // variables here
            double oQuery1 = 0;
            double oQuery2 = 0;
            double oQuery3p1 = 0;
            double oQuery3p2 = 0;
            double oQuery3p3 = 0;
            double oQuery3p4 = 0;
            double oQuery3p5 = 0;
            double oQuery3p6 = 0;
            double oQuery3p7 = 0;
            double oQuery3p8 = 0;
            double oQuery4 = 0;
            double oQuery5p1 = 0;
            double oQuery5p2 = 0;
            double oQuery5p3 = 0;
            double oQuery6p1 = 0;
            double oQuery6p2 = 0;
            double oQuery6p3 = 0;
            double oQuery7p1 = 0;
            double oQuery7p2 = 0;
            double oQuery7p3 = 0;
            
            double query1 = 0;
            double query2 = 0;
            double query3p1 = 0;
            double query3p2 = 0;
            double query3p3 = 0;
            double query3p4 = 0;
            double query3p5 = 0;
            double query3p6 = 0;
            double query3p7 = 0;
            double query3p8 = 0;
            double query4 = 0;
            double query5p1 = 0;
            double query5p2 = 0;
            double query5p3 = 0;
            double query6p1 = 0;
            double query6p2 = 0;
            double query6p3 = 0;
            double query7p1 = 0;
            double query7p2 = 0;
            double query7p3 = 0;
            
            for(int i = 0; i < 9; i++){
                // For query 1
                query1 += hpDAO.getHouseHoldCount().get(0).getTime();
                oQuery1 += hpDAO.optimizedHouseHoldCount().get(0).getTime();
                
                // For query 2
                query2 += hpDAO.getTownCount().get(0).getTime();
                oQuery2 += hpDAO.optimizedTownCount().get(0).getTime();
                
                // For query 3
                query3p1 += Double.parseDouble(ltppDAO.forHogs().get(0));
                oQuery3p1 += Double.parseDouble(ltppDAO.optimizedHogs().get(0));
                query3p2 += Double.parseDouble(ltppDAO.forCarabaos().get(0));
                oQuery3p2 += Double.parseDouble(ltppDAO.forCarabaos().get(0));
                query3p3 += Double.parseDouble(ltppDAO.forChickens().get(0));
                oQuery3p3 += Double.parseDouble(ltppDAO.optimizedChickens().get(0));
                query3p4 += Double.parseDouble(ltppDAO.forCows().get(0));
                oQuery3p4 += Double.parseDouble(ltppDAO.optimizedCows().get(0));
                query3p5 += Double.parseDouble(ltppDAO.forCrops(Crop.SUGARCANE_KEY).get(0));
                oQuery3p5 += Double.parseDouble(ltppDAO.optimizedCrops(Crop.SUGARCANE_KEY).get(0));
                query3p6 += Double.parseDouble(ltppDAO.forDucks().get(0));
                oQuery3p6 += Double.parseDouble(ltppDAO.optimizedDucks().get(0));
                query3p7 += Double.parseDouble(ltppDAO.forFishies(Fish.TILAPIA_KEY).get(0));
                oQuery3p7 += Double.parseDouble(ltppDAO.optimizedFishies(Fish.TILAPIA_KEY).get(0));
                query3p8 += Double.parseDouble(ltppDAO.forGoats().get(0));
                oQuery3p8 += Double.parseDouble(ltppDAO.optimizedGoats().get(0));
                
                // For query 5
                query5p1 += mDAO.produceCrops().get(0).getTime();
                oQuery5p1 += mDAO.optimizedProduceCrops().get(0).getTime();
                query5p2 += mDAO.produceCrops(Crop.SUGARCANE_KEY).get(0).getTime();
                oQuery5p2 += mDAO.optimizedProduceCrops(Crop.SUGARCANE_KEY).get(0).getTime();
                query5p3 += mDAO.produceCrops("cassava").get(0).getTime();
                oQuery5p3 += mDAO.optimizedProduceCrops("cassava").get(0).getTime();
                
                // For query 6
                query6p1 += mDAO.produceFish().get(0).getTime();
                oQuery6p1 += mDAO.optimizedProduceFish().get(0).getTime();
                query6p2 += mDAO.produceFish(Fish.TILAPIA_KEY).get(0).getTime();
                oQuery6p2 += mDAO.optimizedProduceFish(Fish.TILAPIA_KEY).get(0).getTime();
                query6p3 += mDAO.produceFish("bisugo").get(0).getTime();
                oQuery6p3 += mDAO.optimizedProduceFish("bisugo").get(0).getTime();
                
                // For query 7
                query7p1 += mDAO.produceLivestock().get(0).getTime();
                oQuery7p1 += mDAO.optimizedProduceLivestock().get(0).getTime();
                query7p2 += mDAO.produceLivestock(Livestock.HOG_KEY).get(0).getTime();
                oQuery7p2 += mDAO.optimizedProduceLivestock(Livestock.HOG_KEY).get(0).getTime();
                query7p3 += mDAO.produceLivestock("aso").get(0).getTime();
                oQuery7p3 += mDAO.optimizedProduceLivestock("aso").get(0).getTime();
            }
            
            //average here
            oQuery1 /= 10;
            oQuery2 /= 10;
            oQuery3p1 /= 10;
            oQuery3p2 /= 10;
            oQuery3p3 /= 10;
            oQuery3p4 /= 10;
            oQuery3p5 /= 10;
            oQuery3p6 /= 10;
            oQuery3p7 /= 10;
            oQuery3p8 /= 10;
            oQuery4 /= 10;
            oQuery5p1 /= 10;
            oQuery5p2 /= 10;
            oQuery5p3 /= 10;
            oQuery6p1 /= 10;
            oQuery6p2 /= 10;
            oQuery6p3 /= 10;
            oQuery7p1 /= 10;
            oQuery7p2 /= 10;
            oQuery7p3 /= 10;
            
            query1 /= 10;
            query2 /= 10;
            query3p1 /= 10;
            query3p2 /= 10;
            query3p3 /= 10;
            query3p4 /= 10;
            query3p5 /= 10;
            query3p6 /= 10;
            query3p7 /= 10;
            query3p8 /= 10;
            query4 /= 10;
            query5p1 /= 10;
            query5p2 /= 10;
            query5p3 /= 10;
            query6p1 /= 10;
            query6p2 /= 10;
            query6p3 /= 10;
            query7p1 /= 10;
            query7p2 /= 10;
            query7p3 /= 10;
            
            //display average here
            // For query 1
            model.setValueAt(query1+"s", 0, 2);
            model.setValueAt(oQuery1+"s", 0, 3);

            // For query 2
            model.setValueAt(query2+"s", 1, 2);
            model.setValueAt(oQuery2+"s", 1, 3);

            // For query 3
            model.setValueAt(query3p1+"s", 2, 2);
            model.setValueAt(oQuery3p1+"s", 2, 3);
            model.setValueAt(query3p2+"s", 3, 2);
            model.setValueAt(oQuery3p2+"s", 3, 3);
            model.setValueAt(query3p3+"s", 4, 2);
            model.setValueAt(oQuery3p3+"s", 4, 3);
            model.setValueAt(query3p4+"s", 5, 2);
            model.setValueAt(oQuery3p4+"s", 5, 3);
            model.setValueAt(query3p5+"s", 6, 2);
            model.setValueAt(oQuery3p5+"s", 6, 3);
            model.setValueAt(query3p6+"s", 7, 2);
            model.setValueAt(oQuery3p6+"s", 7, 3);
            model.setValueAt(query3p7+"s", 8, 2);
            model.setValueAt(oQuery3p7+"s", 8, 3);
            model.setValueAt(query3p8+"s", 9, 2);
            model.setValueAt(oQuery3p8+"s", 9, 3);

            // For queries 6-8
            model.setValueAt(query5p1+"s", 11, 2);
            model.setValueAt(query5p2+"s", 12, 2);
            model.setValueAt(query5p3+"s", 13, 2);
            model.setValueAt(query6p1+"s", 14, 2);
            model.setValueAt(query6p2+"s", 15, 2);
            model.setValueAt(query6p3+"s", 16, 2);
            model.setValueAt(query7p1+"s", 17, 2);
            model.setValueAt(query7p2+"s", 18, 2);
            model.setValueAt(query7p3+"s", 19, 2);
            
            model.setValueAt(oQuery5p1+"s", 11, 3);
            model.setValueAt(oQuery5p2+"s", 12, 3);
            model.setValueAt(oQuery5p3+"s", 13, 3);
            model.setValueAt(oQuery6p1+"s", 14, 3);
            model.setValueAt(oQuery6p2+"s", 15, 3);
            model.setValueAt(oQuery6p3+"s", 16, 3);
            model.setValueAt(oQuery7p1+"s", 17, 3);
            model.setValueAt(oQuery7p2+"s", 18, 3);
            model.setValueAt(oQuery7p3+"s", 19, 3);
            
	}
}
