/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Mason Beynon
 * Last Updated: 9/10/2024
 */
package beynonm;

public class DieNotRolledException  extends RuntimeException{
    public DieNotRolledException(){};

    public String getMessage(){
        return "Die not Rolled";
    }
}
