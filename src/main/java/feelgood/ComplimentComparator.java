package feelgood;

import java.util.Comparator;

public class ComplimentComparator implements Comparator<Day> {
    @Override 
    public int compare(Day day1, Day day2) {
        if (day1.getCompliments().length() > day2.getCompliments().length()) {
            return 1; //dag1 er lengre enn dag 2
        } else if (day1.getCompliments().length() < day2.getCompliments().length()) {
            return -1; //dag1 er kortere enn dag2
        } else {
            return 0; //dag1 er lik dag2
        }
    }
}
