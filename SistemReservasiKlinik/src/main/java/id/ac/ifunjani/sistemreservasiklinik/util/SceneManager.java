package id.ac.ifunjani.sistemreservasiklinik.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {
    private static SceneManager instance;
    private Stage stage;
    
    private SceneManager() {}

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void switchScene(String fxmlPath, String klinikSehatLogin) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            if (stage.getScene() == null) {
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } else {
                stage.getScene().setRoot(root);
            }

            stage.show();
            stage.centerOnScreen();

        } catch (IOException e) {
            System.out.println("Gagal pindah scene ke: " + fxmlPath);
            e.printStackTrace();
        }
    }
}