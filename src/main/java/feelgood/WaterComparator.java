package feelgood;

import java.util.Comparator;

public class WaterComparator implements Comparator<Day>{
    @Override 
    public int compare(Day day1, Day day2) {
        if (day1.getWater() > day2.getWater()) { // sjekker om day1 er større enn day 2
            return 1;
        } else if (day1.getWater() < day2.getWater()) { // sjekker om day 1 er mindre enn day 2
            return -1;
        } else { // de er like store 
            return 0;
        }
    }
}
