/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class Municipality {
    
    private String munNum;
    
    public Municipality(){}
    
    public Municipality(String munNum){
        this.munNum = munNum;
    }

    public String getMunNum() {
        return munNum;
    }

    public void setMunNum(String munNum) {
        this.munNum = munNum;
    }
    
    public Iterator optimizedProduceCrops(){
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE crop_line IS NOT NULL\n" +
                                                "GROUP BY combinedtable.mun");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceCrops(): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceCrops(int cropId){ //using crop id
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE combinedtable.croptype = ?\n" +
                                                "GROUP BY combinedtable.mun");
                pstmt.setInt(1, cropId);
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceCrops(int): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceCrops(String cropName){ //using crop name
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE combinedtable.croptype_o LIKE ?\n" +
                                                "GROUP BY combinedtable.mun");
                pstmt.setString(1, "%" + cropName + "%");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceCrops(String): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceFish(){
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE aquani_line IS NOT NULL\n" +
                                                "GROUP BY combinedtable.mun");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceFish(): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceFish(int fishId){ //using fish id
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE combinedtable.aquanitype = ?\n" +
                                                "GROUP BY combinedtable.mun");
                pstmt.setInt(1, fishId);
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceFish(int): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceFish(String fishName){ //using fish name
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE combinedtable.aquanitype_o LIKE ?\n" +
                                                "GROUP BY combinedtable.mun");
                pstmt.setString(1, "%" + fishName + "%");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceFish(String): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceLivestock(){
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE (live_a_hog = 1 AND live_a_hog_vol > 0)\n" +
                                                "OR (live_a_goat = 1 AND live_a_goat_vol > 0)\n" +
                                                "OR (live_a_carabao = 1 AND live_a_carabao_vol > 0)\n" +
                                                "OR (live_a_cow = 1 AND live_a_cow_vol > 0)\n" +
                                                "OR (live_a_chicken = 1 AND live_a_chicken_vol > 0)\n" +
                                                "OR (live_a_others = 1 AND live_a_others_vol > 0)\n" +
                                                "GROUP BY combinedtable.mun");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceLivestock(): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceLivestock(int livestockId){ //using livestock id
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                String livestockType = "";
                
                switch(livestockId){
                    case Livestock.CARABAO_KEY: livestockType = "(live_a_carabao = 1 AND live_a_carabao_vol > 0)";
                                                break;
                    case Livestock.CHICKEN_KEY: livestockType = "(live_a_chicken = 1 AND live_a_chicken_vol > 0)";
                                                break;
                    case Livestock.COW_KEY: livestockType = "(live_a_cow = 1 AND live_a_cow_vol > 0)";
                                            break;
                    case Livestock.DUCK_KEY: livestockType = "(live_a_duck = 1 AND live_a_duck_vol > 0)";
                                             break;
                    case Livestock.HOG_KEY: livestockType = "(live_a_hog = 1 AND live_a_hog_vol > 0)";
                                            break;
                    case Livestock.GOAT_KEY: livestockType = "(live_a_goat = 1 AND live_a_goat_vol > 0)";
                                             break;
                }
                
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE " + livestockType + 
                                                "\nGROUP BY combinedtable.mun");
                
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceLivestock(int): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator optimizedProduceLivestock(String livestockName){ //using livestock name
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT combinedtable.mun\n" +
                                                "FROM combinedtable\n" +
                                                "WHERE live_a_others_o LIKE ?" +
                                                "GROUP BY combinedtable.mun");
                pstmt.setString(1, "%" + livestockName + "%");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for optimizedProduceLivestock(String): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceCrops(){
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "RIGHT JOIN hpq_crop\n" +
                                                "ON hpq_hh.id = hpq_crop.hpq_hh_id\n" +
                                                "WHERE hpq_hh.id IS NOT NULL\n" +
                                                "GROUP BY hpq_hh.mun");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceCrops(): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceCrops(int cropId){ //using crop id
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "RIGHT JOIN hpq_crop\n" +
                                                "ON hpq_hh.id = hpq_crop.hpq_hh_id\n" +
                                                "WHERE hpq_hh.id IS NOT NULL\n" +
                                                "	AND hpq_crop.croptype = ?\n" +
                                                "GROUP BY hpq_hh.mun");
                pstmt.setInt(1, cropId);
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceCrops(int): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceCrops(String cropName){ //using crop name
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "RIGHT JOIN hpq_crop\n" +
                                                "ON hpq_hh.id = hpq_crop.hpq_hh_id\n" +
                                                "WHERE hpq_hh.id IS NOT NULL\n" +
                                                "	AND hpq_crop.croptype_o LIKE ?\n" +
                                                "GROUP BY hpq_hh.mun");
                pstmt.setString(1, "%" + cropName + "%");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceCrops(String): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceFish(){
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "RIGHT JOIN hpq_aquani\n" +
                                                "ON hpq_hh.id = hpq_aquani.hpq_hh_id\n" +
                                                "WHERE hpq_hh.id IS NOT NULL\n" +
                                                "GROUP BY hpq_hh.mun");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceFish(): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceFish(int fishId){ //using fish id
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "RIGHT JOIN hpq_aquani\n" +
                                                "ON hpq_hh.id = hpq_aquani.hpq_hh_id\n" +
                                                "WHERE hpq_hh.id IS NOT NULL\n" +
                                                "	AND hpq_aquani.aquanitype = ?\n" +
                                                "GROUP BY hpq_hh.mun");
                pstmt.setInt(1, fishId);
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceFish(int): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceFish(String fishName){ //using fish name
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "RIGHT JOIN hpq_aquani\n" +
                                                "ON hpq_hh.id = hpq_aquani.hpq_hh_id\n" +
                                                "WHERE hpq_hh.id IS NOT NULL\n" +
                                                "	AND hpq_aquani.aquanitype_o LIKE ?\n" +
                                                "GROUP BY hpq_hh.mun");
                pstmt.setString(1, "%" + fishName + "%");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceFish(String): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceLivestock(){
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "WHERE (live_a_hog = 1 AND live_a_hog_vol > 0)\n" +
                                                "OR (live_a_goat = 1 AND live_a_goat_vol > 0)\n" +
                                                "OR (live_a_carabao = 1 AND live_a_carabao_vol > 0)\n" +
                                                "OR (live_a_cow = 1 AND live_a_cow_vol > 0)\n" +
                                                "OR (live_a_chicken = 1 AND live_a_chicken_vol > 0)\n" +
                                                "OR (live_a_others = 1 AND live_a_others_vol > 0)\n" +
                                                "GROUP BY mun");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceLivestock(): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceLivestock(int livestockId){ //using livestock id
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                String livestockType = "";
                
                switch(livestockId){
                    case Livestock.CARABAO_KEY: livestockType = "(live_a_carabao = 1 AND live_a_carabao_vol > 0)";
                                                break;
                    case Livestock.CHICKEN_KEY: livestockType = "(live_a_chicken = 1 AND live_a_chicken_vol > 0)";
                                                break;
                    case Livestock.COW_KEY: livestockType = "(live_a_cow = 1 AND live_a_cow_vol > 0)";
                                            break;
                    case Livestock.DUCK_KEY: livestockType = "(live_a_duck = 1 AND live_a_duck_vol > 0)";
                                             break;
                    case Livestock.HOG_KEY: livestockType = "(live_a_hog = 1 AND live_a_hog_vol > 0)";
                                            break;
                    case Livestock.GOAT_KEY: livestockType = "(live_a_goat = 1 AND live_a_goat_vol > 0)";
                                             break;
                }
                
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "WHERE " + livestockType + 
                                                "\nGROUP BY hpq_hh.mun");
                
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceLivestock(int): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
    public Iterator produceLivestock(String livestockName){ //using livestock name
        ArrayList<Municipality> muns = new ArrayList<>();
        
        try{
            PreparedStatement pstmt;
            try (Connection conn = DBConnector.getConnection()) {
                pstmt = conn.prepareStatement("SELECT hpq_hh.mun\n" +
                                                "FROM hpq_hh\n" +
                                                "WHERE live_a_others_o LIKE ?" +
                                                "GROUP BY hpq_hh.mun");
                pstmt.setString(1, "%" + livestockName + "%");
                long start = System.currentTimeMillis();
                ResultSet rs = pstmt.executeQuery();
                long end = System.currentTimeMillis();
                System.out.println("Runtime for produceLivestock(String): " + ((end-start)/1000.0));
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns.iterator();
    }
    
}
