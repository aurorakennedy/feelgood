package feelgood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class FileDealer implements FileReadWrite {
   /*
   //Dette er lagd kunn for main - tror vi kan slette det når vi har kobla til controlleren: 
    //private String filename = ""; 
   /* 
    public FileDealer(String filename){ 
        this.filename = filename;
    }
*/

// ?? FÅ HJLEP AV STUDAS - hvordan få til førte linje under .getResorce, at vet hvor på pc den skal lagres. 
   
    public static String getFilePath(String filename){
        return FileDealer.class.getResource("src/main/resources/saves/").getFile() + filename + ".txt";
        //String name = FileDealer.class.getResource("C:/Users/auror/OneDrive/Documents/Vår2022/Objekt/TDT4100_prosjekt_aurorke/src/main/resources/saves/").getFile() + filename + ".txt";
        //return Path.of(System.getProperty("user.home"), "tdt4100", "feelgood");
        //return ("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\TDT4100_prosjekt_aurorke\\src\\main\\resources\\saves\\" + filename + ".txt");
    }

    
    // ** Her prøver jeg å sjekke om filen funker eller ikke
    public void finnFil(String filename){
        try{ 
            //fix this 
           // String fullFilePath = "C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\TDT4100_prosjekt_aurorke\\src\\main\\resources\\saves\\" + filename + ".txt";
            String fullFilePath = "src/main/resources/saves/" + filename +".txt";
            PrintWriter printWriter = null;

            File file = new File(fullFilePath);

            if(!file.exists()){
                System.out.println("creating new user file " + fullFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
                printWriter = new PrintWriter(new FileOutputStream(fullFilePath, true));
                // ?? Trenger vi dette: 
                printWriter.write("water, compliments, sleep, appreciation, math");
            }
        }
        catch (IOException e){
            System.out.println("Noe er feil");
        }
    }



    @Override
    public ArrayList<Day> readFile(String filename) {
        ArrayList<Day> readDays= new ArrayList<>();
    
        Scanner scanner;
        try {
            //scanner = new Scanner(new FileReader(filename)); //sjekker om filen finnes

            //String fullFilename = getFilePath(getFilePath(filename));
            // System.out.println(new File(getFilePath(filename)) );

            //FileReader fileToRead = new FileReader(getFilePath(filename));

            //FileReader fileToRead = new FileReader(filename);
            //scanner = new Scanner(new File(getFilePath(filename)));
            finnFil(filename); //???????? Funker dette ? 
            
            scanner = new Scanner(new File("src/main/resources/saves/" + filename +".txt"));
            
            while (scanner.hasNext()) {
                //System.out.println("test");
                String line = scanner.nextLine();
                //System.out.println(line); // se hva som står i filen 
                String[] linjeSplitta = line.split(", "); 
                
                //legg til linje som dag
                Day day = new Day(Double.parseDouble(linjeSplitta[0]), linjeSplitta[1] ,Double.parseDouble(linjeSplitta[2]), linjeSplitta[3], Double.parseDouble(linjeSplitta[4])); 
                System.out.println(day);
                readDays.add(day); 
                
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: file 'filename' could not open");
            System.exit(1);
        }
        System.out.println(readDays.toString()); 
        return  readDays;
        
    }

    @Override
    public void writeFile(String filename, ArrayList<Day> writeDays) throws IOException {
        try{
            //PrintWriter outFile = new PrintWriter(filename);
            //finnFil(filename);
            //PrintWriter outFile = new PrintWriter(new File(getFilePath(filename)));
            PrintWriter outFile = new PrintWriter(new FileWriter(new File( "src/main/resources/saves/" + filename +".txt"), true));
            // lagde for løkke så det som sto i filen tidligere ikke forsvinner
            // ?? kan man bare appende 
            
            for(int i = 0; i < writeDays.size(); i++){
                outFile.append(writeDays.get(i)+ "");
                //outFile.println();
            }
            outFile.close();
        }
        catch (FileNotFoundException e){
            System.err.println("feil");
            System.exit(1);
        }
    }
    

    //** Prøver å teste og få alt til å funke med main metoden før tester med kontrolleren */
    
    /*public static void main(String[] args) {
        ArrayList<Day> allDays= new ArrayList<>();

        String username = "Jens2";
        FileDealer filedealer = new FileDealer(username);
        filedealer.finnFil();
        //filedealer.writeFile("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\aurora");
        //filedealer.readFile("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\aurora");
        //allDays = filedealer.readFile("C:\\Users\\auror\\OneDrive\\Documents\\Vår2022\\Objekt\\aurora");
        allDays = filedealer.readFile(username);  
        //System.out.println(allDays.get(0) + "; " + allDays.size() );

        System.out.println("Now we append to the file");
        Day enterDay = new Day("4", "kul", "9","pappa", "33"); 
        allDays.add(enterDay);

        filedealer.writeFile(username, allDays);

        allDays = filedealer.readFile(username);  
        System.out.println(allDays.get(0) + "; " + allDays.size() );
    
    } */
}
