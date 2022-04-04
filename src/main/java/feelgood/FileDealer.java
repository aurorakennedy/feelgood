package feelgood;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDealer implements FileReadWrite {

    @Override
    public ArrayList<Day> readFile(String filename) {
        ArrayList<Day> readDays= new ArrayList<>();
        
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] linjeSplitta = line.split(", "); 
                //legg til linje som dag
                Day day = new Day(linjeSplitta[0], linjeSplitta[1], linjeSplitta[2], linjeSplitta[3], linjeSplitta[4]); 
                readDays.add(day); 

            
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return readDays;
    }

    @Override
    public void writeFile(String filename) {
                
    }
    
}
