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
				
				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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

				town.add(""+(1.0*(end - start)/1000));
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
	
	public ArrayList<String> optimizedHogs(){//for le hogs
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(mun) as 'Towns that produce Hogs' "
						+ "from combinedtable "
						+ "where live_a_hog = 2 "
						+ "order by mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Pig\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce Hogs")));
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
	
	public ArrayList<String> optimizedGoats(){//for le goats
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(mun) as 'Towns that produce Goats' "
						+ "from combinedtable "
						+ "where live_a_goat = 2 "
						+ "order by mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Goat\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce Goats")));
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
	
	public ArrayList<String> optimizedCarabaos(){//for le carabaos
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(mun) as 'Towns that produce Carabaos' "
						+ "from combinedtable "
						+ "where live_a_carabao = 2 "
						+ "order by mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Carabao\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce Carabaos")));
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
	
	public ArrayList<String> optimizedCows(){//for le cows
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(mun) as 'Towns that produce Cows' "
						+ "from combinedtable "
						+ "where live_a_cow = 2 "
						+ "order by mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Cow\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce Cows")));
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
	
	public ArrayList<String> optimizedChickens(){//for le chickens
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(mun) as 'Towns that produce Chickens' "
						+ "from combinedtable "
						+ "where live_a_chicken = 2 "
						+ "order by mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Chicken\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce Chickens")));
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
	
	public ArrayList<String> optimizedDucks(){//for le ducks
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(mun) as 'Towns that produce Ducks' "
						+ "from combinedtable "
						+ "where live_a_duck = 2 "
						+ "order by mun;");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Duck\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce Ducks")));
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
	public ArrayList<String> optimizedFishies(int fishID){//for le fishies
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(h.mun) as 'Towns that produce fish' "
						+ "from combinedtable h "
						+ "where h.aquanitype = ? "
						+ "order by h.mun;");
				pstmt.setInt(1, fishID);

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Fish" +" " + fishID +"\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce fish")));
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
	public ArrayList<String> optimizedCrops(int cropID){//for le cropz
		ArrayList<String> town = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement("select distinct(h.mun) as 'Towns that produce crops' "
						+ "from combinedtable h "
						+ "where h.croptype= ? "
						+ "order by h.mun;");
				pstmt.setInt(1, cropID);

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
	            System.out.println("Input: \"Crop" +" " + cropID +"\"");
				System.out.println(1.0*(end - start)/1000);
				System.out.println();

				town.add(""+(1.0*(end - start)/1000));
				while(rs.next()){
					town.add(new String(rs.getString("Towns that produce crops")));
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
