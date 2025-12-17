package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.Pasien;
import id.ac.ifunjani.sistemreservasiklinik.config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasienRepository {
    public boolean save(Pasien p) {
        String sql = "INSERT INTO pasien (id_pasien, nama_lengkap, alamat, tanggal_lahir, no_telepon, password) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            String safeId = p.getIdPasien();
            if (safeId.length() > 16) {
                safeId = safeId.substring(0, 16);
            }

            ps.setString(1, safeId);
            ps.setString(2, p.getNamaLengkap());
            ps.setString(3, p.getAlamat());

            if (p.getTanggalLahir() != null) {
                ps.setDate(4, java.sql.Date.valueOf(p.getTanggalLahir()));
            } else {
                ps.setDate(4, null);
            }

            String safePhone = p.getNoTelepon();
            if (safePhone != null && safePhone.length() > 13) {
                safePhone = safePhone.substring(0, 13);
            }

            ps.setString(5, safePhone);
            ps.setString(6, p.getPassword());

            int rowAffected = ps.executeUpdate();
            ps.close();
            conn.close();

            return rowAffected > 0;

        } catch (Exception e) {
            System.out.println("Gagal simpan pasien: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Pasien> findAll() {
        List<Pasien> list = new ArrayList<>();
        String sql = "SELECT * FROM pasien";

        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pasien p = new Pasien();

                p.setIdPasien(rs.getString("id_pasien"));
                p.setNamaLengkap(rs.getString("nama_lengkap"));
                p.setAlamat(rs.getString("alamat"));

                Date tgl = rs.getDate("tanggal_lahir");
                if (tgl != null) {
                    p.setTanggalLahir(tgl.toLocalDate());
                }

                p.setNoTelepon(rs.getString("no_telepon"));
                p.setPassword(rs.getString("password"));

                list.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Pasien findById(String id) {
        String sql = "SELECT * FROM pasien WHERE id_pasien = ?";
        Pasien p = null;

        try {
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Pasien();
                p.setIdPasien(rs.getString("id_pasien"));
                p.setNamaLengkap(rs.getString("nama_lengkap"));
                p.setAlamat(rs.getString("alamat"));

                Date tgl = rs.getDate("tanggal_lahir");
                if (tgl != null) {
                    p.setTanggalLahir(tgl.toLocalDate());
                }

                p.setNoTelepon(rs.getString("no_telepon"));
                p.setPassword(rs.getString("password"));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}