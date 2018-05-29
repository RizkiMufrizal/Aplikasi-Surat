package org.rizki.mufrizal.aplikasi.surat.service;

import org.rizki.mufrizal.aplikasi.surat.domain.Disposition;

import java.util.Optional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 8:52 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service
 * @File DispositionService
 */
public interface DispositionService {
    void saveDisposition(Disposition disposition);

    void updateDisposition(Disposition disposition);

    void deleteDisposition(String idDisposition);

    Optional<Disposition> findById(String idDisposition);

    Iterable<Disposition> findAll();
}