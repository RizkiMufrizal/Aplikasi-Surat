package org.rizki.mufrizal.aplikasi.surat.service.impl;

import org.rizki.mufrizal.aplikasi.surat.domain.Disposition;
import org.rizki.mufrizal.aplikasi.surat.repository.DispositionRepository;
import org.rizki.mufrizal.aplikasi.surat.service.DispositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 9:15 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service.impl
 * @File DispositionServiceImpl
 */
@Service
@Transactional(readOnly = true)
public class DispositionServiceImpl implements DispositionService {

    @Autowired
    private DispositionRepository dispositionRepository;

    @Transactional
    @Override
    public void saveDisposition(Disposition disposition) {
        dispositionRepository.save(disposition);
    }

    @Transactional
    @Override
    public void updateDisposition(Disposition disposition) {
        dispositionRepository.save(disposition);
    }

    @Transactional
    @Override
    public void deleteDisposition(String idDisposition) {
        dispositionRepository.deleteById(idDisposition);
    }

    @Override
    public Optional<Disposition> findById(String idDisposition) {
        return dispositionRepository.findById(idDisposition);
    }

    @Override
    public Iterable<Disposition> findAll() {
        return dispositionRepository.findAll();
    }
}
