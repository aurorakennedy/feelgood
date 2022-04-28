package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Summary summary = new Summary(); 
    Person person; 


    @BeforeEach
    public void creatSummary(){
        Day day1 = new Day(5, "søt", 8, "Klara", 10, 10);
        Day day2 = new Day(3, "morsom", 7, "Eirik", 20, 20);
        Day day3 = new Day(2, "Hyggelig", 9, "Klara", 33, 33);
        summary.add(day1);
        summary.add(day2);
        summary.add(day3);
        //person.setSummary(summary);
    }
 

    @BeforeEach // Lager dagen som vi skal teste, testene våres på:
    private void creatPerson(){
        person = new Person("klara", summary); // *** Studas: Kan jeg bare ta inn summary her som en variabel??
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("klara", person.getName());
        Assertions.assertEquals(summary, person.getSummary()); // Er dette feil?! 

        //Sjekker at navnet ikke kan være lengere enn 15 bokstaver 
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new Person("kkkkkkkkkkeeeeeeeeeeee", summary); 
	    });

    }
}   
