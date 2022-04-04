package feelgood;

import java.util.ArrayList;

//import feelgood.model.FeelGood; 

public interface FileReadWrite {
    //her skal alle mdetodene være som leser og skriver til fil

    ArrayList<Day> readFile(String filename);
    void writeFile(String filename);
}
