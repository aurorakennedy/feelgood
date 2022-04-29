package feelgood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;


import java.io.FileNotFoundException;

public class FileDealerTest {

    FileDealer fileDealer = new FileDealer(); 
    Summary summary = new Summary(); 
    Person person= new Person("mari", summary); 


    @BeforeEach
    public void creatSummary(){
        Day day1 = new Day(5, "søt", 8, "Klara", 10, 10);
        Day day2 = new Day(3, "morsom", 7, "Eirik", 20, 20);
        Day day3 = new Day(2, "Hyggelig", 9, "Klara", 33, 33);
        summary.add(day1);
        summary.add(day2);
        summary.add(day3);
        
    }

    @Test
	public void testSave() {
		try { 
			fileDealer.writeFile(person.getName(), summary); // Prøver å skriver til fil 
		} catch (IOException e) {
			fail("Could not save file");
		}


		Summary testFile = null; // Har en testfil som er lik null 

		try {
			testFile = fileDealer.readFile(person.getName());  // Sjekker nå om den klarer å lese filen vi lagde istad
		} catch (Exception e) {
			fail("Could not load test file");
		}

		assertNotNull(testFile); // Ikke null hvis den klarte å lese filen 
		assertEquals(person.getSummary(), testFile); // Sjekker at den leste riktig fil
		//^^ Sammenligner ett day objekt og ett summay objekt, i utgangspunkte ville java sagt at det ikke var like siden det er to forskjellige objekt, men vi overwriter equals metoden og får den til å sjekke at innholde er likt 
	}

    @Test
	public void testReadFile() {
		Summary newFile = null;  // En til testfil som er null
		try {
			newFile = fileDealer.readFile(person.getName());  // sjekker om vi klarer å lese filen
		} catch (Exception e) {
			fail("Could not load saved file");
		}
		assertEquals(summary.getDays().get(0).toString(), newFile.getDays().get(0).toString()); // Sjekker om filen inneholder det vi forvendtet 
		
	}

    
    @Test
	public void testLoadNonExistingFile() { // sjekker at den ikke leser en ikke eksisterende fil 
		assertThrows(
				FileNotFoundException.class,
				() -> summary = fileDealer.readFile("foo"),
				"FileNotFoundException should be thrown when file does not exist!");
	}
    
    @Test
	public void testLoadInvalidFile() { // sjekker at den ikke klarere leser en fil med feil innhold 
		assertThrows(
				Exception.class,
				() -> summary = fileDealer.readFile("invaledSave"),
				"An exception should be thrown if loaded file is invalid!");
	}

   
}
