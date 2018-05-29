package org.rizki.mufrizal.aplikasi.surat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 8:42 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.dto
 * @File DispositionDto
 */
@Data
@NoArgsConstructor
public class DispositionDto {

    private String idDisposition;

    private String dispositionDate;

    private String dispositionFrom;

    private String dispositionTo;

    private boolean isDisposition;

    private String letterDto;

}