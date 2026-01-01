package id.ac.ifunjani.sistemreservasiklinik.util;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Staff;

public class UserSession {
    private static UserSession instance;
    private Pasien loggedInPasien;
    private Dokter loggedInDokter;
    private Staff loggedInStaff;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setPasien(Pasien p) {
        this.loggedInPasien = p;
        this.loggedInDokter = null;
        this.loggedInStaff = null;
    }

    public Pasien getPasien() {
        return loggedInPasien;
    }

    public void setDokter(Dokter d) {
        this.loggedInDokter = d;
        this.loggedInPasien = null;
        this.loggedInStaff = null;
    }

    public Dokter getDokter() {
        return loggedInDokter;
    }

    public void setStaff(Staff s) {
        this.loggedInStaff = s;
        this.loggedInPasien = null;
        this.loggedInDokter = null;
    }

    public Staff getStaff() {
        return loggedInStaff;
    }

    public void clearSession() {
        this.loggedInPasien = null;
        this.loggedInDokter = null;
        this.loggedInStaff = null;
    }
}