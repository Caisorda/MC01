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
public class Livestock extends Produce{
    
    public final static int HOG_KEY = 1;
    public final static int GOAT_KEY = 2;
    public final static int CARABAO_KEY = 3;
    public final static int COW_KEY = 4;
    public final static int CHICKEN_KEY = 5;
    public final static int DUCK_KEY = 6;
    public final static int OTHER_KEY = 7;

    public Livestock() {}

    public Livestock(int line, int type, String oName, int vol) {
        super(line, type, oName, vol);
    }
    
}
