package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person person; 
    private Summary summary; 

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
