package DAO;

import DTO.BaoCaoTK;
import DTO.BaoCaoTK.DocGiaTraTreSachDTO;
import DTO.BaoCaoTK.LuotMuonSachTheoThangVaTheLoaiDTO;
import DTO.BaoCaoTK.Top5SachCoNhieuLuotMuonDTO;
import JDBCConnection.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaoCaoTKDAO {
    private Connection connection;

    public BaoCaoTKDAO() {
        try {
            this.connection = JDBCConnection.getJDBCConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<LuotMuonSachTheoThangVaTheLoaiDTO> getLuotMuonSachTheoThangVaTheLoai(int thang) {
        List<LuotMuonSachTheoThangVaTheLoaiDTO> list = new ArrayList<>();
        String query = "SELECT tl.MATHELOAI, tl.TENTHELOAI, TO_CHAR(pm.NGAYLAP, 'MM') AS THANG, COUNT(*) AS SO_LUOT_MUON "
                + "FROM PHIEUMUON pm "
                + "JOIN CTPHIEUMUON ctpm ON pm.MAPHIEUMUON = ctpm.MAPHIEUMUON "
                + "JOIN SACH s ON ctpm.MASACH = s.MASACH "
                + "JOIN THELOAI tl ON s.MATHELOAI = tl.MATHELOAI "
                + "WHERE EXTRACT(MONTH FROM pm.NGAYLAP) = ? "
                + "GROUP BY tl.MATHELOAI, tl.TENTHELOAI, TO_CHAR(pm.NGAYLAP, 'MM') "
                + "ORDER BY tl.MATHELOAI";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, thang);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maTheLoai = resultSet.getString("MATHELOAI");
                String tenTheLoai = resultSet.getString("TENTHELOAI");
                String thangStr = resultSet.getString("THANG");
                int soLuotMuon = resultSet.getInt("SO_LUOT_MUON");

                list.add(new LuotMuonSachTheoThangVaTheLoaiDTO(maTheLoai, tenTheLoai, thangStr, soLuotMuon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Top5SachCoNhieuLuotMuonDTO> getTop5SachCoNhieuLuotMuon(int thang) {
        List<Top5SachCoNhieuLuotMuonDTO> list = new ArrayList<>();
        String query = "SELECT s.MASACH, s.TENSACH, TO_CHAR(pm.NGAYLAP, 'MM') AS THANG, COUNT(*) AS SO_LUOT_MUON "
                + "FROM PHIEUMUON pm "
                + "JOIN CTPHIEUMUON ctpm ON pm.MAPHIEUMUON = ctpm.MAPHIEUMUON "
                + "JOIN SACH s ON ctpm.MASACH = s.MASACH "
                + "WHERE EXTRACT(MONTH FROM pm.NGAYLAP) = ? "
                + "GROUP BY s.MASACH, s.TENSACH, TO_CHAR(pm.NGAYLAP, 'MM') "
                + "ORDER BY SO_LUOT_MUON DESC "
                + "FETCH FIRST 5 ROWS ONLY";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, thang);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maSach = resultSet.getString("MASACH");
                String tenSach = resultSet.getString("TENSACH");
                String thangStr = resultSet.getString("THANG");
                int soLuotMuon = resultSet.getInt("SO_LUOT_MUON");

                list.add(new Top5SachCoNhieuLuotMuonDTO(maSach, tenSach, thangStr, soLuotMuon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<DocGiaTraTreSachDTO> getDocGiaTraTreSach() {
    List<DocGiaTraTreSachDTO> list = new ArrayList<>();

    String query = "SELECT dg.MADOCGIA, dg.HOTEN, TO_CHAR(pm.HANTRA, 'DD/MM/YYYY') AS HANTRA, " +
                   "TINH_SO_NGAY_TRA_TRE_FUNC(ctpm.MASACH, dg.MADOCGIA) AS SONGAYTRETRU " +
                   "FROM PHIEUMUON pm " +
                   "JOIN CTPHIEUMUON ctpm ON pm.MAPHIEUMUON = ctpm.MAPHIEUMUON " +
                   "JOIN DOCGIA dg ON pm.MADOCGIA = dg.MADOCGIA " +
                   "WHERE EXISTS ( " +
                   "   SELECT 1 " +
                   "   FROM CTPHIEUMUON ctpm_inner " +
                   "   WHERE ctpm_inner.MAPHIEUMUON = pm.MAPHIEUMUON " +
                   "   AND ctpm_inner.TRANGTHAI = 0 " + 
                   ") " +
                    "AND TINH_SO_NGAY_TRA_TRE_FUNC(ctpm.MASACH, dg.MADOCGIA) > 0 " +
                   "ORDER BY SONGAYTRETRU DESC";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String maDocGia = resultSet.getString("MADOCGIA");
            String hoTen = resultSet.getString("HOTEN");
            String hanTra = resultSet.getString("HANTRA");
            int soNgayTreTre = resultSet.getInt("SONGAYTRETRU");

            list.add(new DocGiaTraTreSachDTO(maDocGia, hoTen, hanTra, soNgayTreTre));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
}