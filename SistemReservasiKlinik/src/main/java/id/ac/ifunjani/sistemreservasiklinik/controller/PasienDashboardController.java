package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.RekamMedis;
import id.ac.ifunjani.sistemreservasiklinik.model.Reservasi;
import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;
import id.ac.ifunjani.sistemreservasiklinik.util.UserSession;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PasienDashboardController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label idPasienLabel;
    @FXML
    private Label namaPasienLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField searchField;

    @FXML
    private TableView<Reservasi> reservasiTable;
    @FXML
    private TableColumn<Reservasi, String> colIdReservasi;
    @FXML
    private TableColumn<Reservasi, String> colTanggal;
    @FXML
    private TableColumn<Reservasi, String> colDokter;
    @FXML
    private TableColumn<Reservasi, String> colPoli;
    @FXML
    private TableColumn<Reservasi, String> colStatus;

    @FXML
    private TableView<RekamMedis> rekamTable;
    @FXML
    private TableColumn<RekamMedis, String> colIdRekam;
    @FXML
    private TableColumn<RekamMedis, String> colTglPeriksa;
    @FXML
    private TableColumn<RekamMedis, String> colKeluhan;
    @FXML
    private TableColumn<RekamMedis, String> colDiagnosa;

    public PasienDashboardController() {
    }

    @FXML
    public void initialize() {
        Pasien pasien = UserSession.getInstance().getPasien();

        if (pasien == null) {
            SceneManager.getInstance().switchScene("/id/ac/ifunjani/sistemreservasiklinik/view/login.fxml", "KlinikSehat Login");
            return;
        }

        welcomeLabel.setText("Selamat datang, " + pasien.getNamaLengkap());
        idPasienLabel.setText(pasien.getIdPasien());
        namaPasienLabel.setText(pasien.getNamaLengkap());

        setupColumns();
        loadData();
    }

    private void setupColumns() {
        colIdReservasi.setCellValueFactory(new PropertyValueFactory<>("idReservasi"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colDokter.setCellValueFactory(new PropertyValueFactory<>("namaDokter"));
        colIdRekam.setCellValueFactory(new PropertyValueFactory<>("idRekamMedis"));
        colTglPeriksa.setCellValueFactory(new PropertyValueFactory<>("tanggalPeriksa"));
        colKeluhan.setCellValueFactory(new PropertyValueFactory<>("keluhan"));
        colDiagnosa.setCellValueFactory(new PropertyValueFactory<>("diagnosa"));
    }

    private void loadData() {
        infoLabel.setText("Data berhasil dimuat (Dummy/Kosong).");
    }

    @FXML
    public void onRefresh() {
        loadData();
        infoLabel.setText("Data diperbarui.");
    }

    @FXML
    public void onBuatReservasi() {
        System.out.println("Tombol Buat Reservasi ditekan");
    }

    @FXML
    public void onDetailReservasi() {
        System.out.println("Tombol Detail Reservasi ditekan");
    }

    @FXML
    public void onBatalkanReservasi() {
        System.out.println("Tombol Batalkan Reservasi ditekan");
    }

    @FXML
    public void onDetailRekamMedis() {
        System.out.println("Tombol Detail Rekam Medis ditekan");
    }

    @FXML
    public void onLogout() {
        UserSession.getInstance().clearSession();
        SceneManager.getInstance().switchScene("/id/ac/ifunjani/sistemreservasiklinik/view/login.fxml", "KlinikSehat Login");
    }
}