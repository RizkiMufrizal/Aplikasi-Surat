package org.rizki.mufrizal.aplikasi.surat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 1:51 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.dto
 * @File LetterDto
 */
@Data
@NoArgsConstructor
public class LetterDto {
    private String idLetter;

    private String subject;

    private String agendaNumber;

    private String letterNumber;

    private String letterDate;

    private String description;

    private boolean isLetPass;

    private String letterUpload;
}
