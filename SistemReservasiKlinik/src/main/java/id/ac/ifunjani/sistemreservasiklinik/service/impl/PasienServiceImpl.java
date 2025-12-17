package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.service.PasienService;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import java.util.List;

public class PasienServiceImpl implements PasienService {
    private PasienRepository repository = new PasienRepository();

    @Override
    public boolean daftarPasien(Pasien p) {
        if (p.getNamaLengkap() == null || p.getNamaLengkap().trim().isEmpty()) {
            System.out.println("Validasi Gagal: Nama tidak boleh kosong!");
            return false;
        }

        if (p.getNoTelepon() == null || p.getNoTelepon().length() < 10) {
            System.out.println("Validasi Gagal: Nomor HP tidak valid!");
            return false;
        }

        if (p.getPassword() == null || p.getPassword().isEmpty()) {
            System.out.println("Validasi Gagal: Password wajib diisi!");
            return false;
        }

        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println("Error Service: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Pasien> getAllPasien() {
        return repository.findAll();
    }
}