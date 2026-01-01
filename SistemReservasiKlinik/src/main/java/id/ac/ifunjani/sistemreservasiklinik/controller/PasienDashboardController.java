package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.RekamMedis;
import id.ac.ifunjani.sistemreservasiklinik.repository.RekamMedisRepository;
import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;
import id.ac.ifunjani.sistemreservasiklinik.util.UserSession;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class PasienDashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private TableView<RekamMedis> rekamMedisTable;

    @FXML
    private TableColumn<RekamMedis, String> colTanggal;

    @FXML
    private TableColumn<RekamMedis, String> colKeluhan;

    @FXML
    private TableColumn<RekamMedis, String> colDiagnosa;

    @FXML
    private TableColumn<RekamMedis, String> colDokter;

    private RekamMedisRepository rekamMedisRepository = new RekamMedisRepository();
    private Pasien currentPasien;

    @FXML
    public void initialize() {
        Pasien pasienAktif = UserSession.getInstance().getPasien();

        if (pasienAktif != null) {
            this.currentPasien = pasienAktif;
            welcomeLabel.setText("Selamat datang, Sdr/i " + pasienAktif.getNamaLengkap());

            setupColumns();
            loadData(pasienAktif.getIdPasien());
        } else {
            welcomeLabel.setText("Error: User belum login");
        }
    }

    private void setupColumns() {
        colTanggal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTanggalPeriksa().toString()));
        colKeluhan.setCellValueFactory(new PropertyValueFactory<>("keluhan"));
        colDiagnosa.setCellValueFactory(new PropertyValueFactory<>("diagnosa"));
        colDokter.setCellValueFactory(new PropertyValueFactory<>("idDokter"));
    }

    private void loadData(String idPasien) {
        List<RekamMedis> listRekamMedis = rekamMedisRepository.findByPasienId(idPasien);
        ObservableList<RekamMedis> data = FXCollections.observableArrayList(listRekamMedis);

        rekamMedisTable.setItems(data);
    }

    @FXML
    private void handleLogout() {
        UserSession.getInstance().clearSession();
        SceneManager.getInstance().switchScene("/id/ac/ifunjani/sistemreservasiklinik/view/login.fxml");
    }
}