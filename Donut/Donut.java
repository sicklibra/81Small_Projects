import java.util.Scanner;
import java.util.Random;

public class Donut{
    //declare open var for secret number. 
    public static int secret;

    //This function is the prompt that utilizes a while loop to ensure the correct input for the menu choice.
    public static boolean getRules(){
        System.out.println("This is a guess the number game./n would you like to hear the rules? Y/N");
        Scanner scnr = new Scanner(System.in);
        String rules="Z";//set rules to an arbitrary character to kick off while loop
        while (!rules.toUpperCase().equals("Y") || !rules.toUpperCase().equals("N") ) {
            rules= scnr.next();
            rules= rules.toUpperCase();//equates to ignore case
            if(rules.equals("Y")){
                scnr.close();
                return true;
            }            
        }
        scnr.close();
        return false;
    }
    //self explanitory prints rules
    public static void printRules(){
        System.out.println("The computer will pick a random 3 digit number. Your job is to guess that number in 10 guesses or less.");
        System.out.println( "When you make a guess you will get feedback on your guess in the following ways:");
        System.out.println("right number wrong place");
        System.out.println("All of your numbers are wrong");
        System.out.println("one of your numbers is right");
        System.out.println("Winner Winner");
    }
    public static void generateRando(){
        Random rand = new Random();
        int temp = rand.nextInt(100,999);
        boolean valid = false;
        while (!valid){
            // valid=checknum(temp);
        }
    }
    // public static boolean checknum(int num){
        
    // }
    public static void main(String args[]){
        Boolean rules = getRules();//starts with the menu prompt to see if player wants to see the rules.
        if (rules == true){
            printRules();//if they want them they get them 
        }
        boolean playing = true;//this allows player to play as many times as theyd like.
        while (playing){
            generateRando();
        }


    }
}