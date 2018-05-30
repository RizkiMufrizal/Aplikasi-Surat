package org.rizki.mufrizal.aplikasi.surat.repository;

import org.rizki.mufrizal.aplikasi.surat.domain.Letter;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 12:59 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.repository
 * @File LetterRepository
 */
public interface LetterRepository extends PagingAndSortingRepository<Letter, String> {
    Iterable<Letter> findAllByIsLetPassIsTrue();

    Iterable<Letter> findAllByIsLetPassIsFalse();

    Iterable<Letter> findAllByDisposition_DispositionToAndIsLetPass(String username, Boolean isLetPass);
}