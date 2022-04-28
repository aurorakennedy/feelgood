package feelgood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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


    // -- Utregning av vann --   regner ut totalen og gjør om fra glass til liter
    public String sumWater(){
        double glassesOfWater = 0; //setter totalt antall glass til 0
        for (Day day : days){  //for alle dagene i days-listen
            glassesOfWater += day.getWater(); //henter antall glass for enkelt dag og legger til i totalt antall glass
        }
        double litersOfWater = glassesOfWater*0.2; //regner om fra glass til liter
        return ("" + Math.round(litersOfWater * 100.0) / 100.0); //runder av resultatet
    }

    // -- Utregning compliments --    finner det lengste komplementet
    public String longestCompliment(){
        String longest = ""; //setter tom variabel som skal være det lengste komplementet
        for (Day day : days){ //for alle dagene i days
            String komplement = day.getCompliments(); //setter komplementet i dagen i egen variabel
            if(komplement.length() > longest.length()){ //hvis komplementet er lenger enn det lengste komplementet 
                longest = komplement; //setter det nye lengste inn i lengst-variabelen
            } 
        }
        return longest; //returnerer det lengste komplementet
    }


    //***burde denne egt returneres som en double? 
    // -- Utregning sleep --   regner ut totalt antall timer og gjør om til døgn + timer
    public String sleep(){
        double hoursSleep = 0; //totalt antall timer
        for (Day day : days){  //for alle dagene i days
            hoursSleep += day.getSleep(); //legger til antall timer hver dag til totalt antall timer
        }
        double daysSleep = Math.floor(hoursSleep/24); //regner ut hvor mange dager antall timer tilsvarer
        double modulo = Math.round(hoursSleep%24); //regner ut resten av timer etter antall dager er satt
        return(""+daysSleep+ "," +modulo); //returnerer i ønsket format
    }
        
    // -- Utregning appreciation --    finner det mest repeterte navnet, eller tilfeldig hvis det ikke finnes repeterende navn
    public String appreciation(){
        ArrayList<String> bestevennListe = new ArrayList<>(); //lager liste
        Set<String> bestevennSet = new HashSet<String> (); //lager sett
        for (Day day : days){
            bestevennListe.add(day.getAppreciation()); //legger til navn i liste
            bestevennSet.add(day.getAppreciation()); //legger til navn i sett
        }
        if (bestevennSet.size() < bestevennListe.size()){ //sjekker om det finnes duplikaster i lista
            String bestevenn = ""; //setter variabel for tomt navn
            int highestCount = 0; //setter variabel for teller
            for(int i = 0; i <bestevennListe.size(); i++){ //itererer gjennom navn i bestevennlista
                String venn  = bestevennListe.get(i); // navnet vi er på nå
                int teller = 0; //for å telle elementene 
                for( int j=0; j<bestevennListe.size(); j++ ){ //iterer gjennom navn i bestevennlista igjen
                    if(bestevennListe.get(j).equals(venn)){ //sjekker om hvert enkelt navn er likt venn
                        teller += 1; //hvis ja øker telleren (det finnes flere av navnet)
                    }
                if ( teller > highestCount){ //hvis teller blir høyere enn den som allerede er høyest
                    bestevenn = venn; //ny bestevenn
                    highestCount = teller; //ny highestCount
                }
                } 
            }
            return bestevenn; 
        }
        else{ 
            //returner random person fra liste/set
            Random random = new Random(); /// importerer random
            int plassering = random.nextInt(bestevennListe.size()); //finner tilfeldig tall fra 0 til lengden på bestevennlista
            String venn = bestevennListe.get(plassering); //henter navn på tilfeldig plassering
            return venn;
        }
    }

    // -- Utregning math --    regner ut antall totale riktige svar på mattespørsmålet
    public String math(){ 
        int antallRiktige=0; //setter variabelen til 0
        for (Day day : days){ //for alle dager i days-lista
            if(day.getCorrectAnswer()){ //hvis getCorrectAnswer() verdien i hver dag er true
                antallRiktige+=1; //telles én for hver riktige i antallRiktige-variabelen
            } 
        }
        return antallRiktige + ""; //returnerer antall riktige som en streng
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

    //toString til "Se oppsummering"-knappen
    public String motivationalMessage(String brukernavn) {
        String[] sleep = this.sleep().split(",");
        return "Bra gjennomført, " + brukernavn + "!\n\nDu var flink, du drakk " + sumWater() + " liter vann.\n\nDu har også vært generøs, noen ble nok glade for å høre at de var " + longestCompliment() + ".\n\nTotalt har du har sovet i " + sleep[0] + " døgn og ca " + sleep[1] + " time(r).\n\nHusk at det er mange som bryr seg om deg, spesielt " + appreciation() + ".\n\nOg sist men ikke minst, så er du god i matte! Du fikk " + math() + " riktig(e).";
    }

    //toString til "Se tidligere"-knappen
    public String tidligereString() {
        StringBuilder tidligereDager = new StringBuilder(); //StringBuilder er et slags String-objekt som kan endres mer fritt enn vanlig String
        for( Day day : this.days) { //for dager in days
            //formaterer setningen som skal returneres og legges til StringBuilder-variabelen
            tidligereDager.append("Vannmengde: " + day.getWater()+ "glass     Komplement(er): " + day.getCompliments() + "     Timer søvn: " + day.getSleep() + "\nHvem du har satt pris på: " + day.getAppreciation() + "     Ditt svar på mattestykket: " + day.getMath() +"\n\n");
        }
        return tidligereDager.toString(); //returnerer StringBuilder-variabelen
    }

    //sorterer listen utifra hvilken comparator som tas inn i controlleren
    public String sortDays(Comparator<Day> dayComparator) {
        Collections.sort(days, dayComparator); //sorterer days
        return tidligereString(); //kjører tidligereString med den nye days-verdien
    }
}