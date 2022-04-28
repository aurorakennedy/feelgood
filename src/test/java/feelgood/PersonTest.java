package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Summary summary = new Summary(); 
    Person person; 


    @BeforeEach
    private void creatSummary(){
        Day day1 = new Day(5, "søt", 8, "Klara", 10, 10);
        Day day2 = new Day(3, "morsom", 7, "Eirik", 20, 20);
        Day day3 = new Day(2, "Hyggelig", 9, "Klara", 33, 33);
        summary.add(day1);
        summary.add(day2);
        summary.add(day3);
    }
 

    @BeforeEach // Lager dagen som vi skal teste, testene våres på:
    private void creatPerson(){
        person = new Person("klara", summary); 
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("klara", person.getName());
        Assertions.assertEquals(summary, person.getSummary()); 

        //Sjekker at navnet ikke kan være lengere enn 15 bokstaver 
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new Person("kkkkkkkkkkeeeeeeeeeeee", summary); 
	    });

        //Sjekker at navnet ikke kan være tomt 
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new Person("", summary); 
	    });

        //Sjekker at navnet ikke kan innholde ett mellomrom  
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new Person("Klara Louise", summary); 
	    });

    }
}   
