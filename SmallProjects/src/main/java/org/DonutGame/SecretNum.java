package org.DonutGame;
import java.util.Random;
import java.util.Scanner;
/*This class is obviously more complicated than it needs to be.
* The most obvious change would be for the secret number to be saved as a string
* once the validation process is complete. Another way to generate it would be to
* take an array list and use random positions within that array list and concatenate
* those characters into a string.
* Possible improvements may include:
* 1-an input allowing the player to choose the number of digits
*   -This could be achieved by multiplying the input by 10 for the low end
*       and taking (result *10)-1 for the high end.
* 2- Allowing the player to select how many guesses they get
*   -Make a class variable that holds max guesses and set the loop to
*       terminate when max guesses is reached.
* 3- integrating a GUI for the game its self though this is currently beyond my skill set
* Allowing repeat digits would make the game too difficult and defeat the purpose of
* playing in the first place*/
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
        String strNum= convertStr(num);
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
        int guesses=1;
        int guess;
        boolean winner=false;
        Scanner scnr = new Scanner(System.in);
        while (!winner && guesses<11){
            System.out.print("Enter your guess: ");
            guess = scnr.nextInt();
            System.out.println("guess:" + guesses + "   You guessed: "+guess);
            winner=checkGuess(guess);
            guesses++;
        }
    }
    private String convertStr(int num){
        return Integer.toString(num);
    }
    private boolean checkGuess(int guess) {
        if (guess<100 || guess>999){
            System.out.println("Invalid guess. Remember 3 digits");
        }
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
