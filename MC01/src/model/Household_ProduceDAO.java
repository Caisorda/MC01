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
	
	public Iterator getCount(){
		ArrayList<Long> counts = new ArrayList();
		//System.out.println("household dao initialized.");
		try{
			String query = "select count(nullif(live_a_hog, 2)) as hog, " +
							   " count( croptype) as crops, " +
							   " count(distinct aquanitype_o)as sea_creatures, " +
 							   " count(nullif(live_a_goat, 2))  as goat," +
							   " count(nullif(live_a_carabao, 2)) as carabao, " +
							   " count(nullif(live_a_cow, 2)) as cow," +
							   " count(nullif(live_a_chicken, 2)) as chicken," +
							   " count(nullif(live_a_duck, 2)) as duck " +
							   " from hpq_hh h,hpq_crop c,hpq_aquani a " +
							   " where c.hpq_hh_id = h.id and a.hpq_hh_id = h.id AND aquanitype=6";
			PreparedStatement preps = connection.prepareStatement(query);
			ResultSet rs  = preps.executeQuery();
			System.out.println("query executed");
			while(rs.next()){
				for(int i = 1;i<9;i++){
				long temp = rs.getLong(i);
				counts.add(temp);
			//	System.out.println("temp got: " + temp);
				}
			}}catch(SQLException sqle){
				System.out.println("problem in dao.");
			}
			return counts.iterator();
					
	
		}
	}
	

