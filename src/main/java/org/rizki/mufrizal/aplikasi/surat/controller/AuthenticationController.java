package org.rizki.mufrizal.aplikasi.surat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 9:57 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.controller
 * @File AuthenticationController
 */
@Controller
public class AuthenticationController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

}
