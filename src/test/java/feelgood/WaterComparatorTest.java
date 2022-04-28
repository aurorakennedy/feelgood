package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaterComparatorTest {

    WaterComparator waterComparator = new WaterComparator();

    @Test
    public void testConstructor(){
        Day day1 = new Day(3, "søt", 8, "fred", 22, 22);  
        Day day2 = new Day(8, "Morsom", 7, "Eirik", 33, 33);
        Day day3 = new Day(3, "snille", 9, "Mari", 11, 11);


    // Sjekker at day1 er mindre enn day 2 og at det blir returnert -1
        Assertions.assertEquals(-1, waterComparator.compare(day1, day2));
    // Sjekker at day2 er større enn day 1 og blir returnert 1 
        Assertions.assertEquals(1, waterComparator.compare(day2, day1));
    // Sjekker at day 3 og day2 er like og returnerer 0 
        Assertions.assertEquals(0, waterComparator.compare(day1, day3));
 
    }
    
}
