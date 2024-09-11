/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Mason Beynon
 * Last Updated: 9/10/24
 */
package beynonm;

import java.util.Random;

public class Die {
    public final int MIN_SIDES = 2;
    public final int MAX_SIDES = 100;

    private int currentValue = 0;
    private int numSides;
    private final Random random = new Random();

    public Die(int numSides){
        if(MIN_SIDES<=numSides && numSides<=MAX_SIDES){
            this.numSides = numSides;
        }else{
            System.out.println("Number of Sides Invalid");
        }
    }

    public int getCurrentValue() throws DieNotRolledException{
        if(currentValue == 0){
            throw new DieNotRolledException();
        }else{
            return currentValue;
        }
    }

    public void roll(){
        currentValue = random.nextInt(numSides) + 1;
    }
}