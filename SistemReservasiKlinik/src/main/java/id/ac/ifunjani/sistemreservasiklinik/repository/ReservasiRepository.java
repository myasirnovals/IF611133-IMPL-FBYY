package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Reservasi;
import java.util.List;

public interface ReservasiRepository {
    List<Reservasi> findAll();
    List<Pasien> findAllPasien();
    List<Dokter> findAllDokter();
    long countReservasi();
    long countPasien();
    long countDokter();
}