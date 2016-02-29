package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import db.DBConnector;

public class TownProduceDAO {
	private final String[] basicCrops = {"Sugar Cane", "Palay", "Corn", "Coffee"};
	private final String[] basicFish = {"Tilapia", "Milkfish", "Catfish", "Mudfish", "Carp"};
	 Connection connection;
	 
	public TownProduceDAO(){
		connection = DBConnector.getConnection();
		System.out.println("town  dao initialized.");
	}
	
	public void getLiveStockCount(Livestock liveStock){
		
//		try{
//			String query  = "select COUNT(*) as goats" +
//						     "from (count(nullif(live_a_goat, 2))  as goat," +
//						     "from hpq_hh h " +
//						     "group by mun) a where goat>0";
//			
//		}
//		catch(SQLException sqle){
//			
//		}
		
		
	}
	
	
	
	
}
