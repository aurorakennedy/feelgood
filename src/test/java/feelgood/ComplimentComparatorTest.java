package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplimentComparatorTest {
    
    ComplimentComparator complimentComparator = new ComplimentComparator();

    @Test
    public void testConstructor(){
        Day day1 = new Day(3, "søt", 8, "fred", 22, 22);  
        Day day2 = new Day(6, "Morsom", 7, "Eirik", 33, 33);
        Day day3 = new Day(5, "snille", 9, "Mari", 11, 11);


    // Sjekker at day1 er mindre enn day 2 og at det blir returnert -1
        Assertions.assertEquals(-1, complimentComparator.compare(day1, day2));
    // Sjekker at day2 er større enn day 1 og blir returnert 1 
        Assertions.assertEquals(1, complimentComparator.compare(day2, day1));
    // Sjekker at day 3 og day2 er like og returnerer 0 
        Assertions.assertEquals(0, complimentComparator.compare(day2, day3));
 
    }
}
