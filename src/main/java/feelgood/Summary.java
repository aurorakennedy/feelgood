package feelgood;

import java.util.ArrayList;

//lese fra fil, gjøre beregninger, output
public class Summary {

     private ArrayList<Double> waterList = new ArrayList<Double>();


    public void addWater(double water){    // Add water to list 
        waterList.add(water); 
    }


    public double summaryWater(){     // Gjør utregningen med vann
        double glassesOfWater = 0; 
        double litersOfWater; 

        for (int i=0; i < waterList.size(); i++){  // i - indkes i listen, som forteller oss antall glass per dag 
             glassesOfWater += i; 
        }
        
        litersOfWater = glassesOfWater*0.2; // f gjør 0.2 (var en double) til en float 

        return litersOfWater;
    }

    public ArrayList<Double> getWaterList() {
        return waterList;
    }
    
    //public String compliments(List complimentList){
        //få ordene fra listen inn i tooString
        //If-løkke: hvis få ord: kanskje du skal prøve gi flere komplementer, det gir glede å glede andre
        //hvis passe mengde: Vi kunne sagt det samme om deg, itillegg er du snil! 
        //shvis formye: Dette var litt vell mange komplimenter, husk at det kan virke falskt!
        //complimentList[i] 
    

    public static void main(String[] args) {
        Summary summary=new Summary();
        System.out.println(summary.getWaterList());
    }
}
