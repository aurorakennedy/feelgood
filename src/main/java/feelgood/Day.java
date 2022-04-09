
package feelgood;

//Day- ta inn input, skrive til fil
public class Day {
    private double water;
    private String compliments;
    private double sleep;
    private String appreciation;
    private double math;
    //private Summary summary; 

/*
    public Day(String water, String compliments, String sleep, String appreciation, String math){
        this.water= Double.parseDouble(water);
        this.compliments = compliments; 
        this.sleep= Double.parseDouble(sleep);
        this.appreciation = appreciation;
        this.math= Double.parseDouble(math);
    }
    */

    public Day(String compliments, String appreciation){
        this.compliments = compliments; 
        this.appreciation = appreciation;
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
public double getMath() {
    return math;
}


}