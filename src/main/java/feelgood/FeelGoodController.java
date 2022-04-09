package feelgood;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FeelGoodController {
    //overføres data fra fxml til variabler vi kan bruke i andre klasser
    //starte metoder i de andre klassene
    //som en main-metode
    // Trenger ikke konstruktør // Kobler opp FXML med controlleren 

    private Summary summary;
    private FileDealer filedealer; 
    private Day day;


    @FXML
    public TextField glassVann, komplement, timerSovn, verdigNavn, matteSum, brukernavn;

    @FXML
    private Text feedback;
    
    
    
    public void initialize() {
        // Dette er på en måte konstruktøren vår -- kjører når appen starter opp
        summary = new Summary();

    }

    private String getFilename(){
        String filename = this.brukernavn.getText();
        return filename; 
    }

    @FXML
    private void lagreSvar() {
        System.out.println("lagreSvar kjører");
        summary.add(glassVann.getText(), komplement.getText(), timerSovn.getText(), verdigNavn.getText(), matteSum.getText()); //henter info fra tekstfelt og sender til add().
        glassVann.clear(); komplement.clear(); timerSovn.clear(); verdigNavn.clear(); matteSum.clear();
        
        
    }

    //** Kaos her nå men det er fordi funksjonen i FileDealer ikke er på plass */
    @FXML
    private void checkFile(){
        System.out.println("Fil kjører, bra!");
        System.out.println(getFilename());
        // filNavn = brukernavn.getText();
        //filedealer.finnFil(brukernavn.getText());
        //filedealer.finnFil("Aurora");
        //filedealer.readFile(brukernavn.getText());
    }

    @FXML
    private void oppsummering(){
        System.out.println("oppsummering kjører");
        System.out.println(summary.calculations());
        System.out.println(summary.motivationalMessage());
        giResultat();
        summary = new Summary();
    }

    private void giResultat(){
        // Alert oppsummering = new Alert(AlertType.INFORMATION);
        // oppsummering.setTitle("Du er best");
        // oppsummering.setHeaderText(null);
        // oppsummering.show();
        // oppsummering.setContentText(summary.motivationalMessage());
        feedback.setText(summary.motivationalMessage());
        feedback.setFill(Color.BLUE);

    }
    
}
