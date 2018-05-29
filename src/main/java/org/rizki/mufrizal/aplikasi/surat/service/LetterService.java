package org.rizki.mufrizal.aplikasi.surat.service;

import org.rizki.mufrizal.aplikasi.surat.domain.Letter;

import java.util.Optional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 8:22 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service
 * @File LetterService
 */
public interface LetterService {
    void saveLetter(Letter letter);

    void updateLetter(Letter letter);

    void deleteLetter(String idLetter);

    Optional<Letter> findById(String idLetter);

    Iterable<Letter> findAllByLetPassIsTrue();

    Iterable<Letter> findAllByLetPassIsFalse();
}
