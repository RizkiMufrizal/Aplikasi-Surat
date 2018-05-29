package org.rizki.mufrizal.aplikasi.surat.controller;

import org.rizki.mufrizal.aplikasi.surat.domain.Disposition;
import org.rizki.mufrizal.aplikasi.surat.domain.Letter;
import org.rizki.mufrizal.aplikasi.surat.dto.DispositionDto;
import org.rizki.mufrizal.aplikasi.surat.dto.mapper.DispositionToDtoMapper;
import org.rizki.mufrizal.aplikasi.surat.helper.security.AuthenticationSessionFacade;
import org.rizki.mufrizal.aplikasi.surat.service.DispositionService;
import org.rizki.mufrizal.aplikasi.surat.service.LetterService;
import org.rizki.mufrizal.aplikasi.surat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 9:20 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.controller
 * @File DispositionController
 */
@Controller
public class DispositionController {

    @Autowired
    private DispositionService dispositionService;

    @Autowired
    private LetterService letterService;

    @Autowired
    private UserService userService;

    @Autowired
    private DispositionToDtoMapper dispositionToDtoMapper;

    @Autowired
    private AuthenticationSessionFacade authenticationSessionFacade;

    @GetMapping(value = "/dispositions")
    public String letterIncome(Model model) {
        model.addAttribute("disposition", dispositionService.findAll());
        return "disposition";
    }

    @GetMapping(value = "/newDisposition")
    public String dispositionNew(Model model) {
        model.addAttribute("disposition", new DispositionDto());
        model.addAttribute("letter", letterService.findAllByLetPassIsTrue());
        model.addAttribute("user", userService.findAll());
        return "disposition_new";
    }

    @PostMapping(value = "/newDisposition")
    public String dispositionSave(@ModelAttribute("disposition") DispositionDto dispositionDto) {
        dispositionDto.setDispositionFrom(authenticationSessionFacade.getUsername());
        Disposition disposition = dispositionToDtoMapper.dispositionDtoToDisposition(dispositionDto);
        disposition.setLetter(letterService.findById(dispositionDto.getLetterDto()).orElse(new Letter()));
        dispositionService.saveDisposition(disposition);
        return "redirect:/dispositions";
    }
}
