package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import db.DBConnector;

public class AgrarianDAO {

	public ArrayList<AgrarianHousehold> get(){
		ArrayList<AgrarianHousehold> housies = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement(
						"select distinct h.id, if(h.live_a_carabao = 1, 1, 0) carabao, if(h.live_a_chicken = 1, 1, 0) chicken, "
						+ "if(h.live_a_cow = 1, 1, 0) cow, if(h.live_a_duck = 1, 1, 0) duck, if(h.live_a_goat = 1, 1, 0) goat, "
						+ "if(h.live_a_hog = 1, 1, 0) pig, if(h.live_a_others = 1, 1, 0) other_livestock, "
						+ "if(a.aquanitype is not null,1,0) fish, if(c.croptype is not null,1,0) crop "
						+ "from hpq_arcdp_mem r, hpq_hh h "
						+ "left join hpq_aquani a "
						+ "on a.hpq_hh_id = h.id "
						+ "left join hpq_crop c "
						+ "on c.hpq_hh_id = h.id "
						+ "where h.id = r.hpq_hh_id");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
//				System.out.println(1.0*(end - start)/1000);
//				System.out.println();
	            housies.add(new AgrarianHousehold(1.0*(end - start)/1000));
				
				while(rs.next()){
					housies.add(new AgrarianHousehold(rs.getString("id"), rs.getInt("carabao"), rs.getInt("chicken"), 
							rs.getInt("cow"), rs.getInt("duck"), rs.getInt("goat"), 
							rs.getInt("pig"), rs.getInt("other_livestock"), rs.getInt("fish"), rs.getInt("crop")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return housies;
	}
	
	public ArrayList<AgrarianHousehold> getOptimized(){
		ArrayList<AgrarianHousehold> housies = new ArrayList<>();
		
		try{
			PreparedStatement pstmt;
			try(Connection conn = DBConnector.getConnection()){
				pstmt = conn.prepareStatement(
						"select distinct h.id, if(h.live_a_carabao = 1, 1, 0) carabao, if(h.live_a_chicken = 1, 1, 0) chicken, if(h.live_a_cow = 1, 1, 0) cow, if(h.live_a_duck = 1, 1, 0) duck, if(h.live_a_goat = 1, 1, 0) goat, if(h.live_a_hog = 1, 1, 0) pig, if(h.live_a_others = 1, 1, 0) other_livestock, if(h.aquanitype is not null,1,0) fish, if(h.croptype is not null,1,0) crop "
						+ "from hpq_arcdp_mem r, combinedtable h "
						+ "where h.id = r.hpq_hh_id	");

				long start = System.currentTimeMillis();
	            ResultSet rs = pstmt.executeQuery();
	            long end = System.currentTimeMillis();
//				System.out.println(1.0*(end - start)/1000);
//				System.out.println();
	            housies.add(new AgrarianHousehold(1.0*(end - start)/1000));
				
				while(rs.next()){
					housies.add(new AgrarianHousehold(rs.getString("id"), rs.getInt("carabao"), rs.getInt("chicken"), 
							rs.getInt("cow"), rs.getInt("duck"), rs.getInt("goat"), 
							rs.getInt("pig"), rs.getInt("other_livestock"), rs.getInt("fish"), rs.getInt("crop")));
				}
			}
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
//		System.out.println(town.size());
		return housies;
	}
	
}
