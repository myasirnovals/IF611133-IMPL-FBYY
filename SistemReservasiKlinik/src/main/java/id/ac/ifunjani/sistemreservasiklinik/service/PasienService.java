package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;

public interface PasienService {
    boolean daftarPasien(Pasien p);
    Pasien login(String idPasien, String password);
    Pasien getPasienById(String id);
}