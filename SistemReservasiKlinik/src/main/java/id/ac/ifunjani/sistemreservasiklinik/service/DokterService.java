package id.ac.ifunjani.sistemreservasiklinik.service;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Jadwal;
import id.ac.ifunjani.sistemreservasiklinik.model.RekamMedis;
import id.ac.ifunjani.sistemreservasiklinik.model.Rujukan;

import java.util.List;

public interface DokterService {
    List<Dokter> getAllDokter();

    Dokter getDokterById(String idDokter);

    List<Dokter> cariDokterBySpesialis(String spesialis);

    boolean tambahDokter(Dokter dokter);

    boolean updateDokter(Dokter dokter);

    boolean hapusDokter(String idDokter);

    String generateIdDokter();

    List<Jadwal> getJadwalByDokter(String idDokter);

    boolean tambahJadwal(Jadwal jadwal);

    boolean hapusJadwal(String idJadwal);

    String generateIdJadwal();

    List<RekamMedis> getRekamMedisTerakhir(String idDokter, int limit);

    List<Rujukan> getRujukanTerakhir(String idDokter, int limit);
}