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
        Iterator iterator = new Municipality().produceCrops().iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceCrops(int cropId){
        Iterator iterator =  new Municipality().produceCrops(cropId).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceCrops(String cropName){
        Iterator iterator =  new Municipality().produceCrops(cropName).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceFish(){
        Iterator iterator =  new Municipality().produceFish().iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceFish(int fishId){
        Iterator iterator =  new Municipality().produceFish(fishId).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceFish(String fishName){
        Iterator iterator =  new Municipality().produceFish(fishName).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceLivestock(){
        Iterator iterator =  new Municipality().produceLivestock().iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceLivestock(int livestockId){
        Iterator iterator =  new Municipality().produceLivestock(livestockId).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> produceLivestock(String livestockName){
        Iterator iterator =  new Municipality().produceLivestock(livestockName).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceCrops(){
        Iterator iterator = new Municipality().optimizedProduceCrops().iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceCrops(int cropId){
        Iterator iterator =  new Municipality().optimizedProduceCrops(cropId).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceCrops(String cropName){
        Iterator iterator =  new Municipality().optimizedProduceCrops(cropName).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceFish(){
        Iterator iterator =  new Municipality().optimizedProduceFish().iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceFish(int fishId){
        Iterator iterator =  new Municipality().optimizedProduceFish(fishId).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceFish(String fishName){
        Iterator iterator =  new Municipality().optimizedProduceFish(fishName).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceLivestock(){
        Iterator iterator =  new Municipality().optimizedProduceLivestock().iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceLivestock(int livestockId){
        Iterator iterator =  new Municipality().optimizedProduceLivestock(livestockId).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
    public ArrayList<Municipality> optimizedProduceLivestock(String livestockName){
        Iterator iterator =  new Municipality().optimizedProduceLivestock(livestockName).iterator();
        ArrayList<Municipality> results = new ArrayList<>();
        
        for(Iterator i = iterator; i.hasNext();)
                results.add((Municipality)i.next());
        
        return results;
    }
    
}
