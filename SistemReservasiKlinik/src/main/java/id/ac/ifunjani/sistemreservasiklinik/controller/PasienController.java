package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private TextField txtPassword;
    
    PasienRepository repo = new PasienRepository();
    
    @FXML
    private void handleDaftar() {
        try {
            String nama = txtNama.getText();
            String alamat = txtAlamat.getText();
            String tglStr = txtTglLahir.getText();
            String telp = txtNoTelp.getText();
            String pass = txtPassword.getText();
            
            if (nama.isEmpty() || tglStr.isEmpty()) {
                menampilkanPesan("Isi dulu datanya!", Alert.AlertType.WARNING);
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
            
            repo.save(p);
            menampilkanPesan("Registrasi Berhasil!", Alert.AlertType.INFORMATION);
            
            txtNama.setText("");
            txtAlamat.setText("");
            txtTglLahir.setText("");

        } catch (Exception e) {
            menampilkanPesan("Gagal! Cek format tanggal (YYYY-MM-DD)", Alert.AlertType.ERROR);
        }
    }
    
    private void menampilkanPesan(String pesan, Alert.AlertType tipe) {
        Alert alert = new Alert(tipe);
        alert.setContentText(pesan);
        alert.show();
    }
}