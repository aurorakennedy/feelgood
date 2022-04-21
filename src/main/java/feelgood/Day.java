
package feelgood;

import java.time.LocalDate;
import java.time.LocalDateTime;

//Day- ta inn input, skrive til fil
public class Day {
    private double water;
    private String compliments;
    private double sleep;
    private String appreciation;
    private double math;
    //private Summary summary; 


    public Day(double water, String compliments, double sleep, String appreciation, double math) throws IllegalArgumentException {
        // input validering med IllegalArgumentException
        if (water >= 0 && water <=50) {
            this.water = water;
        } else{
            throw new IllegalArgumentException("Ikke realistisk mengde vann.");
        }
        if (compliments.length()>2) {
            this.compliments=compliments;
        } else{
            throw new IllegalArgumentException("Du må skrive minimum et komplement.");
        }
        if (sleep>=0 && sleep<24) {
            this.sleep= sleep;
        } else{
            throw new IllegalArgumentException("Det er ikke mulig å sove i mindre enn 0 timer eller mer enn 24 timer på et døgn.");
        }
        if (appreciation.length()>1 && appreciation.length()<15) {
            this.appreciation = appreciation;
        } else{
            throw new IllegalArgumentException("Navnet du har oppgitt er enten for kort eller for langt.");
        }
        /*if (math.equals(27)) {
            this.math= math;
        } else{
            throw new IllegalArgumentException("Du får et forsøk til på mattestykket :)");
        }*/ //Gjør ferdig når vi har fikset math stykket.
    }


// -- Gettere -- 

public String toString(){
    return (water + ", " + compliments + ", " + sleep  + ", " + appreciation  + ", " + math);
}

public double getWater(){
    return water;
}
public String getCompliments() {
    return compliments;
}
public double getSleep() {
    return sleep;
}
public String getAppreciation() {
    return appreciation;
}
public double getMath() {
    return math;
}


}