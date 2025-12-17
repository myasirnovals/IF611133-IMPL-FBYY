package id.ac.ifunjani.sistemreservasiklinik.model;

public class Rujukan {

    private String idRujukan;
    private String deskripsiRujukan;
    private String rumahSakitTujuan;
    private RekamMedis rekamMedis;

    public Rujukan() {
    }

    public String getIdRujukan() {
        return idRujukan;
    }

    public void setIdRujukan(String idRujukan) {
        this.idRujukan = idRujukan;
    }

    public String getDeskripsiRujukan() {
        return deskripsiRujukan;
    }

    public void setDeskripsiRujukan(String deskripsiRujukan) {
        this.deskripsiRujukan = deskripsiRujukan;
    }

    public String getRumahSakitTujuan() {
        return rumahSakitTujuan;
    }

    public void setRumahSakitTujuan(String rumahSakitTujuan) {
        this.rumahSakitTujuan = rumahSakitTujuan;
    }

    public RekamMedis getRekamMedis() {
        return rekamMedis;
    }

    public void setRekamMedis(RekamMedis rekamMedis) {
        this.rekamMedis = rekamMedis;
    }
}
