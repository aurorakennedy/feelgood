package feelgood;

public class FeelGoodController {
    //overføres data fra fxml til variabler vi kan bruke i andre klasser
    //starte metoder i de andre klassene
    //som en main-metode

    private FeelGoodApp feelGoodApp;  //Kan hende det skal være day og person her ikke Feelgoodapp

    // Kobler opp FXML med controlleren 

    @FXML 
    public idNavnHer itemNavn; //Bytt ut med id 

    // Trenger ikke konstruktør 
    
    public void initialize() {
        // Dette er på en måte konstruktøren vår -- kjører når appen starter opp
    }


}
