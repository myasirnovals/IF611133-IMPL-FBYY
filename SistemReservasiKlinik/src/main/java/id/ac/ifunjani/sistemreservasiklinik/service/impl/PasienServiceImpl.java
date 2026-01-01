package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.repository.PasienRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.PasienService;
import java.util.List;
import java.util.UUID;

public class PasienServiceImpl implements PasienService {
    private PasienRepository repo = new PasienRepository();

    @Override
    public boolean daftarPasien(Pasien p) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String idBaru = uuid.substring(0, 16).toUpperCase();

        p.setIdPasien(idBaru);

        if (p.getNamaLengkap() == null || p.getNamaLengkap().isEmpty()) {
            return false;
        }

        return repo.save(p);
    }

    @Override
    public Pasien login(String idPasien, String password) {
        List<Pasien> semuaPasien = repo.findAll();

        for (Pasien p : semuaPasien) {
            if (p.getIdPasien().equals(idPasien) && p.getPassword().equals(password)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public Pasien getPasienById(String id) {
        return repo.findById(id);
    }
}