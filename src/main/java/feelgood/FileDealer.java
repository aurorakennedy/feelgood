package feelgood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileDealer implements FileReadWrite {
   
    public static String getFilePath(String filename){
        return FileDealer.class.getResource("src/main/resources/saves/").getFile() + filename + ".txt";
    }

    
    // ** Her prøver jeg å sjekke om filen funker eller ikke
    public void finnFil(String filename){
        try{ 
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
                Day day = new Day(Double.parseDouble(linjeSplitta[0]), linjeSplitta[1] ,Double.parseDouble(linjeSplitta[2]), linjeSplitta[3], Integer.parseInt(linjeSplitta[4]), Integer.parseInt(linjeSplitta[5])); 
                System.out.println(day);
                readDays.add(day); 
                
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: file 'filename' could not open");
            System.exit(1);
        }
        //System.out.println(readDays.toString()); 
        return  readDays;
        
    }

    public String tidligereDag(String filename){
        if(readFile(filename).size() > 0){
            //ArrayList<Day> tidligereDager = new ArrayList<Day>();
            StringBuilder tidligereDager = new StringBuilder(); 
            //for (int i = 0; readFile(filename).size() > 0 ; i++){
            for( Day day : readFile(filename)){
                //tidligereDager.add(readFile(filename).get(i));
                tidligereDager.append(day);
                tidligereDager.append("\n");
            }
            return tidligereDager.toString(); 
        } else{
            throw new IllegalArgumentException("Du må fylle ut minst en dag");
        }
    }

    @Override
    public void writeFile(String filename, ArrayList<Day> writeDays) throws IOException {
        try{
            //PrintWriter outFile = new PrintWriter(filename);
            //finnFil(filename);
            //PrintWriter outFile = new PrintWriter(new File(getFilePath(filename)));
            PrintWriter outFile = new PrintWriter(new FileWriter(new File( "src/main/resources/saves/" + filename +".txt"), true));
            String lineBreak = System.lineSeparator(); 
            // lagde for løkke så det som sto i filen tidligere ikke forsvinner
            // ?? kan man bare appende 
            
            for(int i = 0; i < writeDays.size(); i++){
                outFile.append(writeDays.get(i)+ "" + lineBreak);
                //outFile.println(lineBreak);
            } 
            //outFile.println("Dette er en" + lineBreak +"Test");
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
