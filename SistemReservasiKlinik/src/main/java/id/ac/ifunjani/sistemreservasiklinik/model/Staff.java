package id.ac.ifunjani.sistemreservasiklinik.model;

public class Staff {

    private Long idStaff;
    private String nama;
    private String jabatan;
    private String alamat;
    private String nomorTelepon;

    public Staff() {
    }

    public Staff(Long idStaff, String nama, String jabatan, String alamat, String nomorTelepon) {
        this.idStaff = idStaff;
        this.nama = nama;
        this.jabatan = jabatan;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    public Long getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Long idStaff) {
        this.idStaff = idStaff;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}