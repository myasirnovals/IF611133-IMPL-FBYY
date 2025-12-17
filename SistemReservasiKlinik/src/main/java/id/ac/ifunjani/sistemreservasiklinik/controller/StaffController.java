package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Reservasi;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import id.ac.ifunjani.sistemreservasiklinik.service.StaffService;
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

    @FXML private Label lblNamaStaff;
    @FXML private Label lblJumlahPasien;
    @FXML private Label lblJumlahReservasi;
    @FXML private Label lblJumlahDokter;

    @FXML private TableView<Reservasi> tblReservasi;
    @FXML private TableColumn<Reservasi, String> colResId;
    @FXML private TableColumn<Reservasi, String> colResPasien;
    @FXML private TableColumn<Reservasi, String> colResDokter;
    @FXML private TableColumn<Reservasi, String> colResJadwal;
    @FXML private TableColumn<Reservasi, String> colResStatus;

    @FXML private TableView<Pasien> tblPasien;
    @FXML private TableColumn<Pasien, String> colPasienNama;
    @FXML private TableColumn<Pasien, String> colPasienTelp;

    @FXML private TableView<Dokter> tblDokter;
    @FXML private TableColumn<Dokter, String> colDokterNama;
    @FXML private TableColumn<Dokter, String> colDokterSpesialis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Staff currentStaff = staffService.getById("ST001");
        if (currentStaff != null) {
            lblNamaStaff.setText(currentStaff.getNama());
        }

        lblJumlahPasien.setText(String.valueOf(staffService.countPasien()));
        lblJumlahDokter.setText(String.valueOf(staffService.countDokter()));
        lblJumlahReservasi.setText(String.valueOf(staffService.countReservasi()));

        colResId.setCellValueFactory(new PropertyValueFactory<>("idReservasi"));
        colResPasien.setCellValueFactory(new PropertyValueFactory<>("namaPasien")); // Custom getter di Model
        colResDokter.setCellValueFactory(new PropertyValueFactory<>("namaDokter")); // Custom getter di Model
        colResJadwal.setCellValueFactory(new PropertyValueFactory<>("infoJadwal")); // Custom getter di Model
        colResStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tblReservasi.getItems().setAll(staffService.getAllReservasi());

        colPasienNama.setCellValueFactory(new PropertyValueFactory<>("namaLengkap"));
        colPasienTelp.setCellValueFactory(new PropertyValueFactory<>("noTelepon"));
        tblPasien.getItems().setAll(staffService.getAllPasien());

        colDokterNama.setCellValueFactory(new PropertyValueFactory<>("namaDokter"));
        colDokterSpesialis.setCellValueFactory(new PropertyValueFactory<>("spesialis"));
        tblDokter.getItems().setAll(staffService.getAllDokter());
    }
}