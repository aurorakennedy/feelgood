package feelgood;
//Day- ta inn input, skrive til fil
public class Day {
    private int water;
    private String compliments;
    private double sleep;
    private String appreciation;
    private String emoji;
    private float math;


//Konstruktør
public Day(int water){
    this.water=water;
}

//getter

public int getWater() {
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


}