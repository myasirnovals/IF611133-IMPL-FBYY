package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;

import java.time.LocalDate;

public interface PasienService {
    Pasien registerPasien(String idPasien, String nama, String alamat, LocalDate tanggalLahir, String noTelepon, String password);

    Pasien login(String idPasien, String password);

    Pasien getPasienById(String id);
}