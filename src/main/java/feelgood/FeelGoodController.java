package feelgood;

import java.io.IOException;
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
    

    private FileReadWrite writeHandler = new FileDealer(); //gjør at vi kan bruke FileDealer klassen her
    private FileDealer filedealer = new FileDealer(); //*** dette er ikke interfacet, trenger vi begge??, hva gjør de...
    private int mathAnswer; //lagrer det riktige svaret til tilfeldig mattespørsmål i variabel
   


    @FXML
    public TextField glassVann, komplement, timerSovn, verdigNavn, matteSum, brukernavn; //importerer FXML-TextField-feltene

    @FXML
    private Text feedback, mathEquation; //importerer FXML-Text-feltene
    
    //metode som kjøres i det appen starter
    public void initialize(){
        matteStykke(); // generer mattestykke og setter tekstfeltet
    }
    

    // ***kan vi flytte logikken til en annen klasse? 
    //metode som finner de tilfeldige tallene til mattestykket og setter svaret som summen av disse
    @FXML
    public void matteStykke() { 
        Random random = new Random(); //importerer random-biblioteket
        int tall1 = random.nextInt(20)+1; //tilfeldig tall mellom 1 og 20
        int tall2 = random.nextInt(20)+1;
        int svar = tall1 + tall2; //svaret på stykket
        mathEquation.setText(tall1 + " + " + tall2); //setter svaret til mathEquation-Text-feltet
        this.mathAnswer = svar; //endrer mathAnswer variablen til det riktige svaret
    }


    //Henter brukernavnet fra "navn"-faltet og validerer dette. Returnerer filnavnet.
    private String getFilename(){
        String filename = this.brukernavn.getText().toLowerCase(); //henter filename/brukernavn fra TextField-feltet
        if (filename.length()<15 && !(filename.contains(" "))){ //sjekker at navne er kortere enn 15 bokstaver og ikke inneholder mellomrom 
            return filename; //returnerer filnavnet
        }
        else{
            throw new IllegalArgumentException("Brukernavnet kan kun bestå av ett ord. Det kan heller ikke være lengere enn 15 bokstaver.");
        }
    }


    //
    @FXML
    private void lagreSvar() throws IOException {
        System.out.println("lagreSvar kjører"); //til oss
        Summary summary = filedealer.readFile(getFilename()); //prøver å hente Summary-objekt fra fileDealer - blir enten et objekt eller null (hvis fil ikke eksisterer)
        Day newDay = null; //setter newDay til null

        try { //prøver å lage nytt Day-objekt med tekstfeltene fra FXML-filen
            newDay = new Day(Double.parseDouble(glassVann.getText()), komplement.getText(), Double.parseDouble(timerSovn.getText()), verdigNavn.getText(), Integer.parseInt(matteSum.getText()), this.mathAnswer);
        } catch(IllegalArgumentException e){ //feilmeldinger fra validering blir printet i ALERT-box hvis utløst
            Alert feilmelding = new Alert(AlertType.ERROR); //lager ALERT-box
            //feilmelding.setContentText(e.getMessage()); 
            feilmelding.setTitle("Feil"); 
            feilmelding.setHeaderText(e.getMessage());
            feilmelding.show();
        }

        if (newDay != null) { //hvis den klarte å lage ny Day-objekt
            if (summary == null) { //hvis det ikke finnes Summary-fil fra før av
                summary = new Summary(); //bruker har ikke en eksisterende fil - vi oppretter nytt summary objekt
            } 
            summary.add(newDay); //har eksisterende Summary-fil og legger derfor til Day-objektet newDay i summary
            writeHandler.writeFile(getFilename(), summary); //skriver newDay til fil
        }
        // reset GUI elements
        glassVann.clear(); komplement.clear(); timerSovn.clear(); verdigNavn.clear(); matteSum.clear(); // ***er det mulig å ikke cleare hvis feilmelding??
        matteStykke(); // generer nytt mattestykke

    }

    //viser tidligere dager i app når man trykker på "se tidligere"-knapp
    @FXML
    void handleRead() {
        System.out.println(writeHandler.readFile(getFilename()));
        //getTidligereDag();
        Summary summary = filedealer.readFile(getFilename()); //sjekker om fil finnes eller ikke ***skjønner ikke helt hva det betyr (summary)
        if (summary != null) { //hvis filen ekisterer
            feedback.setText(summary.toString()); //printes feedback i appen
        }
    }

    

    //viser oppsumering i app når man trykker på "få oppsumering" - knapp 
    @FXML
    private void oppsummering(){
        Summary summary = filedealer.readFile(getFilename()); // ***samme som i den over
        if (summary != null) { //hvis fil eksisterer
            System.out.println("oppsummering kjører"); //til terminal
            System.out.println(summary.calculations()); //til terminal 
            System.out.println(summary.motivationalMessage()); //til terminal
            feedback.setText(summary.motivationalMessage()); //melding til app 
            feedback.setFill(Color.BLUE); //skriftfarge blå 
        }
    }

  
    /*
    private void bilde(){
        Pane pane = new Pane();
        Image image = new Image("avatar.png");
        ImageView imageview = new ImageView(image);
        pane.getChildren().add(imageview);
        //imageview.setImage(image);
    }*/
}
