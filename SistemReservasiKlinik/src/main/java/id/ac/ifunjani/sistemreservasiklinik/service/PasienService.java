package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import java.util.List;

public class PasienService {
    private PasienRepository repository = new PasienRepository();

    public boolean daftarPasien(Pasien p) {
        if (p.getNamaLengkap().isEmpty()) {
            System.out.println("Error: Nama tidak boleh kosong!");
            return false;
        }

        if (p.getNoTelepon().length() < 10) {
            System.out.println("Error: Nomor telepon tidak boleh terlalu pendek!");
            return false;
        }

        repository.save(p);
        return true;
    }
    
    public List<Pasien> getAllPasien() {
        return repository.findAll();
    }
}