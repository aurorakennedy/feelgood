package feelgood;
import java.io.File;
import java.io.PrintWriter;
//ta inn input, skrive til fil eller lagre til globale variabler elns (hvis flere profiler: lage nye filer hvor navnet på personen brukes, sjekke om navn finnes før man lager)
import java.util.Date;



    //Liste med alle day 
    // Dag må være knyttet til person på en eller annen måte 
    // ArrayList Answers , lagre days i lista . Appender day til lista i person objektet 
    // Så når du lagrer personobjekte ditt vil alle feltene bli lagret 


    // Lagre person - Skal vi ha muligheten til å lage ny person - reste alt 
    // Ta inn repiterende info 

public class Person {
    private String name;
    //private Date bday; 
    //private String gender;


    // Konstruktør 
    public Person(String name){
        if (name.length()>2 && name.length()<15){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Navnet må være på mellom 2 og 15 bokstaver.");
        }
       
    }

    // Lagre attributter til fil 



    /*public void lagreBruker(navn){
        File fil = new File(navn);
        if (fil.createNewFile()){
            //opprett ny bruker
        } else {
            //finn data for eksisterende bruker
        }
    }*/

//fra kort-forklart
   /* public void writeToFile(String filename){
        try{
            PrintWriter writer = new PrintWriter(filename);
            for (Day day: days){
                writer.println(day.getWater());
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
*/
    

}
