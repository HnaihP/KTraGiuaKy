package com.example.BaiThiGiuaKy.controller;

import com.example.BaiThiGiuaKy.model.PhongBan;
import com.example.BaiThiGiuaKy.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phongbans")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    // Hiển thị danh sách phòng ban
    @GetMapping("")
    public String listPhongBans(Model model) {
        List<PhongBan> phongBans = phongBanService.getAllPhongBan();
        model.addAttribute("phongBans", phongBans);
        return "phongbans/list";
    }

    // Hiển thị form thêm mới phòng ban
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phongBan", new PhongBan());
        return "phongbans/add";
    }

    // Xử lý submit form thêm mới phòng ban
    @PostMapping("/add")
    public String addPhongBan(@Valid @ModelAttribute("phongBan") PhongBan phongBan,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "phongbans/add";
        }
        phongBanService.savePhongBan(phongBan);
        return "redirect:/phongbans";
    }

    // Hiển thị form cập nhật thông tin phòng ban
    @GetMapping("/edit/{maPhong}")
    public String showUpdateForm(@PathVariable("maPhong") String maPhong, Model model) {
        PhongBan phongBan = phongBanService.getPhongBanById(maPhong)
                .orElseThrow(() -> new IllegalArgumentException("Invalid PhongBan ID:" + maPhong));
        model.addAttribute("phongBan", phongBan);
        return "phongbans/edit";
    }

    // Xử lý submit form cập nhật thông tin phòng ban
    @PostMapping("/update/{maPhong}")
    public String updatePhongBan(@PathVariable("maPhong") String maPhong,
                                 @Valid @ModelAttribute("phongBan") PhongBan phongBan,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "phongbans/edit";
        }
        phongBanService.updatePhongBan(maPhong, phongBan);
        return "redirect:/phongbans";
    }

    // Xử lý xóa phòng ban
    @GetMapping("/delete/{maPhong}")
    public String deletePhongBan(@PathVariable("maPhong") String maPhong) {
        phongBanService.deletePhongBan(maPhong);
        return "redirect:/phongbans";
    }
}
