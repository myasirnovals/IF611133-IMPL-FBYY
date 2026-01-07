package id.ac.ifunjani.sistemreservasiklinik.service.impl;


import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import id.ac.ifunjani.sistemreservasiklinik.repository.DokterRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.staffRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private final PasienRepository pasienRepository;
    private final DokterRepository dokterRepository;
    private final staffRepository staffRepository;

    public AuthServiceImpl(
            PasienRepository pasienRepository,
            DokterRepository dokterRepository,
            staffRepository staffRepositoryi) {

        this.pasienRepository = pasienRepository;
        this.dokterRepository = dokterRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public Pasien loginPasien(String idPasien, String password) {
        return pasienRepository.findByIdAndPassword(idPasien, password);
    }

    @Override
    public Dokter loginDokter(String idDokter, String password) {
        return dokterRepository.findById(idDokter);
    }

    @Override
    public Staff loginStaff(String idStaff, String password) {
        return staffRepository.findByIdAndPassword(idStaff, password);
    }
}
