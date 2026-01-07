package id.ac.ifunjani.sistemreservasiklinik.service.impl;


import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import id.ac.ifunjani.sistemreservasiklinik.repository.DokterRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.StaffRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private final PasienRepository pasienRepository;
    private final DokterRepository dokterRepository;
    private final StaffRepository StaffRepository;

    public AuthServiceImpl(
            PasienRepository pasienRepository,
            DokterRepository dokterRepository,
            StaffRepository StaffRepository) {

        this.pasienRepository = pasienRepository;
        this.dokterRepository = dokterRepository;
        this.StaffRepository = StaffRepository;
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
        return StaffRepository.findByIdAndPassword(idStaff, password);
    }
}
