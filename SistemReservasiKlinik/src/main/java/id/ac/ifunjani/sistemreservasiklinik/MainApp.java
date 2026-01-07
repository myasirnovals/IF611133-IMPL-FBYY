package id.ac.ifunjani.sistemreservasiklinik;

import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstance().setStage(primaryStage);
        primaryStage.setTitle("Aplikasi Klinik Sehat");
        SceneManager.getInstance().switchScene("/id/ac/ifunjani/sistemreservasiklinik/view/", "KlinikSehat Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
