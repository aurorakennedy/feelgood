package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person person; 

    @BeforeEach // Lager dagen som vi skal teste, testene våres på:
    private void creatPerson(){
        person = new Person("klara");
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("klara", person.getName());
    

     // Komplement ---> Sjekker at komlimant ikke kan være kortere enn tre bokstaver
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new Person("kkkkkkkkkkeeeeeeeeeeee"); 
	    });
    }
}   
