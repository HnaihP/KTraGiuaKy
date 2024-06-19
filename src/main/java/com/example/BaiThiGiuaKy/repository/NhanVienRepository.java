package com.example.BaiThiGiuaKy.repository;

import com.example.BaiThiGiuaKy.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    // Additional query methods (if needed) can be defined here
}