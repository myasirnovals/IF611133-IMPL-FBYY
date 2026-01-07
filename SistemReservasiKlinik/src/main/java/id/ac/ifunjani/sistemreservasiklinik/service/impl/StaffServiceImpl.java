package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.*;
import id.ac.ifunjani.sistemreservasiklinik.repository.*;
import id.ac.ifunjani.sistemreservasiklinik.service.StaffService;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepo = new StaffRepository();
    private final ReservasiRepository resRepo = new ReservasiRepository();

    @Override
    public Staff getById(String idStaff) {
        return staffRepo.findById(idStaff);
    }

    @Override
    public long countPasien() {
        return resRepo.countPasien();
    }

    @Override
    public long countDokter() {
        return resRepo.countDokter();
    }

    @Override
    public long countReservasi() {
        return resRepo.countReservasi();
    }

    @Override
    public List<Reservasi> getAllReservasi() { return resRepo.findAll(); }

    @Override
    public List<Pasien> getAllPasien() { return resRepo.findAllPasien(); }

    @Override
    public List<Dokter> getAllDokter() { return resRepo.findAllDokter(); }
}