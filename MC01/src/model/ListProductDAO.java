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
	
	public ArrayList<String> getBasicCrops(String town){
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

            //gets runtime of query
    		long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));
            
            while (resultSet.next()) {
            	handle = resultSet.getInt(1);
            	if(handle != 0)
            		products.add(basicCrops[handle-1]); 
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> getBasicFish(String town){
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

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));

            while (resultSet.next()) {
            	handle = resultSet.getInt(1);
            	if(handle != 0)
            		products.add(basicFish[handle-1]); 
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> getOtherCrop(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct if(c.croptype=4,c.croptype_o,null) as crop "
            		+ "from hpq_crop c, hpq_hh h "
            		+ "where c.hpq_hh_id = h.id and h.mun = ? "
            		+ "order by crop desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));

            while (resultSet.next()) {
            	products.add(resultSet.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> getOtherFish(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct if(a.aquanitype=6,a.aquanitype_o,null) as fish "
            		+ "from hpq_aquani a, hpq_hh h "
            		+ "where a.hpq_hh_id = h.id and h.mun = ? "
            		+ "order by fish desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));
            
            while (resultSet.next()) {
            	products.add(resultSet.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> getLivestock(String town){
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

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));
            
            
            if (resultSet.next()) {
            	if(resultSet.getInt("pig") == 1)
            		products.add("Pig");
            	if(resultSet.getInt("goat") == 1)
            		products.add("Goat");
            	if(resultSet.getInt("carabao") == 1)
            		products.add("Carabao");
            	if(resultSet.getInt("cow") == 1)
            		products.add("Cow");
            	if(resultSet.getInt("chicken") == 1)
            		products.add("Chicken");
            	if(resultSet.getInt("duck") == 1)
            		products.add("Duck");
            	if(resultSet.getInt("other") == 1)
            		products.add("Other Livestock");
            	
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	
	}
	
	public ArrayList<String> optimizedOtherFish(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct if(aquanitype=6,aquanitype_o,null) Fish "
            		+ "from combinedtable "
            		+ "where mun = ? "
            		+ "order by fish desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));
            
            while (resultSet.next()) {
            	products.add(resultSet.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	public ArrayList<String> optimizedBasicCrops(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct nullif(croptype,4) as crop "
						+  "from combinedtable "
						+  "where mun = ? "
						+  "order by crop desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
    		long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));
            
            while (resultSet.next()) {
            	handle = resultSet.getInt(1);
            	if(handle != 0)
            		products.add(basicCrops[handle-1]); 
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> optimizedBasicFish(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct nullif(aquanitype,6) as fish "
						+  "from combinedtable "
						+  "where mun = ? "
						+  "order by fish";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));

            while (resultSet.next()) {
            	handle = resultSet.getInt(1);
            	if(handle != 0)
            		products.add(basicFish[handle-1]); 
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> optimizedOtherCrop(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select distinct if(croptype=4,null,croptype_o) as crop "
            		+ "from combinedtable "
            		+ "where mun = ? "
            		+ "order by crop desc";
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));

            while (resultSet.next()) {
            	products.add(resultSet.getString(1));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	}
	
	public ArrayList<String> optimizedLivestock(String town){
		ArrayList<String> products= new ArrayList();
		int handle;
        try{
            String query = "select " 
            		+ "nullif(live_a_hog, 2) pig, "
            		+ "nullif(live_a_goat, 2) goat, "
    			    + "nullif(live_a_carabao, 2) carabao, "
    			    + "nullif(live_a_cow, 2) cow, "
    			    + "nullif(live_a_chicken, 2) chicken, "
    			    + "nullif(live_a_duck, 2) duck, "
    			    + "nullif(live_a_others, 2) other "
            		+ "from hpq_hh "
            		+ "where mun = ?";
            
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(town));

            //gets runtime of query
            long start = System.currentTimeMillis();
            ResultSet resultSet = preparedStatement.executeQuery();
            long end = System.currentTimeMillis();
            //brute force-ish approach: add runtime to return iterator
            products.add("" +(1.0*(end - start)/1000));
            
            
            if (resultSet.next()) {
            	if(resultSet.getInt("pig") == 1)
            		products.add("Pig");
            	if(resultSet.getInt("goat") == 1)
            		products.add("Goat");
            	if(resultSet.getInt("carabao") == 1)
            		products.add("Carabao");
            	if(resultSet.getInt("cow") == 1)
            		products.add("Cow");
            	if(resultSet.getInt("chicken") == 1)
            		products.add("Chicken");
            	if(resultSet.getInt("duck") == 1)
            		products.add("Duck");
            	if(resultSet.getInt("other") == 1)
            		products.add("Other Livestock");
            	
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        return products;
	
	}
}
