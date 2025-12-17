package id.ac.ifunjani.sistemreservasiklinik.service.impl;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Jadwal;
import id.ac.ifunjani.sistemreservasiklinik.repository.DokterRepository;
import id.ac.ifunjani.sistemreservasiklinik.repository.JadwalRepository;
import id.ac.ifunjani.sistemreservasiklinik.service.DokterService;

import java.util.List;

public class DokterServiceImpl implements DokterService {
    private final DokterRepository dokterRepository;
    private final JadwalRepository jadwalRepository;

    public DokterServiceImpl(DokterRepository dokterRepo, JadwalRepository jadwalRepo) {
        this.dokterRepository = dokterRepo;
        this.jadwalRepository = jadwalRepo;
    }

    @Override
    public List<Dokter> getAllDokter() {
        return dokterRepository.findAll();
    }

    @Override
    public Dokter getDokterById(String idDokter) {
        return dokterRepository.findById(idDokter);
    }

    @Override
    public List<Dokter> cariDokterBySpesialis(String spesialis) {
        return dokterRepository.findBySpesialis(spesialis);
    }

    @Override
    public boolean tambahDokter(Dokter dokter) {
        if (dokter.getNamaDokter() == null || dokter.getNamaDokter().isEmpty()) {
            return false;
        }
        return dokterRepository.save(dokter) != null;
    }

    @Override
    public boolean updateDokter(Dokter dokter) {
        return dokterRepository.update(dokter);
    }

    @Override
    public boolean hapusDokter(String idDokter) {
        List<Jadwal> jadwalList = jadwalRepository.findByDokterId(idDokter);
        if (!jadwalList.isEmpty()) {
            System.out.println("Gagal hapus: Dokter masih memiliki jadwal aktif.");
            return false;
        }
        return dokterRepository.delete(idDokter);
    }

    @Override
    public String generateIdDokter() {
        return dokterRepository.generateId();
    }

    @Override
    public List<Jadwal> getJadwalByDokter(String idDokter) {
        return jadwalRepository.findByDokterId(idDokter);
    }

    @Override
    public boolean tambahJadwal(Jadwal jadwal) {
        if (jadwal.getJamMulai().isAfter(jadwal.getJamSelesai())) {
            System.err.println("Jam mulai tidak boleh setelah jam selesai.");
            return false;
        }
        return jadwalRepository.save(jadwal);
    }

    @Override
    public boolean hapusJadwal(String idJadwal) {
        return jadwalRepository.delete(idJadwal);
    }

    @Override
    public String generateIdJadwal() {
        return jadwalRepository.generateId();
    }
}