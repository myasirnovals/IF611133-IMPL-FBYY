package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Reservasi;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import java.util.List;

public interface StaffService {
    Staff getById(String idStaff);
    long countPasien();
    long countDokter();
    long countReservasi();
    List<Reservasi> getAllReservasi();
    List<Pasien> getAllPasien();
    List<Dokter> getAllDokter();
}