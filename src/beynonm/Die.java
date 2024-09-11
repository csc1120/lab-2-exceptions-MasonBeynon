/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Mason Beynon
 * Last Updated: 9/10/24
 */
package beynonm;

import beynonm.DieNotRolledException;
import java.util.Random;

public class Die {
    public final int MIN_SIDES = 2;
    public final int MAX_SIDES = 100;

    private int currentValue;
    private int numSides;
    private Random random;

    public Die(int numSides){
        this.numSides = numSides;
    }

    public int getCurrentValue(){
        return currentValue;
    }

    public void roll(){

    }
}