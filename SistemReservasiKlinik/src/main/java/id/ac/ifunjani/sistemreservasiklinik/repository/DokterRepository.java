package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.config.DatabaseConfig;
import id.ac.ifunjani.sistemreservasiklinik.model.Dokter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DokterRepository {

    public Dokter findById(String idDokter) {
        String sql = "SELECT * FROM dokter WHERE id_dokter = ?";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idDokter);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error findById: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<Dokter> findAll() {
        List<Dokter> list = new ArrayList<>();
        String sql = "SELECT * FROM dokter ORDER BY nama_dokter";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error findAll: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public List<Dokter> findBySpesialis(String spesialis) {
        List<Dokter> list = new ArrayList<>();
        String sql = "SELECT * FROM dokter WHERE spesialis LIKE ? ORDER BY nama_dokter";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + spesialis + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error findBySpesialis: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public Dokter save(Dokter dokter) {
        String sql = "INSERT INTO dokter (id_dokter, nama_dokter, spesialis, no_telp) " + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dokter.getIdDokter());
            ps.setString(2, dokter.getNamaDokter());
            ps.setString(3, dokter.getSpesialis());
            ps.setString(4, dokter.getNoTelp());

            int affected = ps.executeUpdate();

            if (affected > 0) {
                return dokter;
            }
        } catch (SQLException e) {
            System.err.println("Error save: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public boolean update(Dokter dokter) {
        String sql = "UPDATE dokter SET nama_dokter = ?, spesialis = ?, no_telp = ? " + "WHERE id_dokter = ?";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dokter.getNamaDokter());
            ps.setString(2, dokter.getSpesialis());
            ps.setString(3, dokter.getNoTelp());
            ps.setString(4, dokter.getIdDokter());

            int affected = ps.executeUpdate();

            return affected > 0;
        } catch (SQLException e) {
            System.err.println("Error update: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String idDokter) {
        String sql = "DELETE FROM dokter WHERE id_dokter = ?";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idDokter);

            int affected = ps.executeUpdate();

            return affected > 0;
        } catch (SQLException e) {
            System.err.println("Error delete: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public long countAll() {
        String sql = "SELECT COUNT(*) FROM dokter";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            System.err.println("Error countAll: " + e.getMessage());
            e.printStackTrace();
        }

        return 0L;
    }

    public String generateId() {
        String sql = "SELECT id_dokter FROM dokter ORDER BY id_dokter DESC LIMIT 1";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String lastId = rs.getString("id_dokter");

                int num = Integer.parseInt(lastId.substring(3)) + 1;

                return String.format("DKT%03d", num);
            } else {
                return "DKT001";
            }
        } catch (SQLException e) {
            System.err.println("Error generateId: " + e.getMessage());

            return "DKT001";
        }
    }

    private Dokter mapRow(ResultSet rs) throws SQLException {
        Dokter dokter = new Dokter();
        dokter.setIdDokter(rs.getString("id_dokter"));
        dokter.setNamaDokter(rs.getString("nama_dokter"));
        dokter.setSpesialis(rs.getString("spesialis"));
        dokter.setNoTelp(rs.getString("no_telp"));
        return dokter;
    }
}
