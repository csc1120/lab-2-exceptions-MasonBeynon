/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Mason Beynon
 * Last Updated: 9/10/24
 */
package beynonm;

public class Driver {
    /*
    private int[] getInput(){

    }
    private Die[] createDice(int numDice, int numSides){

    }
    private int[] rollDice(Die[] dice, int numSides, int numRolls){

    }
    private int findMax(int[] rolls){

    }
    private void report(int numDice, int[] rolls, int max){

    }
    */

    public static void main(String[] args) {
        final int MIN_DICE = 2;
        final int MAX_DICE = 10;


        Die d6 = new Die(6);

        try {
            System.out.println(d6.getCurrentValue());
        } catch (DieNotRolledException e) {
            System.out.println(e.getMessage());
        }
        d6.roll();
        System.out.println(d6.getCurrentValue());
    }
}