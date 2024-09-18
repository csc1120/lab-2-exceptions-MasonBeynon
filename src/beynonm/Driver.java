/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Mason Beynon
 * Last Updated: 9/10/24
 */
package beynonm;
import java.util.Scanner;

public class Driver {

    static final int MIN_DICE = 2;
    static final int MAX_DICE = 10;

    private static int[] getInput(){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        int[] inputs = new int[3];
        while(!quit) {
            System.out.println("Please enter the number of dice to roll, how many sides the dice have,");
            System.out.println("and how many rolls to complete, separating the values by a space.");
            System.out.println("Example: \"2 6 1000\"\n");
            System.out.print("Enter configuration: ");
            String s = sc.nextLine();
            String[] str = s.split(" ");

            //input validation
            if(str.length != 3){
                System.out.println("Invalid input: Expected 3 values but only received " + str.length);
                continue;
            }
            try{
                for(int i=0; i<str.length; i++){
                    inputs[i] = Integer.parseInt(str[i]);
                }
                if((MIN_DICE>inputs[0])||(inputs[0]>MAX_DICE)){
                    System.out.println("Invalid input: Illegal number of dice: " + inputs[0]);
                    continue;
                }
                if((Die.MIN_SIDES>inputs[1])||(Die.MAX_SIDES<inputs[1])){
                    System.out.println("Invalid input: Illegal number of sides: " + inputs[1]);
                    continue;
                }
                quit=true;
            }catch (NumberFormatException e){
                System.out.println("Invalid input: All values must be whole numbers.");
            }

        }
        return inputs;
    }

    private static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for (int i=0; i<numDice; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    private static int[] rollDice(Die[] dice, int numSides, int numRolls) {
        int[] rolls = new int[(dice.length * numSides)-dice.length + 1];
        for (int j=0; j<numRolls; j++){
            int rolled = 0;
            for (Die die : dice) {
                die.roll();
                rolled += die.getCurrentValue();
            }
            rolls[rolled - dice.length]++;
        }
        return rolls;
    }

    private static int findMax(int[] rolls){
        int max = 0;
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        return max;
    }

    private static void report(int numDice, int[] rolls, int max){
        int scale = max /10;
        for(int i=0; i<rolls.length; i++){
            int numStars = rolls[i]/scale;
            System.out.printf("%-2s%-2s%-9s%s", i+numDice, ":", rolls[i], "");
            for(int j=0; j<numStars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] userInputs = getInput();
        Die[] dice = createDice(userInputs[0], userInputs[1]);
        int[] rolls = rollDice(dice, userInputs[1], userInputs[2]);
        int max = findMax(rolls);
        report(dice.length, rolls, max);
    }
}