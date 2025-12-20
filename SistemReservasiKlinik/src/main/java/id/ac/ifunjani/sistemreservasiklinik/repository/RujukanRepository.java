package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Rujukan;
import java.util.List;

public class RujukanRepository {

    public List<Rujukan> findTopNByDokter(Dokter dokter, int limit) {
        // TODO: implement JDBC query dengan JOIN ke rekam_medis
        return List.of();
    }
}

