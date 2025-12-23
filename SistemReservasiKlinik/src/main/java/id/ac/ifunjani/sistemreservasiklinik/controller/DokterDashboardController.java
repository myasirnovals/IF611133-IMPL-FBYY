package id.ac.ifunjani.sistemreservasiklinik.controller;

import id.ac.ifunjani.sistemreservasiklinik.entity.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.entity.Jadwal;
import id.ac.ifunjani.sistemreservasiklinik.entity.RekamMedis;
import id.ac.ifunjani.sistemreservasiklinik.entity.Rujukan;
import id.ac.ifunjani.sistemreservasiklinik.repository.DokterRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.JadwalRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.RekamMedisRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.RujukanRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.DokterService;
import id.ac.ifunjani.sistemreservasiklinik.service.impl.DokterServiceImpl;
import id.ac.ifunjani.sistemreservasiklinik.util.SceneManager;
import id.ac.ifunjani.sistemreservasiklinik.session.SessionUser;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DokterDashboardController {
    @FXML
    private Label welcomeLabel;
    @FXML
    private TableView<Jadwal> jadwalTable;
    @FXML
    private TableColumn<Jadwal, String> colIdJadwal;
    @FXML
    private TableColumn<Jadwal, String> colHari;
    @FXML
    private TableColumn<Jadwal, String> colJam;
    @FXML
    private TableColumn<Jadwal, String> colTanggal;
    @FXML
    private TableView<RekamMedis> rekamTable;
    @FXML
    private TableColumn<RekamMedis, String> colIdRekam;
    @FXML
    private TableColumn<RekamMedis, String> colKeluhan;
    @FXML
    private TableColumn<RekamMedis, String> colDiagnosa;
    @FXML
    private TableColumn<RekamMedis, String> colTglPeriksa;
    @FXML
    private TableView<Rujukan> rujukanTable;
    @FXML
    private TableColumn<Rujukan, String> colIdRujukan;
    @FXML
    private TableColumn<Rujukan, String> colRsTujuan;
    @FXML
    private TableColumn<Rujukan, String> colDeskripsi;
    @FXML
    private TableColumn<Rujukan, String> colIdRekamRef;

    private final DokterService dokterService;

    public DokterDashboardController() {
        this.dokterService = new DokterServiceImpl(new DokterRepository(), new JadwalRepository(), new RekamMedisRepository(), new RujukanRepository());
    }

    @FXML
    public void initialize() {
        String idDokter = SessionUser.getInstance().getUserId();

        if (idDokter == null) {
            SceneManager.getInstance().switchScene("/fxml/login.fxml", "KlinikSehat Login");
            return;
        }

        Dokter dokter = dokterService.getDokterById(idDokter);
        if (dokter != null) {
            welcomeLabel.setText("Selamat datang, dr. " + dokter.getNamaDokter());
        }

        setupColumns();

        loadData(idDokter);
    }

    private void setupColumns() {
        colIdJadwal.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdJadwal()));

        colHari.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHari()));

        colJam.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJamMulai() + " - " + data.getValue().getJamSelesai()));

        colTanggal.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTanggal().toString()));

        colIdRekam.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdRekamMedis()));

        colKeluhan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKeluhan()));

        colDiagnosa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDiagnosa()));

        colTglPeriksa.setCellValueFactory(data -> {
            if (data.getValue().getTanggalPeriksa() != null) {
                return new SimpleStringProperty(data.getValue().getTanggalPeriksa().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
            return new SimpleStringProperty("-");
        });

        colIdRujukan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdRujukan()));

        colRsTujuan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRumahSakitTujuan()));

        colDeskripsi.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDeskripsiRujukan()));

        colIdRekamRef.setCellValueFactory(data -> {
            if (data.getValue().getRekamMedis() != null) {
                return new SimpleStringProperty(data.getValue().getRekamMedis().getIdRekamMedis());
            }
            return new SimpleStringProperty("-");
        });
    }

    private void loadData(String idDokter) {
        List<Jadwal> jadwalList = dokterService.getJadwalByDokter(idDokter);
        List<RekamMedis> rekamList = dokterService.getRekamMedisTerakhir(idDokter, 10);
        List<Rujukan> rujukanList = dokterService.getRujukanTerakhir(idDokter, 10);

        jadwalTable.setItems(FXCollections.observableArrayList(jadwalList));
        rekamTable.setItems(FXCollections.observableArrayList(rekamList));
        rujukanTable.setItems(FXCollections.observableArrayList(rujukanList));
    }

    @FXML
    public void onLogout() {
        SessionUser.getInstance().clear();
        SceneManager.getInstance().switchScene("/fxml/login.fxml", "KlinikSehat Login");
    }
}