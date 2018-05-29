package org.rizki.mufrizal.aplikasi.surat.helper.upload;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 2:14 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.helper.upload
 * @File StorageService
 */
public interface StorageService {
    void init();

    String store(MultipartFile multipartFile);

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteFile(String filename);
}
