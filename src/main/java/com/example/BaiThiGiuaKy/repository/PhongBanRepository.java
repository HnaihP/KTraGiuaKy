package com.example.BaiThiGiuaKy.repository;

import com.example.BaiThiGiuaKy.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {
    // Additional query methods (if needed) can be defined here
}