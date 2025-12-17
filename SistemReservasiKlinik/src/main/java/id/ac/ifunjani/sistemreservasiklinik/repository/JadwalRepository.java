package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.config.DatabaseConfig;
import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;
import id.ac.ifunjani.sistemreservasiklinik.model.Jadwal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JadwalRepository {
    public List<Jadwal> findByDokterId(String idDokter) {
        List<Jadwal> list = new ArrayList<>();
        String sql = "SELECT j.*, d.nama_dokter, d.spesialis, d.no_telp " +
                "FROM jadwal j " +
                "JOIN dokter d ON j.id_dokter = d.id_dokter " +
                "WHERE j.id_dokter = ? " +
                "ORDER BY j.tanggal ASC, j.jam_mulai ASC";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idDokter);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowWithDokter(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error findByDokterId: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Jadwal> findAll() {
        List<Jadwal> list = new ArrayList<>();
        String sql = "SELECT j.*, d.nama_dokter, d.spesialis, d.no_telp " +
                "FROM jadwal j " +
                "JOIN dokter d ON j.id_dokter = d.id_dokter " +
                "ORDER BY j.tanggal DESC";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRowWithDokter(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error findAll Jadwal: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public boolean save(Jadwal jadwal) {
        String sql = "INSERT INTO jadwal (id_jadwal, tanggal, hari, jam_mulai, jam_selesai, id_dokter) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, jadwal.getIdJadwal());
            ps.setDate(2, Date.valueOf(jadwal.getTanggal()));
            ps.setString(3, jadwal.getHari());
            ps.setTime(4, Time.valueOf(jadwal.getJamMulai()));
            ps.setTime(5, Time.valueOf(jadwal.getJamSelesai()));
            ps.setString(6, jadwal.getDokter().getIdDokter());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error save Jadwal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String idJadwal) {
        String sql = "DELETE FROM jadwal WHERE id_jadwal = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idJadwal);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error delete Jadwal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public String generateId() {
        String sql = "SELECT id_jadwal FROM jadwal ORDER BY id_jadwal DESC LIMIT 1";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                String lastId = rs.getString("id_jadwal");
                int num = Integer.parseInt(lastId.substring(1)) + 1;
                return String.format("J%04d", num);
            } else {
                return "J0001";
            }
        } catch (Exception e) {
            System.err.println("Error generateId Jadwal: " + e.getMessage());
            return "J0001";
        }
    }

    private Jadwal mapRowWithDokter(ResultSet rs) throws SQLException {
        Jadwal j = new Jadwal();
        j.setIdJadwal(rs.getString("id_jadwal"));
        j.setTanggal(rs.getDate("tanggal").toLocalDate());
        j.setHari(rs.getString("hari"));
        j.setJamMulai(rs.getTime("jam_mulai").toLocalTime());
        j.setJamSelesai(rs.getTime("jam_selesai").toLocalTime());

        Dokter d = new Dokter();
        d.setIdDokter(rs.getString("id_dokter"));
        d.setNamaDokter(rs.getString("nama_dokter"));
        d.setSpesialis(rs.getString("spesialis"));
        d.setNoTelp(rs.getString("no_telp"));

        j.setDokter(d);
        return j;
    }
}