package feelgood;

import java.io.IOException;
//import feelgood.model.FeelGood; 

public interface FileReadWrite {
    //her skal alle mdetodene være som leser og skriver til fil

    public Summary readFile(String brukernavn);
    
    public void writeFile(String brukernavn,Summary summary) throws IOException; 
}
