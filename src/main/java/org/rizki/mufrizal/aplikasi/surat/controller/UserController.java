package org.rizki.mufrizal.aplikasi.surat.controller;

import org.rizki.mufrizal.aplikasi.surat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 11:07 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.controller
 * @File UserController
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String userIndex(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

}
