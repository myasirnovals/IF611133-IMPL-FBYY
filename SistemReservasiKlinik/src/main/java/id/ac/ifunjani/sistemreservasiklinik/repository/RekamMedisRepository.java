package id.ac.ifunjani.sistemreservasiklinik.repository;

import id.ac.ifunjani.sistemreservasiklinik.model.RekamMedis;
import id.ac.ifunjani.sistemreservasiklinik.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RekamMedisRepository {
    Connection conn = DatabaseConnection.getConnection();

    public void save(RekamMedis rm) {
        try {
            String sql = "INSERT INTO rekam_medis (id_rekam_medis, id_dokter, keluhan, diagnosa, catatan_dokter, tanggal_periksa) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, rm.getIdRekamMedis());
            ps.setString(2, rm.getIdDokter());
            ps.setString(3, rm.getKeluhan());
            ps.setString(4, rm.getDiagnosa());
            ps.setString(5, rm.getCatatanDokter());
            ps.setString(6, rm.getTanggalPeriksa().toString());

            ps.execute();
            System.out.println("Rekam Medis berhasil disimpan!");

        } catch (Exception e) {
            System.out.println("Gagal simpan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<RekamMedis> findAll() {
        List<RekamMedis> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rekam_medis";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                RekamMedis rm = new RekamMedis();

                rm.setIdRekamMedis(rs.getString("id_rekam_medis"));
                rm.setIdDokter(rs.getString("id_dokter"));
                rm.setKeluhan(rs.getString("keluhan"));
                rm.setDiagnosa(rs.getString("diagnosa"));
                rm.setCatatanDokter(rs.getString("catatan_dokter"));

                String tgl = rs.getString("tanggal_periksa");
                if (tgl != null) {
                    rm.setTanggalPeriksa(java.time.LocalDate.parse(tgl));
                }

                list.add(rm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}