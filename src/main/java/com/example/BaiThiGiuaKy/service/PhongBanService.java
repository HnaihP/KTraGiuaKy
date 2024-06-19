package com.example.BaiThiGiuaKy.service;

import com.example.BaiThiGiuaKy.model.PhongBan;
import com.example.BaiThiGiuaKy.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {

    private final PhongBanRepository phongBanRepository;

    @Autowired
    public PhongBanService(PhongBanRepository phongBanRepository) {
        this.phongBanRepository = phongBanRepository;
    }

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public Optional<PhongBan> getPhongBanById(String maPhong) {
        return phongBanRepository.findById(maPhong);
    }

    public PhongBan savePhongBan(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public void deletePhongBan(String maPhong) {
        phongBanRepository.deleteById(maPhong);
    }

    public PhongBan updatePhongBan(String maPhong, PhongBan phongBan) {
        PhongBan existingPhongBan = phongBanRepository.findById(maPhong)
                .orElseThrow(() -> new IllegalStateException("PhongBan with ID " + maPhong + " does not exist."));

        existingPhongBan.setTenPhong(phongBan.getTenPhong());

        return phongBanRepository.save(existingPhongBan);
    }
}
