package DonutGame;

import java.util.Scanner;

import static DonutGame.SecretNum.*;


public class Donut{
    //declare open var for secret number. 
    public static SecretNum secret;

    //This function is the prompt that utilizes a while loop to ensure the correct input for the menu choice.
    public static boolean getRules(){
        System.out.println("This is a guess the number game./n would you like to hear the rules? (Y/N)");
        Scanner scnr = new Scanner(System.in);
        String rules="z";//set rules to an arbitrary character to kick off while loop
        while (!rules.equalsIgnoreCase("Y") || !rules.equalsIgnoreCase("N") ) {
            rules= scnr.next();
            if(rules.equalsIgnoreCase("Y")){
                scnr.close();
                return true;
            }
            else if (rules.equalsIgnoreCase("N")){
                break;
            }
        }
        scnr.close();
        return false;
    }
    //self explanitory prints rules
    public static void printRules(){
        System.out.println("The computer will pick a random 3 digit number with no repeating digits.");
        System.out.println( "Your job is to guess that number in 10 guesses or less.");
        System.out.println( "When you make a guess you will get feedback on your guess in the following ways:");
        System.out.println("Right number wrong place");
        System.out.println("All of your numbers are wrong");
        System.out.println("one of your numbers is right");
        System.out.println("Winner Winner");
    }
    public static boolean keepPlaying(){
        Scanner scnr = new Scanner(System.in);
        String playing = "z";
        System.out.println("Would you like to play again? (Y/N)");
        while (!playing.equalsIgnoreCase("Y") || !playing.equalsIgnoreCase("N") ) {
            playing = scnr.next();
            if (playing.equalsIgnoreCase("Y")) {
                scnr.close();
                return true;
            }
            else if (playing.equalsIgnoreCase("N")) {
                break;
            }
        }
        scnr.close();
        return false;
    }

    public static void main(String[] args){

        boolean rules = getRules();//starts with the menu prompt to see if player wants to see the rules.
        if (rules){
            printRules();//if they want them they get them 
        }
        boolean playing = true;//this allows player to play as many times as they'd like.
        while (playing){
            secret= new SecretNum();
            secret.play();
            playing=keepPlaying();
        }
    }
}