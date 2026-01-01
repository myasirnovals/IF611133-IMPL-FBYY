package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Reservasi;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import id.ac.ifunjani.sistemreservasiklinik.service.StaffService;


import java.util.ArrayList;
import java.util.List;

public class StaffServiceImpl implements StaffService {


    @Override
    public Staff getById(String idStaff) {

        return null;
    }

    @Override
    public long countPasien() {

        return 0;
    }

    @Override
    public long countDokter() {
        return 0;
    }

    @Override
    public long countReservasi() {
        return 0;
    }

    @Override
    public List<Reservasi> getAllReservasi() {
        return new ArrayList<>();
    }

    @Override
    public List<Pasien> getAllPasien() {
        return new ArrayList<>();
    }

    @Override
    public List<Dokter> getAllDokter() {
        return new ArrayList<>();
    }
}