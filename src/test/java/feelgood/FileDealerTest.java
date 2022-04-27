package feelgood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileDealerTest {

    Summary summary = new Summary(); 
    FileDealer fileDealer; 
    Person person= new Person("mari", summary); 


    @BeforeEach
    void creatSummary(){
        Day day1 = new Day(5, "søt", 8, "Klara", 10, 10);
        Day day2 = new Day(3, "morsom", 7, "Eirik", 20, 20);
        Day day3 = new Day(2, "Hyggelig", 9, "Klara", 33, 33);
        summary.add(day1);
        summary.add(day2);
        summary.add(day3);
    }

    @Test
	public void testReadFile() {
		Summary newFile;
		try {
			newFile = fileDealer.readFile(person.getName());
		} catch (FileNotFoundException e) {
			fail("Could not load saved file");
			return;
		}
		assertEquals(summary.toString(), newFile.toString());
		assertFalse(summary.isGameOver());
	}

    
    
}
