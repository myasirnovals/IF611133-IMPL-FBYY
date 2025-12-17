package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.*;
import id.ac.ifunjani.sistemreservasiklinik.repository.ReservasiRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.StaffRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.impl.ReservasiRepositoryImpl;
import id.ac.ifunjani.sistemreservasiklinik.repository.impl.StaffRepositoryImpl;
import id.ac.ifunjani.sistemreservasiklinik.service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final ReservasiRepository reservasiRepository;

    public StaffServiceImpl() {
        this.staffRepository = new StaffRepository();
        this.reservasiRepository = new ReservasiRepository();
    }

    @Override public long countPasien() { return reservasiRepository.countPasien(); }
    @Override public long countDokter() { return reservasiRepository.countDokter(); }
    @Override public long countReservasi() { return reservasiRepository.countReservasi(); }

    @Override public List<Reservasi> getAllReservasi() { return reservasiRepository.findAll(); }
    @Override public List<Pasien> getAllPasien() { return reservasiRepository.findAllPasien(); }
    @Override public List<Dokter> getAllDokter() { return reservasiRepository.findAllDokter(); }
}
