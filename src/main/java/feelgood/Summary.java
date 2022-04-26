package feelgood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Summary {
    FileDealer fileDealer;  //gjør at vi kan bruke fileDealer-metoder her

    private ArrayList<Day> days = new ArrayList<Day>(); //liste med alle dagene
    //legger til day-objekter i days-listen
    public void add(Day day) throws IllegalArgumentException{ 
        days.add(day); 
    }
    //henter listen
    public ArrayList<Day> getDays() {
        return this.days;
    }


    // -- Legger resulatene av utregningene nedenfor inn i results-listen og returnerer denne -- 
     public ArrayList<String> calculations(){ 
        ArrayList<String> results = new ArrayList<>(); // har listen inni metoden, slik at den lages på nytt hver gang -da slipper vi å cleare den
        results.add(""+sumWater()); 
        results.add(longestCompliment());
        results.add(sleep());
        results.add(appreciation()); 
        results.add(math());
        System.out.println("results:" + results); //til terminal (fjernes)
        return results;
    }
        

    // -- Utregning av vann -- 
    private double sumWater(){
        double glassesOfWater = 0; 
        double litersOfWater; 
        for (Day day : days){  //itererer gjennom dagene
            glassesOfWater += day.getWater();  //går inn i enkelt dag-->kjører getWater funksjonen for denne dagen og legger til glassesOfWater
        }
        litersOfWater = glassesOfWater*0.2; 
        return litersOfWater;
    }

    // -- Utregning compliments --
    private String longestCompliment(){
        String longest = "";
        for (Day day : days){
            String komplement = day.getCompliments(); 
            if(komplement.length() > longest.length()){
                longest = komplement;
            } 
        }
    return longest;
    }


    // -- Utregning sleep --
    private String sleep(){
        double hoursSleep = 0;
        double daysSleep;
        double modulo; 
        for (Day day : days){  // i - itererer gjennom dagene
            hoursSleep += day.getSleep();  //går inn i enkelt dag-->kjører getSleep funksjonen for denne dagen og legger til hoursSleep
        }
        daysSleep = Math.floor(hoursSleep/24);
        modulo = Math.round(hoursSleep%24);
        String sleep = (""+daysSleep+ "," +modulo);
        return sleep;
    }
    
        
    // -- Utregning appreciation -- //*** Gå gjennom den her... 
    private String appreciation(){
        System.out.println("test");
        ArrayList<String> bestevennListe = new ArrayList<>();
        Set<String> bestevennSet = new HashSet<String> ();
        // Legger til hvert element i listen og sett
        for (Day day : days){
            bestevennListe.add(day.getAppreciation());
            bestevennSet.add(day.getAppreciation());
        }

        //da finnes det duplikat og vi må finne den som er repetert oftest
        if (bestevennSet.size() < bestevennListe.size()){
            String bestevenn = ""; 
            int count = 0; 
                for(int i = 0; i <bestevennListe.size(); i++){
                    String midlertidigBestevenn = bestevennListe.get(i); // elemente vi er på nå
                    int tempCount = 0; //for å telle elementene 
                    for( int p=0; p<bestevennListe.size(); p++ ){
                        if(bestevennListe.get(p).equals(midlertidigBestevenn)){ //går gjennom alle og sjekker om de er like til tempelement 
                            tempCount += 1; 
                        }
                    if ( tempCount > count){ // tror det lagrer tempElement some element hvis den har større count 
                        bestevenn = midlertidigBestevenn; 
                        count = tempCount; 
                    }
                    } 
                }
            return bestevenn; 
        
        //return "Set" + bestevennSet + "Liste:" + bestevennListe;
        }
        else{ // https://www.codegrepper.com/code-examples/java/picking+a+random+string+from+string+array+java
                //returner random person fra liste/set
            Random random = new Random(); /// importerer her random 
            int randomeNumber = random.nextInt(bestevennListe.size()); 
                // nextInt er en funskjon fra nett, litt usikker på hva den gjør men tror den bare sier ett tall i listen sin størrelse 
            String komplimentResult = bestevennListe.get(randomeNumber);
                // her finner vi da ett kompliment i listen 
            return komplimentResult;         
            }
        }

        
    //return "mammaen din";
    //}

    // -- Utregning math --
    private String math(){
        int antallRiktige=0;
        for (int i=0; i < days.size(); i++){ 
            if(days.get(i).getCorrectAnswer()){
                antallRiktige+=1;
            } 
        }
    return antallRiktige + "";
    }


    //toString til "Se oppsummering"-knappen
    public String motivationalMessage(String brukernavn) {
        String[] sleep = this.sleep().split(",");
        return "Bra gjennomført, " + brukernavn + "!\n\nDu var flink, du drakk " + calculations().get(0) + "liter vann.\n\nDu har også vært generøs, noen ble nok glade for å høre at de var " + calculations().get(1) + ".\n\nTotalt har du har sovet i " + sleep[0] + " dag(er) og " + sleep[1] + " time(r).\n\nHusk at det er mange som bryr seg om deg, spesielt " + calculations().get(3) + ".\n\nOg sist men ikke minst, så er du god i matte! Du fikk " + calculations().get(4) + " riktig(e).";
    }

    //toString som skriver dager til fil 
    @Override
    public String toString() {
        StringBuilder stringTilFil = new StringBuilder(); //StringBuilder er et slags String-objekt som kan endres mer fritt enn vanlig String
        for( Day day : this.days) { //for dager in days
            stringTilFil.append(day); //legger til dager i tidligereDager
            stringTilFil.append("\n");  //lager linjeskift mellom dagene
        }
        return stringTilFil.toString(); //returnerer spalten som kommer opp når man trykker på "se tidligere"
    }

    //toString til "se tidligere"-knappen
    public String tidligereString() {
        StringBuilder tidligereDager = new StringBuilder(); //StringBuilder er et slags String-objekt som kan endres mer fritt enn vanlig String
        for( Day day : this.days) { //for dager in days
            String [] enkelt = String.valueOf(day).split(", "); //lager en streng av hvert enkelt Day-objekt og splitter dette
            //formaterer setningen som skal returneres og legges til StringBuilder-variabelen
            tidligereDager.append("Vannmengde: " + enkelt[0] + "glass     Komplement(er): " + enkelt[1] + "     Timer søvn: " + enkelt[2] + "\nHvem du har satt pris på: " + enkelt[3] + "     Ditt svar på mattestykket: " + enkelt[4] +"\n\n");
        }
        return tidligereDager.toString(); //returnerer StringBuilder-variabelen
    }

}