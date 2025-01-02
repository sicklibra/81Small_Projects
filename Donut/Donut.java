import java.util.Scanner;

public class Donut{
    public static boolean getRules(){
        System.out.println("This is a guess the number game./n would you like to hear the rules? Y/N");
        Scanner scnr = new Scanner(System.in);
        String rules="Z";
        while (!rules.toUpperCase().equals("Y") || !rules.toUpperCase().equals("N") ) {
            rules= scnr.next();
            rules.toUpperCase();
            System.out.println(rules + "--");
            if(rules.equals("Y")){
                scnr.close();
                return true;
            }            
        }
        scnr.close();
        return false;
    }
    public static void printRules(){
        System.out.println("The computer will pick a random 3 digit number. Your job is to guess" +/n + "that number in 10 guesses or less. When you make a guess you will get feedback on your guess in the following ways:");
        System.out.println("right number wrong place");
        System.out.println("All of your numbers are wrong");
        System.out.println("one of your numbers is right");
        System.out.println("Winner Winner");
    }
    public static void main(String args[]){
        Boolean rules = getRules();
        if (rules == true){
            printRules();
        }
    }
}