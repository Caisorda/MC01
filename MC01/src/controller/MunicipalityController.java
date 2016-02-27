/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import model.Municipality;

/**
 *
 * @author user
 */
public class MunicipalityController {
    
    public MunicipalityController(){}
    
    public ArrayList<Municipality> produceCrops(){
        return new Municipality().produceCrops();
    }
    
    public ArrayList<Municipality> produceCrops(int cropId){
        return new Municipality().produceCrops(cropId);
    }
    
    public ArrayList<Municipality> produceCrops(String cropName){
        return new Municipality().produceCrops(cropName);
    }
    
    public ArrayList<Municipality> produceFish(){
        return new Municipality().produceFish();
    }
    
    public ArrayList<Municipality> produceFish(int fishId){
        return new Municipality().produceFish(fishId);
    }
    
    public ArrayList<Municipality> produceFish(String fishName){
        return new Municipality().produceFish(fishName);
    }
    
}
