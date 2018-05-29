package org.rizki.mufrizal.aplikasi.surat.controller;

import org.rizki.mufrizal.aplikasi.surat.domain.User;
import org.rizki.mufrizal.aplikasi.surat.service.UserService;
import org.rizki.mufrizal.aplikasi.surat.util.SetOfRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping(value = "/newUsers")
    public String userNew(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", SetOfRoles.getRoles());
        return "user_new";
    }

    @PostMapping(value = "/newUsers")
    public String userSave(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/editUsers/{username}")
    public String userEdit(@PathVariable("username") String username, Model model) {
        System.out.println("cek " + userService.findById(username).get().getPassword());
        model.addAttribute("user", userService.findById(username).orElse(new User()));
        model.addAttribute("roles", SetOfRoles.getRoles());
        return "user_edit";
    }

    @PostMapping(value = "/editUsers")
    public String userUpdate(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/deleteUsers/{username}")
    public String userDelete(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return "redirect:/users";
    }

}
