package feelgood;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;


public class FeelGoodController {

    private FileDealer filedealer = new FileDealer(); //gjør at vi kan bruke FileDealer-klassen her
    private int mathAnswer; //lagrer det riktige svaret til tilfeldig mattespørsmål i variabel
    private Person bruker; //gjør at vi kan bruke Person-klassen her
    
    @FXML
    private TextField glassVann, komplement, timerSovn, verdigNavn, matteSum, brukernavn; //importerer FXML-TextField-feltene
    @FXML
    private Text feedback, mathEquation, innloggingsKommentar, lagreKommentar; //importerer FXML-Text-feltene
    @FXML
    private Button lagreButton, oppsummeringButton, tidligereButton; //importerer FXML-button-feltene
    @FXML
    private Button waterSortButton, complimentsSortButton, sleepSortButton, appreciationSortButton;
    
    //metode som kjøres i det appen starter
    public void initialize(){ // Vil være public fordi den aldri blir kalt på andre steder i koden 

        matteStykke(); // generer mattestykke og setter det i tekstfeltet

        //inaktiverer alle knapper bortsett fra login og logut
        lagreButton.setDisable(true); oppsummeringButton.setDisable(true); tidligereButton.setDisable(true);

        //inaktiverer svarfeltene
        glassVann.setDisable(true); komplement.setDisable(true); timerSovn.setDisable(true); verdigNavn.setDisable(true); matteSum.setDisable(true);

        waterSortButton.setVisible(false); 
    
    }

    //metode som lager Alert-box med IllegalArgumentException som feilmelding
    private void alert(Exception e){
        Alert feilmelding = new Alert(AlertType.ERROR); //lager ALERT-box
        feilmelding.setHeaderText(e.getMessage()); //setter header-teksten i Alert-boksen til å være IllegalArgumentExceptionen som ble utløst
        feilmelding.show(); //viser Alert-boksen
    }

    
    //metode som finner de tilfeldige tallene til mattestykket og setter svaret som summen av disse
    @FXML
    private void matteStykke() { 
        Random random = new Random(); //importerer random-biblioteket
        int tall1 = random.nextInt(20)+1; //tilfeldig tall mellom 1 og 20
        int tall2 = random.nextInt(20)+1;
        int svar = tall1 + tall2; //svaret på stykket
        mathEquation.setText(tall1 + " + " + tall2); //setter stykket med tilfeldige tall til mathEquation-Text-feltet
        this.mathAnswer = svar; //endrer mathAnswer variablen til det riktige svaret
    }

    
    //metode som lager setter Person-objekt med brukernavnet som er oppgitt, gråer ut/aktiverer felter når login-knappen trykkes
    public void login(){ // Vil være public fordi den aldri blir kalt på andre steder i koden 
        String username = brukernavn.getText().toLowerCase(); //lagrer brukernavn-feltet i fxml som username-variabel
        Summary summary = null;
        try {
            //vi leser et summary fra fil
             summary = filedealer.readFile(username); //lager Summary-objekt ved å lese filen til brukernavnet
        } catch (FileNotFoundException e){ // oops, fant ikke noe summary på fil
            summary = new Summary(); //lager nytt Summary-objekt
        }

        try{ 
            this.bruker = new Person(username, summary); //lager Person-objekt med brukernavnet og summaryen som lages over
            
            brukernavn.setDisable(true); //inaktiverer brukernavvn-feltet
            innloggingsKommentar.setText("Du er logget inn som " + bruker.getName()); //setter kommentar under feltet som forteller brukeren at de er logget inn

            //gjør knappene tilgjengelige
            lagreButton.setDisable(false); oppsummeringButton.setDisable(false); tidligereButton.setDisable(false);

            //gjør svarfeltene tilgjengelige
            glassVann.setDisable(false); komplement.setDisable(false); timerSovn.setDisable(false); verdigNavn.setDisable(false); matteSum.setDisable(false);
        }
        catch (IllegalArgumentException e){ //hvis det ikke gikk an å gjøre alt i try
            alert(e);
        }
    }

    //metode som clearer og inaktiverer felter når det logges ut
    public void logout(){ // Vil være public fordi den aldri blir kalt på andre steder i koden 
        brukernavn.clear(); //clearer brukernavn-feltet
        brukernavn.setDisable(false); //aktiverer brukernavn-feltet
        innloggingsKommentar.setText("Du er logget ut."); //kommenterer under feltet

        //clearer alle svarfeltene og feedbackfeltet
        glassVann.clear(); komplement.clear(); timerSovn.clear(); verdigNavn.clear(); matteSum.clear();
        feedback.setText("");//fjerner teksten i feedback-feltet

        //inaktiverer knappene og svarfeltene
        lagreButton.setDisable(true); oppsummeringButton.setDisable(true); tidligereButton.setDisable(true);
        glassVann.setDisable(true); komplement.setDisable(true); timerSovn.setDisable(true); verdigNavn.setDisable(true); matteSum.setDisable(true);
        waterSortButton.setVisible(false);

    }

    //lager et Day-objekt som lagres i fil når man trykker på "lagre svar"-knappen
    @FXML
    private void lagreSvar() throws IOException { 
        Day newDay = null; //setter newDay til null

        try { //prøver å lage nytt Day-objekt med tekstfeltene fra FXML-filen
            newDay = new Day(Double.parseDouble(glassVann.getText().replace(',', '.')), komplement.getText(), Double.parseDouble(timerSovn.getText().replace(',', '.')), verdigNavn.getText().replace(",", " og "), Integer.parseInt(matteSum.getText()), this.mathAnswer);
            //clearer svarfeltene
            glassVann.clear(); komplement.clear(); timerSovn.clear(); verdigNavn.clear(); matteSum.clear(); // ***er det mulig å ikke cleare hvis feilmelding??
            lagreKommentar.setText("Svaret er lagret. Du kan nå registrere en dag til, se oppsummering eller se tidligere føringer."); //kommenterer under knappen
            matteStykke(); // generer nytt mattestykke
        } catch(IllegalArgumentException e){ //feilmeldinger fra validering blir printet i ALERT-box hvis utløst
            alert(e);
        }

        //lager ny fil for personer som ikke finnes fra før av (ved å kalle på writeFile())
        if (newDay != null) { //hvis den klarte å lage nytt Day-objekt 
            bruker.getSummary().add(newDay); //har eksisterende Summary-fil og legger derfor til Day-objektet newDay i summary
            filedealer.writeFile(bruker.getName(), bruker.getSummary()); //skriver newDay til fil
        }
    }

    //viser oppsumering i app når man trykker på "få oppsumering" - knapp 
    @FXML
    private void oppsummering(){ 
        Summary summary = this.bruker.getSummary(); // henter den oppdaterte summary-en
        feedback.setText(summary.motivationalMessage(this.bruker.getName())); //melding til app 
        waterSortButton.setVisible(false);

    }

    //viser alle day-objektene i Summary når man trykker på "se tidligere"-knapp
    @FXML
    private void seTidligere() {
        Summary summary = null;
        try {
            summary = filedealer.readFile(bruker.getName());
        } catch (FileNotFoundException e) {
            
            alert(e);
        } //sjekker om fil finnes eller ikke ***skjønner ikke helt hva det betyr (summary)
        if (summary != null) { //hvis filen ekisterer
            feedback.setText(summary.tidligereString()); //printes feedback i appen
        }
        waterSortButton.setVisible(true);
    }


    //dette hører til Comparator forsøket mitt funksjonelt grensesnitt
    @FXML
    private void waterSort(){
        feedback.setText(bruker.getSummary().sortDays(new WaterComparator()));
    }
    @FXML
    private void complimentsSort(){
        feedback.setText(bruker.getSummary().sortDays(new ComplimentComparator()));
    }
}
