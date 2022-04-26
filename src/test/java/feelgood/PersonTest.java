package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person person; 
    private Summary summary; 

    @BeforeEach // Lager dagen som vi skal teste, testene våres på:
    private void creatPerson(){
        person = new Person("klara", summary);
    }

    @Test
    public void testConstructorName(){
        Assertions.assertEquals("klara", person.getName());
    }

    // *** Studass: Litt usikker på denne, men den kjørte, er det sånn man tester summary
    public void testConstructorSummary(){
        Assertions.assertEquals(summary, person.getSummary());
        
    
     // Komplement ---> Sjekker at komlimant ikke kan være kortere enn tre bokstaver
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new Person("kkkkkkkkkkeeeeeeeeeeee", summary); 
	    });
    }
}   
