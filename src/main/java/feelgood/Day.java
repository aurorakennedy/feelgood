package feelgood;

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
        if (compliments.length()>2 && !compliments.contains(",")) {
            this.compliments=compliments;
        } else{
            throw new IllegalArgumentException("Ikke gyldig komplement. Kan ikke inneholde komma eller være kortere enn 2 bokstaver.");
        }
        if (sleep>=0 && sleep<24) {
            this.sleep= sleep;
        } else{
            throw new IllegalArgumentException("Det er ikke mulig å sove i mindre enn 0 timer eller mer enn 24 timer på et døgn.");
        }
        if (appreciation.length()>1) {
            this.appreciation = appreciation;
        } else{
            throw new IllegalArgumentException("Navnet på personen du har satt pris må bestå av minimum 2 bokstaver. ");
        }
        if (math>(actualAnswer-3) && math<(actualAnswer+3)) {
            this.math= math;
            this.actualAnswer = actualAnswer;
            this.correctAnswer = (this.math == this.actualAnswer); //setter correktAnswer til true hvis math og actualAnswer er like
        } else{
            throw new IllegalArgumentException("Du får et forsøk til på mattestykket :)");
        }
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
        return appreciation.toLowerCase(); // Gjør alle bokstavene til små i verdsatte navn 
    }
    public int getMath() {
        return math;
    }
    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    //toString som brukes når Day-objekter skrives til fil
    @Override
    public String toString(){
        return (water + ", " + compliments + ", " + sleep  + ", " + appreciation  + ", " + math + ", " + actualAnswer);
    }

    // Equals metoden for FileDealer testen
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Sjekker at det er dette samme objekt, (aka, Day - objektet)
            return true;
        if (obj == null) // Hvis objekte er null vet vi at det ikke er det samme, returnerer fals
            return false;
        if (getClass() != obj.getClass()) // Hvis klassen ikke er like vet vi at de ikke er like 
            return false;
        Day other = (Day) obj; // Kan trygt gjøre en cast, fordi vi sjekker over at de begge er i day klassen
       
        // Sammenligner alle feltene, blir returnert fals hvis noen av de ikke er like. 
        if (actualAnswer != other.actualAnswer) 
            return false;
        if (appreciation == null) {
            if (other.appreciation != null)
                return false;
        } else if (!appreciation.equals(other.appreciation))
            return false;
        if (compliments == null) {
            if (other.compliments != null)
                return false;
        } else if (!compliments.equals(other.compliments))
            return false;
        if (correctAnswer != other.correctAnswer)
            return false;
        if (math != other.math)
            return false;
        if (Double.doubleToLongBits(sleep) != Double.doubleToLongBits(other.sleep))
            return false;
        if (Double.doubleToLongBits(water) != Double.doubleToLongBits(other.water))
            return false;
        return true;
    }
    
}

