package org.rizki.mufrizal.aplikasi.surat.service.impl;

import org.rizki.mufrizal.aplikasi.surat.domain.Letter;
import org.rizki.mufrizal.aplikasi.surat.repository.LetterRepository;
import org.rizki.mufrizal.aplikasi.surat.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 12:58 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service.impl
 * @File LetterServiceImpl
 */
@Service
@Transactional(readOnly = true)
public class LetterServiceImpl implements LetterService {

    @Autowired
    LetterRepository letterRepository;

    @Transactional
    @Override
    public void saveLetter(Letter letter) {
        letterRepository.save(letter);
    }

    @Transactional
    @Override
    public void updateLetter(Letter letter) {
        letterRepository.save(letter);
    }

    @Transactional
    @Override
    public void deleteLetter(String idLetter) {
        letterRepository.deleteById(idLetter);
    }

    @Override
    public Optional<Letter> findById(String idLetter) {
        return letterRepository.findById(idLetter);
    }

    @Override
    public Iterable<Letter> findAllByLetPassIsTrue() {
        return letterRepository.findAllByIsLetPassIsTrue();
    }

    @Override
    public Iterable<Letter> findAllByLetPassIsFalse() {
        return letterRepository.findAllByIsLetPassIsFalse();
    }
}
