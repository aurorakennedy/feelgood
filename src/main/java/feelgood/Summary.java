package feelgood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Summary {

    FileDealer fileDealer; 
    Person person;
    //lager en liste hvor alle dagene ligger
    private ArrayList<Day> days = new ArrayList<Day>(); 
    //henter listen
    public ArrayList<Day> getDays() {
        return this.days;
    }

    //legger til day-objekter i days-listen
    public void add(Day day) throws IllegalArgumentException{ 
        days.add(day); 
    }


    // -- Legger resulatene av utregningene nedenfor inn i results-listen og returnerer denne -- 
     public ArrayList<String> calculations(){ 
        ArrayList<String> results = new ArrayList<>(); // har listen inni metoden, slik at den lages på nytt hver gang -da slipper vi å cleare den
        results.add(""+sumWater()); 
        results.add(longestCompliment()); // Blir det den oppdaterete longest her eller blir det den første vi satt?? 
        results.add(sleep());
        results.add(appreciation()); 
        results.add(math());
        return results;
        }
        

    // -- Utregning av vann -- 
    private double sumWater(){
        double glassesOfWater = 0; 
        double litersOfWater; 
        for (int i=0; i < days.size(); i++){  // i - itererer gjennom dagene
            glassesOfWater += days.get(i).getWater();  //går inn i enkelt dag-->kjører getWater funksjonen for denne dagen og legger til glassesOfWater
        }
        litersOfWater = glassesOfWater*0.2; 
        return litersOfWater; 
    }

    // -- Utregning compliments --
    private String longestCompliment(){
        String longest = "";
        for (int i=0; i < days.size(); i++){
            String komplement = days.get(i).getCompliments(); 
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
        for (int i=0; i < days.size(); i++){  // i - itererer gjennom dagene
            hoursSleep += days.get(i).getSleep();  //går inn i enkelt dag-->kjører getSleep funksjonen for denne dagen og legger til hoursSleep
        }
        daysSleep = Math.floor(hoursSleep/24);
        modulo = Math.round(hoursSleep%24);
        String sleep = (""+daysSleep+ "," +modulo);
        return sleep;
    }
    
        
    // -- Utregning appreciation --
    private String appreciation(){
        ArrayList<String> bestevennListe = new ArrayList<>();
        Set<String> bestevennSet = new HashSet<String> ();
        for (int i=0; i < days.size(); i++){
            bestevennListe.add(days.get(i).getAppreciation());
            bestevennSet.add(days.get(i).getAppreciation());
            if (bestevennSet.size() < bestevennListe.size()){
                //da finnes det duplikat og vi må finne den som er repetert oftest
                // [snill, søt, morsom]
                String bestevenn = ""; 
                int count = 0; 
                for(int j = 0; j <bestevennListe.size(); j++){
                    String midlertidigBestevenn = bestevennListe.get(i); // elemente vi er på nå
                    int tempCount = 0; //for å telle elementene 
                    for( int p=0; p<bestevennListe.size(); p++ ){
                        if(bestevennListe.get(i).equals(midlertidigBestevenn)){ //går gjennom alle og sjekker om de er like til tempelement 
                            tempCount += 1; 
                        }
                    if ( tempCount > count){ // tror det lagrer tempElement some element hvis den har større count 
                        bestevenn = midlertidigBestevenn; 
                        count = tempCount; 
                    }
                    } 
                }
                return bestevenn; 
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
        return "mammaen din.";
    }

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


    //Returnerer hele oppsummeringen
    public String motivationalMessage() {
        String[] sleep = this.sleep().split(",");
        return "Bra gjennomført, " + /*person.getName() +*/ " \nDu var flink, du drakk " + calculations().get(0) + "liter vann\nDu har også vært generøs, noen ble nok glade for å høre at de var " + calculations().get(1) + "\nTotalt har du har sovet i " + sleep[0] + " dag(er) og " + sleep[1] + " time(r). \nHusk at det er mange som bryr seg om deg, spesielt " + calculations().get(3) + "\nOg sist men ikke minst, så er du god i matte! Du fikk " + calculations().get(4) + " riktig(e).";
    }
    
    //Skriver til fil -- brukes i  writeFile i FileDealer
    @Override
    public String toString() {
        StringBuilder tidligereDager = new StringBuilder(); //StringBuilder er et slags String-objekt som kan endres mer fritt enn vanlig String
        for( Day day : this.days) { //for dager in days
            tidligereDager.append(day); //legger til dager i tidligereDager
            tidligereDager.append("\n");  //lager linjeskift mellom dagene
        }
        return tidligereDager.toString(); //returnerer spalten som kommer opp når man trykker på "se tidligere"
    }

    //Lager en toString til "Se Tidligere" - kanppen, brukes i controlleren 
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