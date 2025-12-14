package id.ac.ifunjani.sistemreservasiklinik.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Jadwal {
    private String idJadwal;
    private LocalDate tanggal;
    private String hari;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;
    private String idDokter;

    public Jadwal() {
    }

    public Jadwal(String idJadwal, LocalDate tanggal, String hari, LocalTime jamMulai, LocalTime jamSelesai, String idDokter) {
        this.idJadwal = idJadwal;
        this.tanggal = tanggal;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.idDokter = idDokter;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public LocalTime getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(LocalTime jamMulai) {
        this.jamMulai = jamMulai;
    }

    public LocalTime getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(LocalTime jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }
}
