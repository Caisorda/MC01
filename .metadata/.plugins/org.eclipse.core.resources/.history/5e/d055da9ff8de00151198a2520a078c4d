package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class ListTownPerProduceDAO {
	
//	private String townID;

	public ListTownPerProduceDAO(){}
//	
//	public ListTownPerProduceDAO(String townID){
//		this.townID = townID;
//	}
//	
//	public String getTown(){
//		return townID;
//	}
//	
//	public void setTowN(String townID){
//		this.townID = townID;
//	}
	
	
	//LIVESTOCK*************************************************
	public ArrayList<String> forHogs(){//for le hogs
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh "
												+ "WHERE live_a_hog = 1 "
												+ "ORDER BY mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Pig\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	public ArrayList<String> forGoats(){//for le goats
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh "
												+ "WHERE live_a_goat = 1 "
												+ "ORDER BY mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Goat\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	public ArrayList<String> forCarabaos(){//for le carabaos
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh "
												+ "WHERE live_a_carabao = 1 "
												+ "ORDER BY mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Carabao\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	public ArrayList<String> forCows(){//for le cows
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh "
												+ "WHERE live_a_cow = 1 "
												+ "ORDER BY mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Cow\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	public ArrayList<String> forChickens(){//for le chickens
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh "
												+ "WHERE live_a_chicken = 1 "
												+ "ORDER BY mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Chicken\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	public ArrayList<String> forDucks(){//for le ducks
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh "
												+ "WHERE live_a_duck = 1 "
												+ "ORDER BY mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Duck\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	//FISHIES************************************************
	public ArrayList<String> forFishies(int fishID){//for le fishies
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh h, hpq_aquani a "
												+ "WHERE a.aquanitype = ? "
												+ "AND a.hpq_hh_id = h.id "
												+ "ORDER BY h.mun;");
				pstmt.setInt(1, fishID);

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Fish" +" " + fishID +"\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}

	//CROPZ***************************************************
	public ArrayList<String> forCrops(int cropID){//for le cropz
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("SELECT distinct(mun) "
												+ "FROM hpq_hh h, hpq_crop c "
												+ "WHERE c.croptype = ? "
												+ "AND c.hpq_hh_id = h.id "
												+ "ORDER BY h.mun;");
				pstmt.setInt(1, cropID);

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Crop" +" " + cropID +"\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();
				
				while(rs.next()){
					town.add(new String(rs.getString("mun")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return town;
	}
	
	
}
