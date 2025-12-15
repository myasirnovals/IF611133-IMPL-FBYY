package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import java.util.List;

public interface PasienService {
    boolean daftarPasien(Pasien p);
    List<Pasien> getAllPasien();
}