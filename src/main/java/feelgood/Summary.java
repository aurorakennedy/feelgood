package feelgood;
//lese fra fil, gjøre beregninger, output
public class Summary implements Day {
    public void vannListe; 


    public float adderVann(List vannListe){    
        //int glassVann = 0; 

        for (int i; vannListe; i++){  // i - indkes i listen, som forteller oss antall glass per dag 
            int glassVann += i; 
        }
        
        float literVann = glassVann*0,2;

        return glassVann; 
        return literVann; 
    }

    public String compliments(List complimentList){
        //få ordene fra listen inn i tooString
        //If-løkke: hvis få ord: kanskje du skal prøve gi flere komplementer, det gir glede å glede andre
        //hvis passe mengde: Vi kunne sagt det samme om deg, itillegg er du snil! 
        //shvis formye: Dette var litt vell mange komplimenter, husk at det kan virke falskt!
        //complimentList[i] 
    }
    
    
}
