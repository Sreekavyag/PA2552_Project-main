package se.bth.pa2552_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import java.io.IOException;
import java.util.Locale;

// This is our converter application, and is our main entry point.
// It loads in the scene, a style sheet, and fetches the inputs,
// buttons and labels from the fxml file and MainScreenController.

public class UnitConverterApplication extends Application {
    public void start(Stage stage) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        FXMLLoader fxmlLoader = new FXMLLoader(UnitConverterApplication.class.getResource("main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 400);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Unit Converter");
        stage.setScene(scene);
        stage.show();
    }
}
