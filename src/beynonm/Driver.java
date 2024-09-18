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

    private static int[] getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of dice to roll, how many sides the dice have,");
        System.out.println("and how many rolls to complete, separating the values by a space.");
        System.out.println("Example: \"2 6 1000\"\n");
        System.out.print("Enter configuration: ");
        String Sinput = sc.nextLine();
        Sinput = Sinput.trim();
        try{
            int numDice = Integer.parseInt(Sinput.substring(0,Sinput.indexOf(" ")));
            Sinput = Sinput.substring(Sinput.indexOf(" ")+1);
            int numSides = Integer.parseInt(Sinput.substring(0,Sinput.indexOf(" ")));
            Sinput = Sinput.substring(Sinput.indexOf(" ")+1);
            int numRolls = Integer.parseInt(Sinput);
            return new int[]{numDice, numSides, numRolls};
        } catch (Exception e) {
            throw new RuntimeException();
        }
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
        final int MIN_DICE = 2;
        final int MAX_DICE = 10;

        int[] userInputs = new int[3];

        boolean quit = false;
        while(!quit) {
            try {
                userInputs = getInput();
                quit = true;
            } catch (Exception e) {
                System.out.println("Invalid user input. Please try again.");
            }
        }

        Die[] dice = createDice(userInputs[0], userInputs[1]);
        int[] rolls = rollDice(dice, userInputs[1], userInputs[2]);
        int max = findMax(rolls);
        report(dice.length, rolls, max);
    }
}