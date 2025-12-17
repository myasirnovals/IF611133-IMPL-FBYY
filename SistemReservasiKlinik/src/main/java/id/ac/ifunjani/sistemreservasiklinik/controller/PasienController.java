package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.service.PasienService;
import id.ac.ifunjani.sistemreservasiklinik.service.impl.PasienServiceImpl;
import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.UUID;

public class PasienController {

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtAlamat;

    @FXML
    private TextField txtTglLahir;

    @FXML
    private TextField txtNoTelp;

    @FXML
    private PasswordField txtPassword;
    private PasienService service = new PasienServiceImpl();

    @FXML
    private void handleDaftar() {
        try {
            String nama = txtNama.getText();
            String alamat = txtAlamat.getText();
            String tglStr = txtTglLahir.getText();
            String telp = txtNoTelp.getText();
            String pass = txtPassword.getText();

            if (nama.isEmpty() || tglStr.isEmpty()) {
                menampilkanPesan("Isi terlebih dahulu datanya!", Alert.AlertType.WARNING);
                return;
            }

            String idBaru = UUID.randomUUID().toString();

            Pasien p = new Pasien();
            p.setIdPasien(idBaru);
            p.setNamaLengkap(nama);
            p.setAlamat(alamat);
            p.setNoTelepon(telp);
            p.setPassword(pass);
            p.setTanggalLahir(LocalDate.parse(tglStr));

            boolean sukses = service.daftarPasien(p);

            if (sukses) {
                menampilkanPesan("Registrasi Berhasil! Silahkan Login.", Alert.AlertType.INFORMATION);

                SceneManager.getInstance().switchScene("/fxml/login.fxml");
            } else {
                menampilkanPesan("Gagal menyimpan data.", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            menampilkanPesan("Gagal! Cek format tanggal (YYYY-MM-DD)", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleKembaliLogin() {
        SceneManager.getInstance().switchScene("/fxml/login.fxml");
    }

    private void menampilkanPesan(String pesan, Alert.AlertType tipe) {
        Alert alert = new Alert(tipe);
        alert.setContentText(pesan);
        alert.show();
    }
}