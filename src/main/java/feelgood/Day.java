
package feelgood;

//Day- ta inn input, skrive til fil
public class Day {
    private double water;
    private String compliments;
    private double sleep;
    private String appreciation;
    private double math;
    private Summary summary; 
    

//getter&settere

public void setWater(double water) {
    //validering
    this.water = water;
    summary.addWater(water);
}

public double getWater(){
    return water;
}


public void setCompliments(String compliments) {
    //validering
    this.compliments = compliments;
    //summary.addCompliments(water);
}
public String getCompliments() {
    
    return compliments;
}


public void setSleep(double sleep) {
    this.sleep = sleep;
}

public double getSleep() {
    return sleep;
}



public void setAppreciation(String appreciation) {
    this.appreciation = appreciation;
}
public String getAppreciation() {
    return appreciation;
}



public void setMath(double math) {
    this.math = math;
}
public double getMath() {
    return math;
}


}