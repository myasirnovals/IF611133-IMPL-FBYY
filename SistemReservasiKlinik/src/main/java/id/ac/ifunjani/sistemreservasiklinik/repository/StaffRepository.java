package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.Staff;

public interface StaffRepository {
    Staff findById(String idStaff);
    long count();
}