/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author VINH
 */
public class PhieuPhat {
    private String MaPP;
    private String MaTT;
    private String MaDG;
    private String HoTenDG;
    private Date NgayLap;
    private List <CTPhieuPhat> dsSachMuon;

    public PhieuPhat() {
    }

    public PhieuPhat(String MaPP, String MaTT, String MaDG, String HoTenDG, Date NgayLap, List<CTPhieuPhat> dsSachMuon) {
        this.MaPP = MaPP;
        this.MaTT = MaTT;
        this.MaDG = MaDG;
        this.HoTenDG = HoTenDG;
        this.NgayLap = NgayLap;
        this.dsSachMuon = dsSachMuon;
    }

    
    public String getMaPP() {
        return MaPP;
    }

    public void setMaPP(String MaPP) {
        this.MaPP = MaPP;
    }

    public String getMaTT() {
        return MaTT;
    }

    public void setMaTT(String MaTT) {
        this.MaTT = MaTT;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getHoTenDG() {
        return HoTenDG;
    }

    public void setHoTenDG(String HoTenDG) {
        this.HoTenDG = HoTenDG;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public List<CTPhieuPhat> getDsSachMuon() {
        return dsSachMuon;
    }

    public void setDsSachMuon(List<CTPhieuPhat> dsSachMuon) {
        this.dsSachMuon = dsSachMuon;
    }
    
    public static class CTPhieuPhat{
        private String MaSach;
        private String TenSach;
        private double TienPhat;
        private int LiDo;

        public CTPhieuPhat() {
        }

        public CTPhieuPhat(String MaSach, String TenSach, double TienPhat, int LiDo) {
            this.MaSach = MaSach;
            this.TenSach = TenSach;
            this.TienPhat = TienPhat;
            this.LiDo = LiDo;
        }

        public String getMaSach() {
            return MaSach;
        }

        public void setMaSach(String MaSach) {
            this.MaSach = MaSach;
        }

        public String getTenSach() {
            return TenSach;
        }

        public void setTenSach(String TenSach) {
            this.TenSach = TenSach;
        }

        public double getTienPhat() {
            return TienPhat;
        }

        public void setTienPhat(double TienPhat) {
            this.TienPhat = TienPhat;
        }

        public int getLiDo() {
            return LiDo;
        }

        public void setLiDo(int LiDo) {
            this.LiDo = LiDo;
        }
        
        
    }
}
