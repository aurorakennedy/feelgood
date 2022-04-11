package feelgood;

import java.util.ArrayList;

//import feelgood.model.FeelGood; 

public interface FileReadWrite {
    //her skal alle mdetodene være som leser og skriver til fil

    public ArrayList<Day> readFile(String filename);
    
    public void writeFile(String filename, ArrayList<Day> writeDays);
}
