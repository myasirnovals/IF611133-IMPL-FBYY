package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.Staff;
import java.util.ArrayList;
import java.util.List;

public class StaffRepositoryImpl implements StaffRepository {
    private List<Staff> dbStaff = new ArrayList<>();

    public StaffRepositoryImpl() {
        dbStaff.add(new Staff("ST001", "Fauzy Faadillah", "admin123"));
        dbStaff.add(new Staff("ST002", "Admin Klinik", "pass321"));
    }

    @Override
    public Staff findById(String idStaff) {
        return dbStaff.stream()
                .filter(s -> s.getIdStaff().equals(idStaff))
                .findFirst()
                .orElse(null);
    }

    @Override
    public long count() {
        return dbStaff.size();
    }
}