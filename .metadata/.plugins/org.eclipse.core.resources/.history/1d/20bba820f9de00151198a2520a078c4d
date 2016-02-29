package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import db.DBConnector;

public class Household_ProduceDAO {
	private final String[] basicCrops = {"Sugar Cane", "Palay", "Corn", "Coffee"};
	private final String[] basicFish = {"Tilapia", "Milkfish", "Catfish", "Mudfish", "Carp"};
	 Connection connection;
	 
	public Household_ProduceDAO(){
		connection = DBConnector.getConnection();
		System.out.println("household dao initialized.");
	}
	
	public Iterator getHouseHoldCount(){
		ArrayList<NumberProducer> counts = new ArrayList();
		//System.out.println("household dao initialized.");
		try{
			String query = "select "
					   + "( SELECT COUNT(live_a_hog) AS goat FROM hpq_hh where live_a_hog =1 ) as hog, "
					   + "( SELECT COUNT(live_a_goat) AS goat FROM hpq_hh where live_a_goat =1 ) as goat, "
					   + "( SELECT COUNT(live_a_carabao) AS goat FROM hpq_hh where live_a_carabao =1 ) as carabao, "
					   + "( SELECT COUNT(live_a_cow) AS goat FROM hpq_hh where live_a_cow =1 ) as cow, "
					   + "( SELECT COUNT(live_a_chicken) AS goat FROM hpq_hh where live_a_chicken =1 ) as chicken, "
					   + "( SELECT COUNT(live_a_duck) AS goat FROM hpq_hh where live_a_duck =1 ) as duck, "
					   + "(SELECT COUNT(live_a_duck) AS goat FROM hpq_hh where live_a_others =1 ) as others, "
					   + "(SELECT  COUNT(distinct aquanitype_o)   "
					   + "from hpq_aquani a, hpq_hh h  "
					   + "where a.hpq_hh_id = h.id AND aquanitype=6) as aquani, "
					   + "(SELECT COUNT( croptype) as crops "
					   + "from  hpq_hh h,hpq_crop c where c.hpq_hh_id = h.id) as crops ";
			PreparedStatement preps = connection.prepareStatement(query);
			
			long start = System.currentTimeMillis();
            ResultSet rs = preps.executeQuery();
            long end = System.currentTimeMillis();
            System.out.println("Input: \"Household\"");
			System.out.println(1.0*(end - start)/1000);
			System.out.println();
			
			if(rs.next()){
				counts.add(new NumberProducer("Pig", rs.getLong("hog")));
				counts.add(new NumberProducer("Chicken", rs.getLong("chicken")));
				counts.add(new NumberProducer("Carabao", rs.getLong("carabao")));
				counts.add(new NumberProducer("Cow", rs.getLong("cow")));
				counts.add(new NumberProducer("Goat", rs.getLong("goat")));
				counts.add(new NumberProducer("Duck", rs.getLong("duck")));
				counts.add(new NumberProducer("Other Livestock", rs.getLong("others")));
				counts.add(new NumberProducer("Crops", rs.getLong("crops")));
				counts.add(new NumberProducer("Sea Produce", rs.getLong("aquani")));
				
			}
			}catch(SQLException sqle){
				System.out.println("problem in dao.");
			}
			return counts.iterator();
					
	
		}
	
	public Iterator getTownCount(){
		ArrayList<NumberProducer> counts = new ArrayList();
		try{
			String query = "select (select COUNT(*) as ducks " 
					+ "from (select count(nullif(live_a_duck, 2)) as duck " 
							+ "from hpq_hh h " 
							+ "group by mun) as a " 
							+ " where duck>0) as duck, " 
							+ " (select COUNT(*) as chickens " 
							+ "from (select count(nullif(live_a_chicken, 2)) as chicken " 
							+ "from hpq_hh h " 
							+ "group by mun) a where chicken>0 " 
							+ ") as chicken, " 
							+ "(select COUNT(*) as cows " 
							+ "from (select count(nullif(live_a_cow, 2)) as cow " 
							+ "from hpq_hh h " 
							+ "group by mun) a where cow>0) as cow, " 
							+ "(select COUNT(*) as carabaos " 
							+ "from (select count(nullif(live_a_carabao, 2)) as carabao " 
							+ "from hpq_hh h " 
							+ "group by mun) a where carabao>0) as carabao, " 
							+ "(select COUNT(*) as goats " 
							+ "from (select count(nullif(live_a_goat, 2))  as goat " 
							+ "from hpq_hh h " 
							+ "group by mun) a where goat>0)as goat, " 
							+ "(select COUNT(*) as hogs " 
							+ "from (select count(nullif(live_a_hog, 2)) as hog " 
							+ "from hpq_hh h " 
							+ "group by mun) a where hog>0) AS hog, " 
							+ "(select COUNT(*) as hogs " 
							+ "from (select count(nullif(live_a_others, 2)) as hog " 
							+ "from hpq_hh h " 
							+ "group by mun) a where hog>0) AS others, " 
							+ "(select COUNT(*) as seafood " 
							+ "from (select count(distinct aquanitype_o)as sea_creatures " 
							+ "from hpq_hh h,hpq_aquani a " 
							+ "where a.hpq_hh_id = h.id AND aquanitype=6 " 
							+ "group by mun) a where sea_creatures>0) as seafood, " 
							+ "(select COUNT(*) as crops " 
							+ "from (select count( croptype) as crop " 
							+ "from hpq_hh h,hpq_crop c " 
							+ "where c.hpq_hh_id = h.id " 
							+ "group by mun) a where crop>0) as crops";
			PreparedStatement preps = connection.prepareStatement(query);
			
			long start = System.currentTimeMillis();
            ResultSet rs = preps.executeQuery();
            long end = System.currentTimeMillis();
            System.out.println("Input: \"Town\"");
			System.out.println(1.0*(end - start)/1000);
			System.out.println();
			
			if(rs.next()){
				counts.add(new NumberProducer("Pig", rs.getLong("hog")));
				counts.add(new NumberProducer("Chicken", rs.getLong("chicken")));
				counts.add(new NumberProducer("Carabao", rs.getLong("carabao")));
				counts.add(new NumberProducer("Cow", rs.getLong("cow")));
				counts.add(new NumberProducer("Goat", rs.getLong("goat")));
				counts.add(new NumberProducer("Duck", rs.getLong("duck")));
				counts.add(new NumberProducer("Other Livestock", rs.getLong("others")));
				counts.add(new NumberProducer("Crops", rs.getLong("crops")));
				counts.add(new NumberProducer("Sea Produce", rs.getLong("seafood")));
				
			}
			}catch(SQLException sqle){
				System.out.println("problem in dao.");
			}
			return counts.iterator();
	}
}
	

