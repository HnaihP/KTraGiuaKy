package com.example.BaiThiGiuaKy.service;

import com.example.BaiThiGiuaKy.model.NhanVien;
import com.example.BaiThiGiuaKy.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> getNhanVienById(String maNV) {
        return nhanVienRepository.findById(maNV);
    }

    public NhanVien addNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(String maNV, NhanVien nhanVienDetails) {
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(maNV);
        if (optionalNhanVien.isPresent()) {
            NhanVien nhanVien = optionalNhanVien.get();
            nhanVien.setTenNV(nhanVienDetails.getTenNV());
            nhanVien.setPhai(nhanVienDetails.getPhai());
            nhanVien.setNoiSinh(nhanVienDetails.getNoiSinh());
            nhanVien.setPhongBan(nhanVienDetails.getPhongBan());
            nhanVien.setLuong(nhanVienDetails.getLuong());
            return nhanVienRepository.save(nhanVien);
        } else {
            throw new RuntimeException("NhanVien not found with id " + maNV);
        }
    }

    public void deleteNhanVien(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }
}

