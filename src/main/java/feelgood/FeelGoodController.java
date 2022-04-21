package feelgood;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FeelGoodController {
    //overføres data fra fxml til variabler vi kan bruke i andre klasser
    //starte metoder i de andre klassene
    //som en main-metode
    // Trenger ikke konstruktør // Kobler opp FXML med controlleren 

    private Summary summary;
    private FileReadWrite writeHandler = new FileDealer(); 
    private Day day;
    private ArrayList<Day> allDays = new ArrayList<>(); 

    private FileDealer filedealer; 
    private int mathAnswer;
   


    @FXML
    public TextField glassVann, komplement, timerSovn, verdigNavn, matteSum, brukernavn;

    @FXML
    private Text feedback, mathEquation;
    
    
    
    public void initialize() {
        // Dette er på en måte konstruktøren vår -- kjører når appen starter opp
        summary = new Summary(); // generer summary tracker
        matteStykke(); // generer mattestykke og sett tekstfelt

    }

    @FXML
    public void matteStykke() { 
        Random random = new Random();
        int tall1 = random.nextInt(20)+1; //tilfeldig tall mellom 1 og 20
        int tall2 = random.nextInt(20)+1;
        int svar = tall1 + tall2;
        mathEquation.setText(tall1 + " + " + tall2);
        this.mathAnswer = svar;
    }



    private String getFilename(){
        String filename = this.brukernavn.getText().toLowerCase();
        if (filename.length()<15 && !(filename.contains(" "))){
            return filename;
        }
        else{
            throw new IllegalArgumentException("Brukernavnet kan kun bestå av ett ord. Det kan heller ikke være lengere enn 15 bokstaver.");
        }
    }


    @FXML
    private void lagreSvar() throws IOException {
        System.out.println("lagreSvar kjører");
        try{
            Day newDay = new Day(Double.parseDouble(glassVann.getText()), komplement.getText(), Double.parseDouble(timerSovn.getText()), verdigNavn.getText(), Integer.parseInt(matteSum.getText()), this.mathAnswer);
            summary.add(newDay); //henter info fra tekstfelt og sender til add().
            allDays.add(newDay);
            writeHandler.writeFile(getFilename(), allDays);
        } catch(IllegalArgumentException e){
            Alert feilmelding = new Alert(AlertType.ERROR);
            //feilmelding.setContentText(e.getMessage());
            feilmelding.setTitle("Feil");
            feilmelding.setHeaderText(e.getMessage());
            feilmelding.show();
        }
        // reset GUI elements
        glassVann.clear(); komplement.clear(); timerSovn.clear(); verdigNavn.clear(); matteSum.clear();
        allDays.clear();
        matteStykke(); // generer nytt mattestykke

    }

    @FXML
    void handleRead(){
        allDays = writeHandler.readFile(getFilename()); 
        //System.out.println(writeHandler.readFile(getFilename()));
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

    private void bilde(){
        Pane pane = new Pane();
        Image image = new Image("avatar.png");
        ImageView imageview = new ImageView(image);
        pane.getChildren().add(imageview);
        //imageview.setImage(image);
    }

}
