package com.example.BaiThiGiuaKy.controller;

import com.example.BaiThiGiuaKy.model.NhanVien;
import com.example.BaiThiGiuaKy.service.NhanVienService;
import com.example.BaiThiGiuaKy.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showNhanVienList(Model model) {
        model.addAttribute("nhanvien", nhanVienService.getAllNhanVien());
        return "/nhanvien/nhanvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "/nhanvien/add-nhanvien";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongban", phongBanService.getAllPhongBan());
            return "/nhanvien/add-nhanvien";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }


    @GetMapping("/edit/{maNV}")
    public String showEditForm(@PathVariable String maNV, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid NhanVien Id:" + maNV));
        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "/nhanvien/update-nhanvien";
    }

    @PostMapping("/update/{maNV}")
    public String updateNhanVien(@PathVariable String maNV, @Valid NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            nhanVien.setMaNV(maNV);
            return "/nhanvien/update-nhanvien";
        }
        nhanVienService.updateNhanVien(maNV, nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{maNV}")
    public String deleteNhanVien(@PathVariable String maNV) {
        nhanVienService.deleteNhanVien(maNV);
        return "redirect:/nhanvien";
    }
}
