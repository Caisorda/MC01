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
public class Fish extends Produce{
    
    public final static int TILAPIA_KEY = 1;
    public final static int MILKFISH_KEY = 2;
    public final static int CATFISH_KEY = 3;
    public final static int MUDFISH_KEY = 4;
    public final static int CARP_KEY = 5;
    public final static int OTHER_KEY = 6;

    public Fish(int line, int type, String oName, int vol) {
        super(line, type, oName, vol);
    }
    
    
    
}
