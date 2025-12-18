package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.RekamMedis;
import id.ac.ifunjani.sistemreservasiklinik.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RekamMedisRepository {
    public void save(RekamMedis rm) {
        String sql = "INSERT INTO rekam_medis (id_rekam_medis, id_dokter, keluhan, diagnosa, catatan_dokter, tanggal_periksa) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, rm.getIdRekamMedis());
            ps.setString(2, rm.getIdDokter());
            ps.setString(3, rm.getKeluhan());
            ps.setString(4, rm.getDiagnosa());
            ps.setString(5, rm.getCatatanDokter());

            if (rm.getTanggalPeriksa() != null) {
                ps.setDate(6, java.sql.Date.valueOf(rm.getTanggalPeriksa()));
            } else {
                ps.setDate(6, null);
            }

            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Rekam medis berhasil disimpan (tanpa ID Pasien di tabel RM).");

        } catch (Exception e) {
            System.out.println("Error save rekam medis: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<RekamMedis> findByPasienId(String idPasien) {
        List<RekamMedis> hasil = new ArrayList<>();

        String sql = "SELECT r.* FROM rekam_medis r " + "JOIN pendaftaran p ON r.id_rekam_medis = p.id_pendaftaran " + "WHERE p.id_pasien = ?";

        try {
            Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPasien);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RekamMedis rm = new RekamMedis();

                rm.setIdRekamMedis(rs.getString("id_rekam_medis"));
                rm.setIdPasien(idPasien);
                rm.setIdDokter(rs.getString("id_dokter"));
                rm.setKeluhan(rs.getString("keluhan"));
                rm.setDiagnosa(rs.getString("diagnosa"));
                rm.setCatatanDokter(rs.getString("catatan_dokter"));

                Date tgl = rs.getDate("tanggal_periksa");
                if (tgl != null) {
                    rm.setTanggalPeriksa(tgl.toLocalDate());
                }

                hasil.add(rm);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Gagal ambil data (Cek apakah tabel pendaftaran ada?): " + e.getMessage());
            e.printStackTrace();
        }
        return hasil;
    }

    public List<RekamMedis> findAll() {
        List<RekamMedis> hasil = new ArrayList<>();
        String sql = "SELECT * FROM rekam_medis";

        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RekamMedis rm = new RekamMedis();
                rm.setIdRekamMedis(rs.getString("id_rekam_medis"));
                // ID Pasien null karena tidak ada di tabel
                rm.setIdDokter(rs.getString("id_dokter"));
                rm.setKeluhan(rs.getString("keluhan"));
                rm.setDiagnosa(rs.getString("diagnosa"));
                rm.setCatatanDokter(rs.getString("catatan_dokter"));

                Date tgl = rs.getDate("tanggal_periksa");
                if (tgl != null) {
                    rm.setTanggalPeriksa(tgl.toLocalDate());
                }
                hasil.add(rm);
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasil;
    }
}