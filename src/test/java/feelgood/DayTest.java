package feelgood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayTest {
    
    private Day day; 

    @BeforeEach // Lager dagen som vi skal teste, testene våres på:
    private void creatDay(){
        day = new Day(4, "søt", 8, "Frida", 21, 21);
    }

    @Test
    public void testConstructor(){
        // Sjekker at alle verdiene vi har lagt til er riktig i forhold til det vi henter fra day klassen 
        Assertions.assertEquals(4, day.getWater());
        Assertions.assertEquals("søt", day.getCompliments());
        Assertions.assertEquals(8, day.getSleep());
        Assertions.assertEquals("frida", day.getAppreciation());
        Assertions.assertEquals(21, day.getMath());
        Assertions.assertTrue(day.getCorrectAnswer()); //Tror det er sånn vi sjekker actualAnswer, siden den skal være true hvis den er lik math

        //Sjekker at alle feilmeldingen blir utløst hvis det er feil i day objektet
        // Vann ---> Sjekker at mengde vann ikke kan være negativt
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Day(-2, "søt", 8, "frida", 21, 21); 
		});
        // Vann ---> Sjekker at mengde vann ikke kan være mer enn 50
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Day(67, "søt", 8, "frida", 21, 21); 
		});

        // Komplement ---> Sjekker at komlimant ikke kan være kortere enn tre bokstaver
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Day(4, "sa", 8, "frida", 21, 21); 
		});

        // Søvn ---> Sjekker at man ikke har kan sove i mer enn 24 timer 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Day(4, "søt", 30, "frida", 21, 21); 
		});

        // Appreciation ---> Sjekker at navnet ikke er lenger enn 15 bokstaver
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Day(4, "søt", 8, "fridafridafridafrida", 21, 21); 
		});

        //Matte ---> Sjekker om svare er mer enn +-3 fra riktig svar, ikke blir riktig
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Day(4, "søt", 8, "frida", 55, 21); 
		});


    }
}
