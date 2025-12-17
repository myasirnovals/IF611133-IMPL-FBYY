package id.ac.ifunjani.sistemreservasiklinik;

import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstance().setStage(primaryStage);
        primaryStage.setTitle("Aplikasi Klinik Sehat");
        SceneManager.getInstance().switchScene("/fxml/login.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
