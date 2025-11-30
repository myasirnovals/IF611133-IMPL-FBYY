package id.ac.ifunjani.sistemreservasiklinik.model;

import java.time.LocalDate;

public class RekamMedis {
    private String idRekamMedis;

    private String idReservasi; // Relasi ke Reservasi
    private String idDokter;    // Relasi ke Dokter (ada di bubble atribut ERD)

    private String keluhan;
    private String diagnosa;
    private String catatanDokter;
    private LocalDate tanggalPeriksa;

    public RekamMedis() {
    }

    public RekamMedis(String idRekamMedis, String idReservasi, String idDokter, String keluhan, String diagnosa, String catatanDokter, LocalDate tanggalPeriksa) {
        this.idRekamMedis = idRekamMedis;
        this.idReservasi = idReservasi;
        this.idDokter = idDokter;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.catatanDokter = catatanDokter;
        this.tanggalPeriksa = tanggalPeriksa;
    }

    public String getIdRekamMedis() {
        return idRekamMedis;
    }

    public void setIdRekamMedis(String idRekamMedis) {
        this.idRekamMedis = idRekamMedis;
    }

    public String getIdReservasi() {
        return idReservasi;
    }

    public void setIdReservasi(String idReservasi) {
        this.idReservasi = idReservasi;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getCatatanDokter() {
        return catatanDokter;
    }

    public void setCatatanDokter(String catatanDokter) {
        this.catatanDokter = catatanDokter;
    }

    public LocalDate getTanggalPeriksa() {
        return tanggalPeriksa;
    }

    public void setTanggalPeriksa(LocalDate tanggalPeriksa) {
        this.tanggalPeriksa = tanggalPeriksa;
    }
}