/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.MunicipalityController;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Testing {
    
    public static void main(String args[]){ // class for testing models
        Crop c = new Crop();
        Fish f = new Fish();
        MunicipalityController m = new MunicipalityController();
        
        ArrayList<Municipality> muns;
        
        muns = m.produceCrops();
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        muns = m.produceFish();
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        muns = m.produceLivestock();
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        
        
        System.out.println("Sugarcane");
        muns = m.produceCrops(Crop.SUGARCANE_KEY);
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        System.out.println("Carp");
        muns = m.produceFish(Fish.CARP_KEY);
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        System.out.println("Duck");
        muns = m.produceLivestock(Livestock.DUCK_KEY);
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        
        
        System.out.println("Cassava");
        muns = m.produceCrops("Cassava");
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        System.out.println("Bisugo");
        muns = m.produceFish("bisugo");
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
        System.out.println("Pabo");
        muns = m.produceLivestock("pabo");
        for(int i = 0; i < muns.size(); i++){
            System.out.println(muns.get(i).getMunNum());
        }
    }
    
}
