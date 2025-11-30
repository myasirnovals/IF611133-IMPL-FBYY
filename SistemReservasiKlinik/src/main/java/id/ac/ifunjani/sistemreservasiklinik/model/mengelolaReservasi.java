package id.ac.ifunjani.sistemreservasiklinik.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class mengelolaReservasi {

    private Long idReservasi;
    private Long idPasien;
    private Long idDokter;
    private LocalDate tanggalReservasi;
    private LocalTime waktuReservasi;
    private String statusReservasi; // Contoh: "Scheduled", "Completed", "Cancelled"

    public mengelolaReservasi() {
    }

    public mengelolaReservasi(Long idReservasi, Long idPasien, Long idDokter, LocalDate tanggalReservasi, LocalTime waktuReservasi, String statusReservasi) {
        this.idReservasi = idReservasi;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.tanggalReservasi = tanggalReservasi;
        this.waktuReservasi = waktuReservasi;
        this.statusReservasi = statusReservasi;
    }

    public Long getIdReservasi() {
        return idReservasi;
    }

    public void setIdReservasi(Long idReservasi) {
        this.idReservasi = idReservasi;
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public Long getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Long idDokter) {
        this.idDokter = idDokter;
    }

    public LocalDate getTanggalReservasi() {
        return tanggalReservasi;
    }

    public void setTanggalReservasi(LocalDate tanggalReservasi) {
        this.tanggalReservasi = tanggalReservasi;
    }

    public LocalTime getWaktuReservasi() {
        return waktuReservasi;
    }

    public void setWaktuReservasi(LocalTime waktuReservasi) {
        this.waktuReservasi = waktuReservasi;
    }

    public String getStatusReservasi() {
        return statusReservasi;
    }

    public void setStatusReservasi(String statusReservasi) {
        this.statusReservasi = statusReservasi;
    }
}