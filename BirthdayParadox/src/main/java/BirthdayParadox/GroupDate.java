package BirthdayParadox;

import org.javatuples.Pair;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

/*in this I abandoned the idea of using the Date time functions using the
 * epoch time because it is more beneficial at my current position to learn
 * to use tuples. By using tuples I am effectively teaching myself how to
 * use dependencies in a project. */
public class GroupDate {

    //Dependency for tuple in build.gradle.kts need to figure out how to use.
    Pair<String, Integer> date;
    Pair[] groupDates;
    float avgduplicates;

    public GroupDate(int qty) {
        groupDates = new Pair[qty];
        generateDates();
    }
    public float getProbability(){
        return avgduplicates;
    }

    private Pair<String, Integer> makeDate() {
        Random rand = new Random();
        int month = rand.nextInt(0, 11);
        int day;
        //utilizes the index of the list and fall through switch statements to
        //determine the number of days allowed in the month Feb being the odd ball
        switch (month) {
            //Jan, Mar, May, Jul, Aug, Oct, Dec
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                day = rand.nextInt(1, 31);
                break;
            //Feb
            case 1:
                day = rand.nextInt(1, 27);
                break;
            //anything not a 31 month.
            default:
                day = rand.nextInt(1, 30);
        }
        return new Pair(month, day);
    }
    private void generateDates(){
        for (int i = 0; i < groupDates.length; i++) {
            groupDates[i] = makeDate();
        }
    }

    public void generateProbability(){
        int rounds=100000;
        int duplicates=0;
        Set<Pair> shrink =new TreeSet<>();
        for(int i=0; i<rounds; i++){
            if (i== 10000){
                System.out.println("10,000 rounds calculated\n.........");
            }
            if(i==50000){
                System.out.println("5,000 rounds calculated. Were half way there\n.........");
            }
            if (i==75000){
                System.out.println("Almost!\n..........");
            }
            shrink.addAll(Arrays.asList(groupDates));
            if (shrink.size()!=groupDates.length){
                duplicates++;
            }
            shrink.clear();
            generateDates();
        }
        float rawavg= ((float)duplicates/rounds)*100;
        avgduplicates=Math.round(rawavg);
    }
}
