package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasienRepository {

    Connection conn = DatabaseConnection.getConnection();

    public void save(Pasien p) {
        try {
            String sql = "INSERT INTO pasien VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getIdPasien());
            ps.setString(2, p.getNamaLengkap());
            ps.setString(3, p.getAlamat());
            ps.setString(4, p.getTanggalLahir().toString());
            ps.setString(5, p.getNoTelepon());
            ps.setString(6, p.getPassword());

            ps.execute();
            System.out.println("Data tersimpan!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pasien> findAll() {
        List<Pasien> list = new ArrayList<>();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM pasien");

            while (rs.next()) {
                Pasien p = new Pasien();
                p.setIdPasien(rs.getString("id_pasien"));
                p.setNamaLengkap(rs.getString("nama_lengkap"));
                p.setAlamat(rs.getString("alamat"));
                
                p.setTanggalLahir(java.time.LocalDate.parse(rs.getString("tanggal_lahir")));
                p.setNoTelepon(rs.getString("no_telepon"));
                p.setPassword(rs.getString("password"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}