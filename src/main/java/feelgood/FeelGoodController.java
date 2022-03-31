package feelgood;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FeelGoodController {
    //overføres data fra fxml til variabler vi kan bruke i andre klasser
    //starte metoder i de andre klassene
    //som en main-metode
    // Trenger ikke konstruktør // Kobler opp FXML med controlleren 

    private Summary summary;
    private Day day;

    @FXML
    public TextField glassVann, komplement, timerSovn, verdigNavn, matteSum;

    
    public void initialize() {
        // Dette er på en måte konstruktøren vår -- kjører når appen starter opp
        summary = new Summary();

    }

    @FXML
    private void lagreSvar() {
        System.out.println("lagreSvar kjører");
        summary.add(glassVann.getText(), komplement.getText(), timerSovn.getText(), verdigNavn.getText(), matteSum.getText()); //henter info fra tekstfelt og sender til add().
        //summary.results.clear();
    }

    @FXML
    private void oppsummering(){
        System.out.println("oppsummering kjører");
        System.out.println(summary.calculations());
    }
    
}
