package id.ac.ifunjani.sistemreservasiklinik.model;

public class Reservasi {
    private String idReservasi;
    private Pasien pasien;
    private Dokter dokter;
    private String infoJadwal; // String gabungan hari & jam
    private String status;

    public Reservasi(String idReservasi, Pasien pasien, Dokter dokter, String infoJadwal, String status) {
        this.idReservasi = idReservasi;
        this.pasien = pasien;
        this.dokter = dokter;
        this.infoJadwal = infoJadwal;
        this.status = status;
    }

    public String getNamaPasien() { return pasien != null ? pasien.getNamaLengkap() : "-"; }
    public String getNamaDokter() { return dokter != null ? dokter.getNamaDokter() : "-"; }

    public String getIdReservasi() { return idReservasi; }
    public String getInfoJadwal() { return infoJadwal; }
    public String getStatus() { return status; }
}