package id.ac.ifunjani.sistemreservasiklinik.model;

import java.time.LocalDate;

public class Pasien {
    private String idPasien;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String noTelepon;
    private String password;

    public String getIdPasien() {
        return idPasien;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getPassword() {
        return password;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}