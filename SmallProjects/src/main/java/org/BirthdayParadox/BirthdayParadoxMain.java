package org.BirthdayParadox;

import java.time.temporal.JulianFields;
import java.util.Scanner;

/*In this program, I will be identifying the probability of two people having the same
* birthday given a collection of a number of people.
* I will do this through a date object that will create a tuple (0-11) correlating the
* month. then using the month, the odd months will have 31 days available and the
* even months will have 30 days available with the exception of Feb (1) which will have
* its own comparison that will give it a 1 in 7 chance of equaling 29
* those dates will be input into an array within it's own class
*  containing the number of birthdays specified by the user.
* It will output the array, and compare any duplicates to inform the user if
* there are any two people with the same birthday. it will then run repeatedly
* 100,000 times and average the number of trials with duplicate birthdays. */

public class BirthdayParadoxMain {
    //Prompt user for number of "people"
    public static int getNumPeople(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people in the group: ");
        try {
            int numPeople = sc.nextInt();
            return numPeople;
        }
        catch (Exception e) {
            System.out.println("Please enter a positive integer: ");
            return -1;
        }

    }
    public static void main(String[] args){
        System.out.println("Here, we can calculate the likelihood of you sharing a Birthday");
        System.out.println("with someone given a particular group size");
        int group=-1;
        while(group<=0) {
            group = getNumPeople();
            if (group <= 0) {
                System.out.println("Please enter a positive integer: ");
            }
        }

    }
}
