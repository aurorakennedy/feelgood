
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
    private LocalDate timeStamp;
    private String test1; 
    private String test2;
    private String test3;  
    //private Summary summary; 


    public Day(String water, String compliments, String sleep, String appreciation, String math){
        this.water= Double.parseDouble(water);
        this.compliments = compliments; 
        this.sleep= Double.parseDouble(sleep);
        this.appreciation = appreciation;
        this.math= Double.parseDouble(math);
    }
    

    /*
    public Day(String compliments, String appreciation, String test1, String test2, String test3){
        this.compliments = compliments; 
        this.appreciation = appreciation;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;

        //this.timeStamp = java.time.LocalDate.now(); 
    }
    */
// -- Gettere -- 

public String toString(){
    return (water + ", " + compliments + ", " + sleep  + ", " + appreciation  + ", " + math);  // + ", " + timeStamp);
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