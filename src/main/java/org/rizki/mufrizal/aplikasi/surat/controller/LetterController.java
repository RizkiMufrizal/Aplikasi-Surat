package org.rizki.mufrizal.aplikasi.surat.controller;

import org.rizki.mufrizal.aplikasi.surat.domain.Letter;
import org.rizki.mufrizal.aplikasi.surat.dto.LetterDto;
import org.rizki.mufrizal.aplikasi.surat.dto.mapper.LetterToDtoMapper;
import org.rizki.mufrizal.aplikasi.surat.helper.security.AuthenticationSessionFacade;
import org.rizki.mufrizal.aplikasi.surat.helper.upload.StorageFileNotFoundException;
import org.rizki.mufrizal.aplikasi.surat.helper.upload.StorageService;
import org.rizki.mufrizal.aplikasi.surat.service.DispositionService;
import org.rizki.mufrizal.aplikasi.surat.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 1:02 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.controller
 * @File LetterController
 */
@Controller
public class LetterController {

    @Autowired
    private LetterService letterService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private LetterToDtoMapper letterDtoToLetter;

    @Autowired
    private DispositionService dispositionService;

    @Autowired
    private AuthenticationSessionFacade authenticationSessionFacade;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PIMPINAN')")
    @GetMapping(value = "/incomeLetter")
    public String letterIncome(Model model) {
        model.addAttribute("letter", letterService.findAllByLetPassIsTrue());
        return "letter_income";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/newIncomeLetter")
    public String incomeLetterNew(Model model) {
        model.addAttribute("letter", new LetterDto());
        return "letter_income_new";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/newIncomeLetter")
    public String incomeLetterSave(@ModelAttribute("letter") LetterDto letterDto, @RequestParam("file") MultipartFile multipartFile) {
        letterDto.setLetPass(Boolean.TRUE);
        letterDto.setLetterUpload(storageService.store(multipartFile));
        letterService.saveLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        return "redirect:/incomeLetter";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/editIncomeLetter/{idLetter}")
    public String incomeLetterEdit(@PathVariable("idLetter") String idLetter, Model model) {
        model.addAttribute("letter", letterDtoToLetter.letterToLetterDto(letterService.findById(idLetter).orElse(new Letter())));
        return "letter_income_edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/editIncomeLetter")
    public String incomeLetterUpdate(@ModelAttribute("letter") LetterDto letterDto) {
        letterDto.setLetPass(Boolean.TRUE);
        letterService.updateLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        return "redirect:/incomeLetter";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/deleteIncomeLetter/{idLetter}")
    public String incomeLetterDelete(@PathVariable("idLetter") String idLetter) {
        Letter letter = letterService.findById(idLetter).orElse(new Letter());
        if (!dispositionService.findById(letter.getDisposition().getIdDisposition()).isPresent()) {
            letterService.deleteLetter(idLetter);
            storageService.deleteFile(letter.getLetterUpload());
        }
        return "redirect:/incomeLetter";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PIMPINAN')")
    @GetMapping(value = "/sendLetter")
    public String letterSend(Model model) {
        model.addAttribute("letter", letterService.findAllByLetPassIsFalse());
        return "letter_send";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @GetMapping(value = "/newSendLetter")
    public String sendLetterNew(Model model) {
        model.addAttribute("letter", new LetterDto());
        return "letter_send_new";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @PostMapping(value = "/newSendLetter")
    public String sendLetterSave(@ModelAttribute("letter") LetterDto letterDto, @RequestParam("file") MultipartFile multipartFile) {
        letterDto.setLetPass(Boolean.FALSE);
        letterDto.setLetterUpload(storageService.store(multipartFile));
        letterService.saveLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        if (authenticationSessionFacade.hasUserRole("ROLE_KEPALA_BAGIAN")) {
            return "redirect:/sendLetterHead";
        }
        return "redirect:/sendLetter";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @GetMapping(value = "/editSendLetter/{idLetter}")
    public String sendLetterEdit(@PathVariable("idLetter") String idLetter, Model model) {
        model.addAttribute("letter", letterDtoToLetter.letterToLetterDto(letterService.findById(idLetter).orElse(new Letter())));
        return "letter_send_edit";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @PostMapping(value = "/editSendLetter")
    public String sendLetterUpdate(@ModelAttribute("letter") LetterDto letterDto) {
        letterDto.setLetPass(Boolean.FALSE);
        letterService.updateLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        if (authenticationSessionFacade.hasUserRole("ROLE_KEPALA_BAGIAN")) {
            return "redirect:/sendLetterHead";
        }
        return "redirect:/sendLetter";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @GetMapping(value = "/deleteSendLetter/{idLetter}")
    public String sendLetterDelete(@PathVariable("idLetter") String idLetter) {
        Letter letter = letterService.findById(idLetter).orElse(new Letter());
        if (!dispositionService.findById(letter.getDisposition().getIdDisposition()).isPresent()) {
            letterService.deleteLetter(idLetter);
            storageService.deleteFile(letter.getLetterUpload());
        }
        if (authenticationSessionFacade.hasUserRole("ROLE_KEPALA_BAGIAN")) {
            return "redirect:/sendLetterHead";
        }
        return "redirect:/sendLetter";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @GetMapping(value = "/incomeLetterHead")
    public String letterIncomeHead(Model model) {
        model.addAttribute("letter", letterService.findAllByDisposition_DispositionToAndIsLetPass(authenticationSessionFacade.getUsername(), Boolean.TRUE));
        return "letter_income";
    }

    @PreAuthorize("hasRole('ROLE_KEPALA_BAGIAN')")
    @GetMapping(value = "/sendLetterHead")
    public String letterSendHead(Model model) {
        model.addAttribute("letter", letterService.findAllByLetPassIsFalse());
        return "letter_send";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PIMPINAN','ROLE_KEPALA_BAGIAN')")
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}