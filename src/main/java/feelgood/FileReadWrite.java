package feelgood;

import java.io.IOException;
import java.io.FileNotFoundException;
//import feelgood.model.FeelGood; 

public interface FileReadWrite {
    //her skal alle mdetodene være som leser og skriver til fil

    public Summary readFile(String brukernavn) throws FileNotFoundException;
    
    public void writeFile(String brukernavn,Summary summary) throws IOException; 
}
