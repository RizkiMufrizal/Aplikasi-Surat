package org.rizki.mufrizal.aplikasi.surat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 10:35 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.controller
 * @File DashboardController
 */
@Controller
public class DashboardController {

    @GetMapping(value = "/")
    public String dashboardPage() {
        return "dashboard";
    }

}
