package BirthdayParadox;

import org.javatuples.Pair;
import java.util.Random;
/*in this I abandoned the idea of using the Date time functions using the
* epoch time because it is more beneficial at my current position to learn
* to use tuples. By using tuples I am effectively teaching myself how to
* use dependencies in a project. */
public class GroupDate {

    //Dependency for tuple in build.gradle.kts need to figure out how to use.
    final String [] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    Pair<String, Integer> date;
    Pair[] groupDates;
    public GroupDate(int qty) {
        date= new Pair<String, Integer>("J",1);
        groupDates= new Pair[qty];
        for (int i = 0; i < qty; i++) {
            date= makeDate();
            groupDates[i]=date;
        }
    }

    private Pair makeDate(){
        Random rand = new Random();
        int month = rand.nextInt(0,11);
        int day;
        //utilizes the index of the list and fall through switch statements to
        //determine the number of days allowed in the month Feb being the odd ball
        switch(month){
            case 0:
            case 2:
            case 4:
                case 6:
            case 7:
            case 9:
                case 11:
                    day = rand.nextInt(1,31);
                    break;
            case 1:
                day = rand.nextInt(1,27);
                break;
            default:
                day = rand.nextInt(1,30);
        }
        return new Pair(month,day);
    }
}
