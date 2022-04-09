package feelgood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileDealer implements FileReadWrite {

    

    //ArrayList<Day> readDays= new ArrayList<>();
    
    // ** Lagde konstroktøren så kunne sjekke i mainen 
    // ** - vet ikke om det er nødvendig når vi får kobla den opp til controllern 
   private String filename = ""; 

    
    public FileDealer(String filename){ 
        this.filename = filename;
    }

    public static String getFilePath(String filename){
        return FileDealer.class.getResource("saves/").getFile() + filename + ".txt";
    }

    // ** Her prøver jeg å sjekke om filen funker eller ikke
    // ** så dette på w3school, skal egentlig lage fil hvis den eksisterer, tror ikke dett funker enda 
    // ** tanken er at her kan vi adde de to andre funskjonene read/write 
    // ** trenger da bare å kalle på denne fubnksjonen i kontrollen 
    public void finnFil(){
        try{ 
            File file = new File(this.filename, ".txt");
            if (file.createNewFile()) {
                System.out.println("Ny fil laget");
            }
            else{
                System.out.println("Fil finnes");
                //writeFile(filename)... noe sånt 
            }
        }
        catch (IOException e){
            System.out.println("Noe er feil");
        }
    }



    @Override
    // ** NOE FEIL HER: leser ikke fil jeg har laget
    public ArrayList<Day> readFile(String filename) {
        // ** Satt listen uttafor for da har write tilgang til den også men vet ikke om det fucker det opp 
        ArrayList<Day> readDays= new ArrayList<>();
    
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(filename)); //sjekker om filen finnes
            while (scanner.hasNext()) {
                //System.out.println("test");
                String line = scanner.nextLine();
                System.out.println(line); // se hva som står i filen 
                String[] linjeSplitta = line.split(", "); 
                //legg til linje som dag
                Day day = new Day(linjeSplitta[0], linjeSplitta[1] /*, linjeSplitta[2], linjeSplitta[3], linjeSplitta[4]*/); 
                Day dag2 = new Day("hei", "test");
                System.out.println(day);
                readDays.add(day); 
                readDays.add(dag2);

            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: file 'filename' could not open");
            System.exit(1);
        }
        System.out.println(readDays.toString()); // her feilen ligger, blir ikke lagt riktig til i lista 
        return  readDays;
        
    }

    @Override
    // ** Funker halveis, sletter det som allerede står i filen/ adder ikke
    // ** men kommer tom liste så den skriver noe til filen
    public void writeFile(String filename) {
        try{
            PrintWriter outFile = new PrintWriter(filename);
            outFile.println(readDays);
            outFile.close();
        }
        catch (FileNotFoundException e){
            System.err.println("feil");
            System.exit(1);
        }
    }
    

    //** Prøver å teste og få alt til å funke med main metoden før tester med kontrolleren */
    public static void main(String[] args) {
        FileDealer filedealer = new FileDealer("aurora");
        //filedealer.writeFile("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\aurora");
        //filedealer.readFile("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\aurora");
        filedealer.readFile("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\aurora");
        
    }
}
