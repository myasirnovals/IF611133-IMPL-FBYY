package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.*;
import id.ac.ifunjani.sistemreservasiklinik.service.StaffService;
import id.ac.ifunjani.sistemreservasiklinik.service.impl.StaffServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    private final StaffService staffService = new StaffServiceImpl();

    @FXML private Label lblNamaStaff, lblJumlahPasien, lblJumlahReservasi, lblJumlahDokter;

    @FXML private TableView<Reservasi> tblReservasi;
    @FXML private TableColumn<Reservasi, String> colResId, colResPasien, colResDokter, colResJadwal, colResStatus;

    @FXML private TableView<Pasien> tblPasien;
    @FXML private TableColumn<Pasien, String> colPasienNama, colPasienTelp;

    @FXML private TableView<Dokter> tblDokter;
    @FXML private TableColumn<Dokter, String> colDokterNama, colDokterSpesialis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDashboardData();
        setupTableReservasi();
        setupTablePasien();
        setupTableDokter();
    }

    private void loadDashboardData() {
        Staff currentStaff = staffService.getById("ST001");
        if (currentStaff != null) {
            lblNamaStaff.setText(currentStaff.getNama());
        }

        lblJumlahPasien.setText(String.valueOf(staffService.countPasien()));
        lblJumlahDokter.setText(String.valueOf(staffService.countDokter()));
        lblJumlahReservasi.setText(String.valueOf(staffService.countReservasi()));
    }

    private void setupTableReservasi() {
        colResId.setCellValueFactory(new PropertyValueFactory<>("idReservasi"));
        colResPasien.setCellValueFactory(new PropertyValueFactory<>("namaPasien"));
        colResDokter.setCellValueFactory(new PropertyValueFactory<>("namaDokter"));
        colResJadwal.setCellValueFactory(new PropertyValueFactory<>("infoJadwal"));
        colResStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        if (staffService.getAllReservasi() != null) {
            tblReservasi.getItems().setAll(staffService.getAllReservasi());
        }
    }

    private void setupTablePasien() {
        colPasienNama.setCellValueFactory(new PropertyValueFactory<>("namaLengkap"));
        colPasienTelp.setCellValueFactory(new PropertyValueFactory<>("noTelepon"));

        if (staffService.getAllPasien() != null) {
            tblPasien.getItems().setAll(staffService.getAllPasien());
        }
    }

    private void setupTableDokter() {
        colDokterNama.setCellValueFactory(new PropertyValueFactory<>("namaDokter"));
        colDokterSpesialis.setCellValueFactory(new PropertyValueFactory<>("spesialis"));

        if (staffService.getAllDokter() != null) {
            tblDokter.getItems().setAll(staffService.getAllDokter());
        }
    }
}