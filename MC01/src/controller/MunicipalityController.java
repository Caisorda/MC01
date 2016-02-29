/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.Iterator;
import model.Municipality;

/**
 *
 * @author user
 */
public class MunicipalityController {
    
    public MunicipalityController(){}
    
    public ArrayList<Municipality> produceCrops(){
        Iterator iterator = new Municipality().produceCrops();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceCrops(int cropId){
        Iterator iterator =  new Municipality().produceCrops(cropId);
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceCrops(String cropName){
        Iterator iterator =  new Municipality().produceCrops(cropName);
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceFish(){
        Iterator iterator =  new Municipality().produceFish();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceFish(int fishId){
        Iterator iterator =  new Municipality().produceFish(fishId);
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceFish(String fishName){
        Iterator iterator =  new Municipality().produceFish(fishName);
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceLivestock(){
        Iterator iterator =  new Municipality().produceLivestock();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceLivestock(int livestockId){
        Iterator iterator =  new Municipality().produceLivestock(livestockId);
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceLivestock(String livestockName){
        Iterator iterator =  new Municipality().produceLivestock(livestockName);
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
}
