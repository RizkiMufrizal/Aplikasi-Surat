package org.rizki.mufrizal.aplikasi.surat.controller;

import org.rizki.mufrizal.aplikasi.surat.domain.Letter;
import org.rizki.mufrizal.aplikasi.surat.dto.LetterDto;
import org.rizki.mufrizal.aplikasi.surat.dto.mapper.LetterToDtoMapper;
import org.rizki.mufrizal.aplikasi.surat.helper.upload.StorageFileNotFoundException;
import org.rizki.mufrizal.aplikasi.surat.helper.upload.StorageService;
import org.rizki.mufrizal.aplikasi.surat.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/incomeLetter")
    public String letterIncome(Model model) {
        model.addAttribute("letter", letterService.findAllByLetPassIsTrue());
        return "letter_income";
    }

    @GetMapping(value = "/newIncomeLetter")
    public String incomeLetterNew(Model model) {
        model.addAttribute("letter", new LetterDto());
        return "letter_income_new";
    }

    @PostMapping(value = "/newIncomeLetter")
    public String incomeLetterSave(@ModelAttribute("letter") LetterDto letterDto, @RequestParam("file") MultipartFile multipartFile) {
        letterDto.setLetPass(Boolean.TRUE);
        letterDto.setLetterUpload(storageService.store(multipartFile));
        letterService.saveLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        return "redirect:/incomeLetter";
    }

    @GetMapping(value = "/editIncomeLetter/{idLetter}")
    public String incomeLetterEdit(@PathVariable("idLetter") String idLetter, Model model) {
        model.addAttribute("letter", letterDtoToLetter.letterToLetterDto(letterService.findById(idLetter).orElse(new Letter())));
        return "letter_income_edit";
    }

    @PostMapping(value = "/editIncomeLetter")
    public String incomeLetterUpdate(@ModelAttribute("letter") LetterDto letterDto) {
        letterDto.setLetPass(Boolean.TRUE);
        letterService.updateLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        return "redirect:/incomeLetter";
    }

    @GetMapping(value = "/deleteIncomeLetter/{idLetter}")
    public String incomeLetterDelete(@PathVariable("idLetter") String idLetter) {
        Letter letter = letterService.findById(idLetter).orElse(new Letter());
        letterService.deleteLetter(idLetter);
        storageService.deleteFile(letter.getLetterUpload());
        return "redirect:/incomeLetter";
    }

    @GetMapping(value = "/sendLetter")
    public String letterSend(Model model) {
        model.addAttribute("letter", letterService.findAllByLetPassIsFalse());
        return "letter_send";
    }

    @GetMapping(value = "/newSendLetter")
    public String sendLetterNew(Model model) {
        model.addAttribute("letter", new LetterDto());
        return "letter_send_new";
    }

    @PostMapping(value = "/newSendLetter")
    public String sendLetterSave(@ModelAttribute("letter") LetterDto letterDto, @RequestParam("file") MultipartFile multipartFile) {
        letterDto.setLetPass(Boolean.FALSE);
        letterDto.setLetterUpload(storageService.store(multipartFile));
        letterService.saveLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        return "redirect:/sendLetter";
    }

    @GetMapping(value = "/editSendLetter/{idLetter}")
    public String sendLetterEdit(@PathVariable("idLetter") String idLetter, Model model) {
        model.addAttribute("letter", letterDtoToLetter.letterToLetterDto(letterService.findById(idLetter).orElse(new Letter())));
        return "letter_send_edit";
    }

    @PostMapping(value = "/editSendLetter")
    public String sendLetterUpdate(@ModelAttribute("letter") LetterDto letterDto) {
        letterDto.setLetPass(Boolean.FALSE);
        letterService.updateLetter(letterDtoToLetter.letterDtoToLetter(letterDto));
        return "redirect:/sendLetter";
    }

    @GetMapping(value = "/deleteSendLetter/{idLetter}")
    public String sendLetterDelete(@PathVariable("idLetter") String idLetter) {
        Letter letter = letterService.findById(idLetter).orElse(new Letter());
        letterService.deleteLetter(idLetter);
        storageService.deleteFile(letter.getLetterUpload());
        return "redirect:/sendLetter";
    }

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