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
public class PhieuTra {
    private String MaPT;
    private String MaTT;
    private String MaDG;
    private String HoTenDG;
    private Date NgayTra;
    private List <CTPhieuTra> dsSachTra;

    public PhieuTra() {
    }

    public PhieuTra(String MaPT, String MaTT, String MaDG, String HoTenDG, Date NgayLap, List<CTPhieuTra> dsSachTra) {
        this.MaPT = MaPT;
        this.MaTT = MaTT;
        this.MaDG = MaDG;
        this.HoTenDG = HoTenDG;
        this.NgayTra = NgayLap;
        this.dsSachTra = dsSachTra;
    }

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
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

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public List<CTPhieuTra> getDsSachTra() {
        return dsSachTra;
    }

    public void setDsSachTra(List<CTPhieuTra> dsSachTra) {
        this.dsSachTra = dsSachTra;
    }
public static class CTPhieuTra{
    private String MaSach;
    private String TenSach;
    
        public CTPhieuTra() {
        }

        public CTPhieuTra(String MaSach, String TenSach) {
            this.MaSach = MaSach;
            this.TenSach = TenSach;

        }

        public String getMaSach() {
            return MaSach;
        }

        public String getTenSach() {
            return TenSach;
        }

        public void setMaSach(String MaSach) {
            this.MaSach = MaSach;
        }

        public void setTenSach(String TenSach) {
            this.TenSach = TenSach;
        }

      
        
        
    
}    
 
    
    
}

