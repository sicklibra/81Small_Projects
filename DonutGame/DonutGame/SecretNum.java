package DonutGame;
import java.util.Random;
import java.util.Scanner;

public class SecretNum {
    int secret;
    public SecretNum() {
        secret = generateRando();
    }

    int generateRando(){
        Random rand = new Random();
        int temp = rand.nextInt(102,987);
        boolean valid = checkNum(temp);
        //instead of using an array or shuffled stack to get numbers for comparison,
        //This is practice manipulating numbers and strings for comparison
        while (!valid){//this keeps regenerating random 3-digit numbers until there
            //are no repeated digits.
            temp = rand.nextInt(102,987);
            valid=checkNum(temp);
        }
        return temp;
    }

    private boolean checkNum(int num){
        String strNum=Integer.toString(num);
        //determine if each digit is unique.
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                // if a number is repeated.
                if(strNum.charAt(i) == strNum.charAt(j) && i!=j){
                    return false;
                }
            }
        }
        return true;
    }
    public void play(){
        int guesses=0;
        Boolean winner=false;
        Scanner scnr = new Scanner(System.in);
        while (winner==false && guesses<10){
            System.out.print("Enter your guess: ");
            int guess = scnr.nextInt();
            System.out.println("You guessed: "+guess);
            winner=checkGuess(guess);
        }
    }
    private String convertStr(int num){
        String strNum=Integer.toString(num);
        return strNum;
    }
    private boolean checkGuess(int guess) {
        if (guess == secret) {
            System.out.println("Winner Winner!");
            return true;
        }
        else if (!checkNum(guess)) {
            System.out.println("None of the digits repeat!");
            return false;
        }
        int[] Rplace = getRightPlace(guess);
        int[] RnumWplace = rightNumWrongPlace(guess);
        for (int i=0; i<Rplace.length; i++) {
            if (Rplace[i]==1){
                System.out.println("Right number Right place!");
            }
            else if (RnumWplace[i]==1){
                System.out.println("Right number Wrong place!");
            }
            else {
                System.out.println("-");
            }
        }
        return false;
    }
    private int[] getRightPlace(int guess) {
        int[] rightPlacePos = new int[3];
        String guessStr = convertStr(guess);
        String secStr = convertStr(secret);
        for (int i = 0; i < 3; i++) {
            if (secStr.charAt(i) == guessStr.charAt(i)) {
                rightPlacePos[i] = 1;
            } else {
                rightPlacePos[i] = 0;
            }
        }
        return rightPlacePos;
    }
    private int[] rightNumWrongPlace(int guess) {
        int[] wrongPlacePos = new int[3];
        String guessStr = convertStr(guess);
        String secStr = convertStr(secret);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (guessStr.charAt(i) == secStr.charAt(j) && j != i) {
                    wrongPlacePos[i] = 1;
                }
            }
        }
        return wrongPlacePos;
    }

}
