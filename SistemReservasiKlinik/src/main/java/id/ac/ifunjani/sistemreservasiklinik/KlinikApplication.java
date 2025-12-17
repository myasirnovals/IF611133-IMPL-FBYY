package id.ac.ifunjani.sistemreservasiklinik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KlinikApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KlinikApplication.class.getResource("/view/dashboard-staff.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1024, 768); // Ukuran window
        stage.setTitle("Sistem Reservasi Klinik - Dashboard Staff");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}