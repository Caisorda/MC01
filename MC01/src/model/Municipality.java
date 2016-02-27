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
    
    public ArrayList<Municipality> produceCrops(){
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
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns;
    }
    
    public ArrayList<Municipality> produceCrops(int cropId){ //using crop id
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
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns;
    }
    
    public ArrayList<Municipality> produceCrops(String cropName){ //using crop name
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
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns;
    }
    
    public ArrayList<Municipality> produceFish(){
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
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns;
    }
    
    public ArrayList<Municipality> produceFish(int fishId){ //using fish id
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
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns;
    }
    
    public ArrayList<Municipality> produceFish(String fishName){ //using fish name
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
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    muns.add(new Municipality(rs.getString("mun")));
                }
            }
            pstmt.close();
        } catch (SQLException e) {
        }
        
        return muns;
    }
    
    
//    public ArrayList<Municipality> produceLivestock(){
//        
//    }
    
}
