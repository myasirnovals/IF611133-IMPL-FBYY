package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.PasienService;
import id.ac.ifunjani.sistemreservasiklinik.service.impl.PasienServiceImpl;
import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class RegisterPasienController {

    @FXML
    private TextField idField;

    @FXML
    private TextField namaField;

    @FXML
    private TextArea alamatArea;

    @FXML
    private DatePicker tglLahirPicker;

    @FXML
    private TextField telpField;

    @FXML
    private PasswordField passwordField;

    private final PasienService pasienService;

    public RegisterPasienController() {
        this.pasienService = new PasienServiceImpl(new PasienRepository());
    }

    @FXML
    public void onDaftar() {
        String id = idField.getText();
        String nama = namaField.getText();
        String alamat = alamatArea.getText();
        LocalDate tglLahir = tglLahirPicker.getValue();
        String telp = telpField.getText();
        String pass = passwordField.getText();

        if (id == null || id.isEmpty() ||
                nama == null || nama.isEmpty() ||
                pass == null || pass.isEmpty() ||
                tglLahir == null) {

            showAlert(Alert.AlertType.ERROR, "Error",
                    "Harap isi semua field wajib (ID, Nama, Tgl Lahir, Password)!");
            return;
        }

        try {
            Pasien pasienBaru = pasienService.registerPasien(
                    id, nama, alamat, tglLahir, telp, pass
            );

            if (pasienBaru != null) {
                showAlert(Alert.AlertType.INFORMATION, "Sukses",
                        "Registrasi berhasil! Silakan login.");
                onBack();
            } else {
                showAlert(Alert.AlertType.ERROR, "Gagal",
                        "Registrasi gagal. ID pasien '" + id + "' sudah terdaftar.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Terjadi kesalahan sistem: " + e.getMessage());
        }
    }

    @FXML
    public void onBack() {
        SceneManager.getInstance().switchScene(
                "/id/ac/ifunjani/sistemreservasiklinik/view/login.fxml",
                "KlinikSehat Login"
        );
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}