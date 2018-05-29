package org.rizki.mufrizal.aplikasi.surat.helper.upload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 2:17 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.helper.upload
 * @File StorageProperties
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    @Getter
    @Setter
    private String location = "upload-dir";
}
