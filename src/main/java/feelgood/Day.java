package feelgood;
//Day- 
public class Day {
    private double water;
    private String compliments;
    private double sleep;
    private String appreciation;
    private int math;
    private int actualAnswer;
    private boolean correctAnswer;


    public Day(double water, String compliments, double sleep, String appreciation, int math, int actualAnswer) throws IllegalArgumentException {
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
        if (math>(actualAnswer-3) && math<(actualAnswer+3)) {
            this.math= math;
            this.actualAnswer = actualAnswer;
            this.correctAnswer = (this.math == this.actualAnswer);
        } else{
            throw new IllegalArgumentException("Du får et forsøk til på mattestykket :)");
        } //Gjør ferdig når vi har fikset math stykket.
    }


// -- Gettere -- 

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
public int getMath() {
    return math;
}

public boolean getCorrectAnswer() {
    return this.correctAnswer;
}

//toString som brukes når Day-objekter skrives til fil
public String toString(){
    return (water + ", " + compliments + ", " + sleep  + ", " + appreciation  + ", " + math + ", " + actualAnswer);
}
}