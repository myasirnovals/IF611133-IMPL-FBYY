package id.ac.ifunjani.sistemreservasiklinik.service;

import java.util.List;
import id.ac.ifunjani.sistemreservasiklinik.model.*;

public interface StaffService {
    Staff getById(String id);

    long countPasien();

    long countDokter();

    long countReservasi();

    List<Reservasi> getAllReservasi();

    List<Pasien> getAllPasien();

    List<Dokter> getAllDokter();
}