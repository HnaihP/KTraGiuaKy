    package com.example.BaiThiGiuaKy.repository;

import com.example.BaiThiGiuaKy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}