package feelgood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileDealer implements FileReadWrite {


    //leser fil, returnerer filnavnet/brukernavnet sitt Summary-objekt
    @Override
    public Summary readFile(String brukernavn) {
        Scanner scanner = null;
        Summary userSummary = null;
        
        try { //finner eksisterende fil 
            scanner = new Scanner(new File("src/main/resources/saves/" + brukernavn +".txt"));
        } catch (FileNotFoundException e) { //utløser feilmelding hvis fil ikke eksisterer, men programmet fortsetter
            System.err.println(brukernavn + "finnes ikke fra før av. Koden kjører videre.");
        }
            
        if (scanner != null) { //sjekker at fil er funnet, ellers hadde scanner vært null
            userSummary = new Summary(); //lager et nytt tomt Summary-objekt
            while (scanner.hasNext()) { //leser linjene til filen og gjør hver linje til Day-objekter, som legges til userSummary
                String line = scanner.nextLine(); 
                String[] linjeSplitta = line.split(", ");  //splitter på ","
                //gjør om linja til et Day-objekt:
                Day day = new Day(Double.parseDouble(linjeSplitta[0]), linjeSplitta[1] ,Double.parseDouble(linjeSplitta[2]), linjeSplitta[3], Integer.parseInt(linjeSplitta[4]), Integer.parseInt(linjeSplitta[5])); 
                userSummary.add(day); //legger til Day-objektet i userSummary
                System.out.println(day); //til terminal slik at vi kan se de enkelte Day-objektene             
            }
        }     
        return userSummary; //filename/brukernavn sitt Summary-objekt
    }


    //skriver all data som fylles inn til fil
    @Override
    public void writeFile(String brukernavn, Summary summary) throws IOException {
        try{
            PrintWriter outFile = new PrintWriter(new FileWriter(new File( "src/main/resources/saves/" + brukernavn +".txt"))); //sier hvilken fil som skal skrives til (tilsvarende f i python)  
            outFile.write(summary.toString()); //skriver toStringen fra Summary-klassen til filen
            outFile.close(); //lukker filen
        }
        catch (FileNotFoundException e){ 
            System.err.println("Klarer ikke å skrive til fil.");
            //System.exit(1);
        } // ***hvordan lager man illegalargumentexception når det allerede er filenotfoundexception? sånn som over?^
    }
}
