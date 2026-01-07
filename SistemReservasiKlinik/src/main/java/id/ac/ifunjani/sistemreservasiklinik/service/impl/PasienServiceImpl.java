package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.PasienService;

import java.time.LocalDate;

public class PasienServiceImpl implements PasienService {
    private final PasienRepository pasienRepository;

    public PasienServiceImpl(PasienRepository pasienRepository) {
        this.pasienRepository = pasienRepository;
    }

    @Override
    public Pasien registerPasien(String idPasien, String nama, String alamat, LocalDate tanggalLahir, String noTelepon, String password) {
        Pasien existing = pasienRepository.findById(idPasien);
        if (existing != null) {
            return null;
        }

        Pasien p = new Pasien();
        p.setIdPasien(idPasien);
        p.setNamaLengkap(nama);
        p.setAlamat(alamat);
        p.setTanggalLahir(tanggalLahir);
        p.setNoTelepon(noTelepon);
        p.setPassword(password);

        boolean isSaved = pasienRepository.save(p);

        if (isSaved) {
            return p;
        } else {
            return null;
        }
    }

    @Override
    public Pasien login(String idPasien, String password) {
        return pasienRepository.findByIdAndPassword(idPasien, password);
    }

    @Override
    public Pasien getPasienById(String id) {
        return pasienRepository.findById(id);
    }
}