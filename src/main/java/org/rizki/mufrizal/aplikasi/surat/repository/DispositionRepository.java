package org.rizki.mufrizal.aplikasi.surat.repository;

import org.rizki.mufrizal.aplikasi.surat.domain.Disposition;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 8:48 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.repository
 * @File DispositionRepository
 */
public interface DispositionRepository extends PagingAndSortingRepository<Disposition, String> {
}