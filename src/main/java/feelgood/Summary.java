package feelgood;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Summary {

    private ArrayList<Day> days = new ArrayList<Day>();
    

    //lager Day-objekter
    public void add(double water,String compliments, double sleep, String appreciation, double math) throws IllegalArgumentException{ 
        try {
            Day day = new Day(water, compliments, sleep, appreciation, math);
            days.add(day); 
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }



    // -- Legger alt inn i listen results -- 
     public ArrayList<String> calculations(){     // Gjør alle utregninger 
        ArrayList<String> results = new ArrayList<>(); // da slipper vi å cleare den 

        //i denne funksjonen: hvis days.size()==0 -->avslutter metoden
        
        results.add(""+sumWater()); 
        results.add(longestCompliment()); // Blir det den oppdaterete longest her eller blir det den første vi satt?? 
        results.add(sleep());
        results.add(appreciation()); 

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
        return "Ingen dager registrert";
        }


        public String motivationalMessage() {
            String[] sleep = this.sleep().split(",");
            return "Bra gjennomført, " + /*Person.getName()*/ " \nDu var flink, du drakk " + calculations().get(0) + "liter \nDu har også vært generøs, noen ble nok glade for å høre at de var " + calculations().get(1) + "\nVilt! Du har sovet i " + sleep[0] + " dager og " + sleep[1] + " timer. \nDet er mange som bryr seg om deg, spesielt " + calculations().get(3) + "\nOg sist men ikke minst, så er du god i matte! Du fikk " + /*calculations().get(4) +*/ " riktige.";
        }

    
    // -- Utregning math --
    //andre funksjoner vi kan bruke igjen
   
/* Kan vi gjøre det til mer generelle metoder??? 
    private void glassesToLiters(){
        
    }

    complimentsSorted()
    */




    
    //public String compliments(List complimentList){
        //få ordene fra listen inn i tooString
        //If-løkke: hvis få ord: kanskje du skal prøve gi flere komplementer, det gir glede å glede andre
        //hvis passe mengde: Vi kunne sagt det samme om deg, itillegg er du snil! 
        //shvis formye: Dette var litt vell mange komplimenter, husk at det kan virke falskt!
        //complimentList[i] 
    

    public static void main(String[] args) {
        //Summary summary=new Summary();
        //System.out.println(summary.getResults());
    }
}
