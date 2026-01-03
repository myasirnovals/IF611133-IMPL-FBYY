package id.ac.ifunjani.sistemreservasiklinik.model;

public class Staff {
    private String idStaff;
    private String nama;
    private String password;

    public Staff() {}

    public Staff(String idStaff, String nama, String password) {
        this.idStaff = idStaff;
        this.nama = nama;
        this.password = password;
    }

    public String getIdStaff() { return idStaff; }
    public void setIdStaff(String idStaff) { this.idStaff = idStaff; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}