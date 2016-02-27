/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author user
 */
public class Crop extends Produce{

    public final static int SUGARCANE_KEY = 1;
    public final static int PALAY_KEY = 2;
    public final static int CORN_KEY = 3;
    public final static int COFFEE_KEY = 4;
    public final static int OTHER_KEY = 5;
    
    public Crop(){}
    
    public Crop(int line, int type, String oName, int vol) {
        super(line, type, oName, vol);
    }
    
}
