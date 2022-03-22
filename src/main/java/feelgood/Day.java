
package feelgood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Day- ta inn input, skrive til fil
public class Day {
    private int water;
    private String compliments;
    private double sleep;
    private String appreciation;
    private float math;


    private ArrayList<Integer> vannListe = new ArrayList<Integer>();


//Konstruktør
public Day(int water){
    this.water=water;
    vannListe.add(water); 
}

//getter

public int getWater(){
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


public float getMath() {
    return math;
}

  @Override
    public String toString() {
        return String.valueOf(vannListe); 
    }

public static void main(String[] args) {
    Day day1 = new Day(3);
    Day day2 = new Day(5); 
    System.out.println(day1);
    System.out.println(day2);
}
}