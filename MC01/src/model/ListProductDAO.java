package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


import db.DBConnector;

public class ListProductDAO {
	private final String[] basicCrops = {"Sugar Cane", "Palay", "Corn", "Coffee"};
	private final String[] basicFish = {"Tilapia", "Milkfish", "Catfish", "Mudfish", "Carp"};
	
	public Iterator getBasicCrops(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct nullif(c.croptype,4) as crop "
						+  "from hpq_crop c, hpq_hh h "
						+  "where c.hpq_hh_id = h.id and h.mun = ? "
						+  "order by crop desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	handle = resultSet.getInt(1);
            	if(handle != 0)
            		products.add(basicCrops[handle-1]); 
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products.iterator();
	}
	
	public Iterator getBasicFish(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct nullif(a.aquanitype,6) as fish "
						+  "from hpq_aquani a, hpq_hh h "
						+  "where a.hpq_hh_id = h.id and h.mun = ? "
						+  "order by fish";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	handle = resultSet.getInt(1);
            	if(handle != 0)
            		products.add(basicFish[handle-1]); 
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products.iterator();
	}
	
	public Iterator getOtherCrop(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct if(c.croptype=4,null,c.croptype_o) as crop "
            		+ "from hpq_crop c, hpq_hh h "
            		+ "where c.hpq_hh_id = h.id and h.mun = ? "
            		+ "order by crop desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	products.add(resultSet.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products.iterator();
	}
	
	public Iterator getOtherFish(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct if(a.aquanitype=6,null,a.aquanitype_o) as fish "
            		+ "from hpq_aquani a, hpq_hh h "
            		+ "where a.hpq_hh_id = h.id and h.mun = ? "
            		+ "order by fish desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	products.add(resultSet.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products.iterator();
	}
	
	public Iterator getLivestock(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select " 
            		+ "count(distinct nullif(live_a_hog, 2)) as pig,"
            		+ "count(distinct nullif(live_a_goat, 2)) as goat,"
            		+ "count(distinct nullif(live_a_carabao, 2)) as carabao,"
            		+ "count(distinct nullif(live_a_cow, 2)) as cow,"
            		+ "count(distinct nullif(live_a_chicken, 2)) as chicken,"
            		+ "count(distinct nullif(live_a_duck, 2)) as duck,"
            		+ "count(distinct nullif(live_a_others, 2)) as other "
            		+ "from hpq_hh "
            		+ "where mun = ?";
            
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	if(resultSet.getInt("pig") == 1)
            		products.add("pig");
            	if(resultSet.getInt("goat") == 1)
            		products.add("goat");
            	if(resultSet.getInt("carabao") == 1)
            		products.add("carabao");
            	if(resultSet.getInt("cow") == 1)
            		products.add("cow");
            	if(resultSet.getInt("chicken") == 1)
            		products.add("chicken");
            	if(resultSet.getInt("duck") == 1)
            		products.add("duck");
            	if(resultSet.getInt("other") == 1)
            		products.add("other");
            	
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products.iterator();
	
	}
}
