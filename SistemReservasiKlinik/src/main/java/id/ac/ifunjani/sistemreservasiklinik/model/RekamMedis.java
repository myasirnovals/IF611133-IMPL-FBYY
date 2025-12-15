package id.ac.ifunjani.sistemreservasiklinik.model;

import java.time.LocalDate;

public class RekamMedis {
    private String idRekamMedis;
    private String idDokter;

    private String keluhan;
    private String diagnosa;
    private String catatanDokter;
    private LocalDate tanggalPeriksa;

    public String getIdRekamMedis() {
        return idRekamMedis;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public String getCatatanDokter() {
        return catatanDokter;
    }

    public LocalDate getTanggalPeriksa() {
        return tanggalPeriksa;
    }

    public void setIdRekamMedis(String idRekamMedis) {
        this.idRekamMedis = idRekamMedis;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public void setCatatanDokter(String catatanDokter) {
        this.catatanDokter = catatanDokter;
    }

    public void setTanggalPeriksa(LocalDate tanggalPeriksa) {
        this.tanggalPeriksa = tanggalPeriksa;
    }
}