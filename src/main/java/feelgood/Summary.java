package feelgood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//lese fra fil, gjøre beregninger, output
public class Summary {

    private ArrayList<Day> days = new ArrayList<Day>();
    private ArrayList<String> results = new ArrayList<>();

    //lager Day-objekter
    public void add(String water,String compliments, String sleep, String appreciation, String math){ 
        Day day = new Day(water, compliments, sleep, appreciation, math); 
        days.add(day); 
    }

    public ArrayList<String> calculations(){     // Gjør alle utregninger 

        // -- Utregning av vann -- 
        double glassesOfWater = 0; 
        double litersOfWater; 

        for (int i=0; i < days.size(); i++){  // i - itererer gjennom dagene

            glassesOfWater += days.get(i).getWater();  //går inn i enkelt dag-->kjører getWater funksjonen for denne dagen og legger til glassesOfWater


        }
        litersOfWater = glassesOfWater*0.2; // f gjør 0.2 (var en double) til en float 
        results.add(""+litersOfWater); //Teit men samme som .toString()


        // -- Utregning compliments --
        String longest = days.get(0).getCompliments(); 

        for (int i=0; i < days.size(); i++){
            String komplement = days.get(i).getCompliments(); 
            if(komplement.length() > longest.length()){
                longest = komplement;
            }
        results.add(longest); // Blir det den oppdaterete longest her eller blir det den første vi satt?? 
         }

        
        // -- Utregning sleep --
        double hoursSleep = 0;
        double daysSleep;
        double modulo; 

        for (int i=0; i < days.size(); i++){  // i - itererer gjennom dagene
            hoursSleep += days.get(i).getSleep();  //går inn i enkelt dag-->kjører getSleep funksjonen for denne dagen og legger til hoursSleep
        }
        daysSleep = Math.floor(hoursSleep/24);
        modulo = hoursSleep%24;
        results.add(""+daysSleep+" + "+modulo);


        // -- Utregning appreciation --
        ArrayList<String> bestevennListe = new ArrayList<>();
        Set<String> bestevennSet = new HashSet<String> ();
        for (int i=0; i < days.size(); i++){
            bestevennListe.add(days.get(i).getAppreciation());
            bestevennSet.add(days.get(i).getAppreciation());
            if (bestevennSet.size() < bestevennListe.size()){
                //da finnes det duplikat og vi må finne den som er repetert oftest
                String element = ""; 
                int count = 0; 
                for(int j = 0; j <bestevennListe.size(); j++){
                    String tempElement = bestevennListe.get(i); // elemente vi er på nå
                    int tempCount = 0; //for å telle elementene 
                    for( int p=0; p<bestevennListe.size(); p++ ){
                        if(bestevennListe.get(i).equals(tempElement)){ //går gjennom alle og sjekker om de er like til tempelement 
                            tempCount += 1; 
                        }
                    if ( tempCount > count){ // skjønner ikke helt dette, tror det lagrer tempElement some element hvis den har større count 
                        element = tempElement; 
                        count = tempCount; 
                    }
                    }
                results.add(element); 
                }
            }
            else{ // https://www.codegrepper.com/code-examples/java/picking+a+random+string+from+string+array+java
                //returner random person fra liste/set
                Random random = new Random(); /// importerer her random 
                int randomeNumber = random.nextInt(bestevennListe.size()); 
                // nextInt er en funskjon fra nett, litt usikker på hva den gjør men tror den bare sier ett tall i listen sin størrelse 
                String komplimentResult = bestevennListe.get(randomeNumber);
                // her finner vi da ett kompliment i listen 
                results.add(komplimentResult);         
            }


        // -- Utregning math --
        //andre funksjoner vi kan bruke igjen


        }
        return results;
    }
/* Kan vi gjøre det til mer generelle metoder??? 
    private void glassesToLiters(){
        
    }

    complimentsSorted()
    */




    public ArrayList<String> getResults() {
        return results;
    }
    
    //public String compliments(List complimentList){
        //få ordene fra listen inn i tooString
        //If-løkke: hvis få ord: kanskje du skal prøve gi flere komplementer, det gir glede å glede andre
        //hvis passe mengde: Vi kunne sagt det samme om deg, itillegg er du snil! 
        //shvis formye: Dette var litt vell mange komplimenter, husk at det kan virke falskt!
        //complimentList[i] 
    

    public static void main(String[] args) {
        Summary summary=new Summary();
        System.out.println(summary.getResults());
    }
}
