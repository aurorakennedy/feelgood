package feelgood;

import java.io.IOException;
//import feelgood.model.FeelGood; 

public interface FileReadWrite {
    //her skal alle mdetodene være som leser og skriver til fil

    public Summary readFile(String filename);
    
    public void writeFile(String filename, Summary summary) throws IOException; 
}
