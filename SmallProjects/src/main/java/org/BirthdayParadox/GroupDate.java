package org.BirthdayParadox;

import org.javatuples.Pair;
/*in this I abandoned the idea of using the Date time functions using the
* epoch time because it is more beneficial at my current position to learn
* to use tuples. By using tuples I am effectively teaching myself how to
* use dependencies in a project. */
public class GroupDate {

    //Dependency for tuple in build.gradle.kts need to figure out how to use.
    final String [] months = {}
    Pair<String, Integer> date;
    Pair[] groupDates;
    public GroupDate(int qty) {
        for (int i = 0; i < qty; i++) {}
    }
}
