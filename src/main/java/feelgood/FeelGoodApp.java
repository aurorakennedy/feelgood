package feelgood;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FeelGoodApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("FeelGood.inc"); //tittel på vinduet
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("fgApp.fxml")))); //sier at appen skal bruke "fgApp.fxml"
        primaryStage.show(); //viser vinduet
    }

}