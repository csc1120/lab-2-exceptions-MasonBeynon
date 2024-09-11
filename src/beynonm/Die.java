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
    private final int numSides;
    private final Random random = new Random();

    public Die(int numSides)throws IllegalArgumentException{
        if(MIN_SIDES<=numSides && numSides<=MAX_SIDES){
            this.numSides = numSides;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public int getCurrentValue() throws DieNotRolledException{
        if (currentValue>=1 && currentValue<=numSides){
            int temp = currentValue;
            currentValue = 0;
            return temp;
        }else{
            throw new DieNotRolledException();
        }
    }

    public void roll(){
        currentValue = random.nextInt(numSides) + 1;
    }
}