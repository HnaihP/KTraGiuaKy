package com.example.BaiThiGiuaKy.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name = "ma_nv", length = 3, nullable = false)
    private String maNV;

    @Column(name = "ten_nv", length = 100, nullable = false)
    private String tenNV;

    @Column(name = "phai", length = 3)
    private String phai;

    @Column(name = "noi_sinh", length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "ma_phong")
    private PhongBan phongBan;

    @Column(name = "luong")
    private int luong;
}
