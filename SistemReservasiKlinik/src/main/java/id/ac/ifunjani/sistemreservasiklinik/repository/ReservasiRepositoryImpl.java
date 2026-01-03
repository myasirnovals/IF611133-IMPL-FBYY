package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.config.DatabaseConfig;
import id.ac.ifunjani.sistemreservasiklinik.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservasiRepositoryImpl implements ReservasiRepository {

    @Override
    public List<Reservasi> findAll() {
        List<Reservasi> list = new ArrayList<>();

        String sql = "SELECT r.*, p.nama_pasien, d.nama_dokter FROM reservasi r " +
                "JOIN pasien p ON r.id_pasien = p.id_pasien " +
                "JOIN dokter d ON r.id_dokter = d.id_dokter";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Reservasi res = new Reservasi();
                res.setIdReservasi(rs.getString("id_reservasi"));
                res.setInfoJadwal(rs.getString("info_jadwal"));
                res.setStatus(rs.getString("status"));

                list.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public long countReservasi() {
        String sql = "SELECT COUNT(*) FROM reservasi";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getLong(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    @Override public List<Pasien> findAllPasien() { return new ArrayList<>(); }
    @Override public List<Dokter> findAllDokter() { return new ArrayList<>(); }
    @Override public void saveReservasi(Reservasi res) { /* SQL INSERT */ }
    @Override public long countPasien() { return 0; }
    @Override public long countDokter() { return 0; }
}