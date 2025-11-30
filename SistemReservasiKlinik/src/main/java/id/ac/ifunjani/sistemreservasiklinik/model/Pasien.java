package id.ac.ifunjani.sistemreservasiklinik.model;

import java.time.LocalDate;

public class Pasien {
    private String idPasien;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String noTelepon;
    private String password;

    public Pasien() {
    }

    public Pasien(String idPasien, String namaLengkap, String alamat,
                  LocalDate tanggalLahir, String noTelepon, String password) {
        this.idPasien = idPasien;
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.noTelepon = noTelepon;
        this.password = password;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}