package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.*;

import java.util.ArrayList;
import java.util.List;

public class ReservasiRepositoryImpl implements ReservasiRepository {

    @Override
    public List<Reservasi> findAll() {
        return new ArrayList<>();
    }

    @Override
    public List<Pasien> findAllPasien() {
        return new ArrayList<>();
    }

    @Override
    public List<Dokter> findAllDokter() {
        return new ArrayList<>();
    }

    @Override
    public long countReservasi() {
        return 0;
    }

    @Override
    public long countPasien() {
        return 0;
    }

    @Override
    public long countDokter() {
        return 0;
    }
}