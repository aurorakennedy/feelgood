package feelgood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileDealer implements FileReadWrite {

    //leser fil, returnerer brukernavnet sitt Summary-objekt
    @Override
    public Summary readFile(String brukernavn) throws FileNotFoundException {
        Scanner scanner = null;
        Summary userSummary = null;
        
        try { //finner eksisterende fil 
            scanner = new Scanner(new File("src/main/resources/saves/" + brukernavn +".txt")); 
        } catch (FileNotFoundException e) { //utløser feilmelding hvis fil ikke eksisterer, programmet fortsetter
            throw new FileNotFoundException("Kunne ikke lese data fra bruker: " + brukernavn);
        }
            
        if (scanner != null) { //sjekker at fil er funnet, ellers hadde scanner vært null
            userSummary = new Summary(); //lager et nytt tomt Summary-objekt
            while (scanner.hasNext()) { //leser linjene til filen og gjør hver linje til Day-objekter, som legges til userSummary
                String line = scanner.nextLine(); 
                String[] linjeSplitta = line.split(", ");  //splitter på ","
                //gjør om linja til et Day-objekt:
                Day day = new Day(Double.parseDouble(linjeSplitta[0]), linjeSplitta[1] ,Double.parseDouble(linjeSplitta[2]), linjeSplitta[3], Integer.parseInt(linjeSplitta[4]), Integer.parseInt(linjeSplitta[5])); 
                userSummary.add(day); //legger til Day-objektet i userSummary
            }
        }     
        return userSummary; //brukernavn sitt Summary-objekt
    }


    //skriver all data som fylles inn til fil
    @Override
    public void writeFile(String brukernavn, Summary summary) throws IOException {
        try{
            PrintWriter f = new PrintWriter(new FileWriter(new File( "src/main/resources/saves/" + brukernavn +".txt"))); //sier hvilken fil som skal skrives til 
            f.write(summary.toString()); //skriver toStringen fra Summary-klassen til filen
            f.close(); //lukker filen
        }
        catch (FileNotFoundException e){ 
            System.err.println("Klarer ikke å skrive til fil.");
        } 
    }
}
