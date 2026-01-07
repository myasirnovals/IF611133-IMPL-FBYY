package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import id.ac.ifunjani.sistemreservasiklinik.repository.DokterRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.StaffRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.AuthService;
import id.ac.ifunjani.sistemreservasiklinik.service.impl.AuthServiceImpl;
import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;
import id.ac.ifunjani.sistemreservasiklinik.util.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ComboBox<String> roleCombo;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private final AuthService authService;

    public LoginController() {
        this.authService = new AuthServiceImpl(
                new PasienRepository(),
                new DokterRepository(),
                new StaffRepository()
        );
    }

    @FXML
    public void initialize() {
        if (roleCombo.getValue() == null) {
            roleCombo.setValue("Pasien");
        }
    }

    @FXML
    public void onLogin() {
        String role = roleCombo.getValue();
        String id = idField.getText();
        String password = passwordField.getText();

        if (id.isEmpty() || password.isEmpty()) {
            errorLabel.setText("ID dan password wajib diisi.");
            return;
        }

        if ("Pasien".equalsIgnoreCase(role)) {
            Pasien pasien = authService.loginPasien(id, password);
            if (pasien == null) {
                errorLabel.setText("ID atau password pasien tidak sesuai.");
                return;
            }

            UserSession.getInstance().setPasien(pasien);

            SceneManager.getInstance().switchScene(
                    "/id/ac/ifunjani/sistemreservasiklinik/view/dashboard_pasien.fxml",
                    "Dashboard Pasien"
            );

        } else if ("Dokter".equalsIgnoreCase(role)) {
            Dokter dokter = authService.loginDokter(id, password);
            if (dokter == null) {
                errorLabel.setText("Dokter tidak ditemukan atau password salah.");
                return;
            }

            UserSession.getInstance().setDokter(dokter);

            SceneManager.getInstance().switchScene(
                    "/id/ac/ifunjani/sistemreservasiklinik/view/dashboard_dokter.fxml",
                    "Dashboard Dokter"
            );

        } else if ("Staff".equalsIgnoreCase(role)) {
            Staff staff = authService.loginStaff(id, password);
            if (staff == null) {
                errorLabel.setText("ID atau password staff tidak sesuai.");
                return;
            }

            UserSession.getInstance().setStaff(staff);

            SceneManager.getInstance().switchScene(
                    "/id/ac/ifunjani/sistemreservasiklinik/view/dashboard_staff.fxml",
                    "Dashboard Staff"
            );
        }
    }

    @FXML
    public void onRegisterPasien() {
        SceneManager.getInstance().switchScene(
                "/id/ac/ifunjani/sistemreservasiklinik/view/register_pasien.fxml",
                "Registrasi Pasien"
        );
    }
}