package feelgood;

import javafx.fxml.FXML;

public class FeelGoodController {
    //overføres data fra fxml til variabler vi kan bruke i andre klasser
    //starte metoder i de andre klassene
    //som en main-metode

    @FXML
    private void calculateSleep() {
        // gjør faktisk utregning..
        System.out.println("calculating sleep");
    }
}
