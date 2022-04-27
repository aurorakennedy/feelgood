package feelgood;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SummaryTest {

    //Summary summary;
    Summary summary = new Summary();

    @BeforeEach
    void creatSummary(){
        Day day1 = new Day(5, "søt", 8, "Klara", 10, 10);
        Day day2 = new Day(3, "morsom", 7, "Eirik", 20, 20);
        Day day3 = new Day(2, "Hyggelig", 9, "Klara", 33, 33);
        summary.add(day1);
        summary.add(day2);
        summary.add(day3);
    }
    


    @Test //Sjekker at alle utregningene blir riktig 
    void testCalculations() {

        // --- Tester Vann ---
        Assertions.assertEquals(2, summary.getWater());
        // --- Tester Kompliment ---
        Assertions.assertEquals("Hyggelig", summary.getCompliment());
        // --- Test Søvn ---
        Assertions.assertEquals(""+1.0+ ","+0.0, summary.getSleep()); // *** Sjekk med flere verdier usikker på hvordan det funker med rest 
        // --- Test Appreciation ---
        Assertions.assertEquals("klara", summary.getAppreciation());
        // --- Tester Antall Riktig Matte ---
        Assertions.assertEquals(3 + "", summary.getMath());
        
    }

    
}
