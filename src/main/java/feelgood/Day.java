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
    private String emoji;
    private float math;


    private ArrayList<Integer> vannListe = new ArrayList<Integer>();


//Konstruktør
public Day(int water){
    this.water=water;
    
}

//getter

public int getWater() {
    vannListe.add(water); 
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


public String getEmoji() {
    return emoji;
}


public float getMath() {
    return math;
}


public static void main(String[] args) {
    Day day1 = new Day(3);
    Day day2 = new Day(5); 
    System.out.println(Arrays.toString(vannListe.toArray()));
}
}