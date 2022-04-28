package feelgood;

import java.util.Comparator;

public class WaterComparator implements Comparator<Day>{
    @Override 
    public int compare(Day day1, Day day2) {
        if (day1.getWater() > day2.getWater()) { //hvordan får jeg dette til å gå for sleep også?
            return 1;
        } else if (day1.getWater() < day2.getWater()) {
            return -1;
        } else {
            return 0;
        }
    }
}
