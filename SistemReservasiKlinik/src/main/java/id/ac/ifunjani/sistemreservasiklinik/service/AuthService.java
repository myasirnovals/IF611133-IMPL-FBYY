package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;

public interface AuthService {

    Pasien loginPasien(String idPasien, String password);

    Dokter loginDokter(String idDokter, String password);

    Staff loginStaff(String idStaff, String password);

}