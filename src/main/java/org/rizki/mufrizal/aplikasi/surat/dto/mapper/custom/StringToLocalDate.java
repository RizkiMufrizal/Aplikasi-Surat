package org.rizki.mufrizal.aplikasi.surat.dto.mapper.custom;

import org.mapstruct.Named;
import org.rizki.mufrizal.aplikasi.surat.helper.DateFormatterHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 3:42 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.dto.mapper.custom
 * @File StringToLocalDate
 */
@Component
@Named("StringToLocalDate")
public class StringToLocalDate {

    @Named("toLocalDateTime")
    public LocalDateTime toLocalDateTime(String letterDate) {
        return DateFormatterHelper.fromStringToLocalDateTime(letterDate, "yyyy-MM-dd HH:mm:ss");
    }

    @Named("toStringLocalDateTime")
    public LocalDateTime toStringLocalDateTime(LocalDateTime localDateTime) {
        return DateFormatterHelper.fromStringToLocalDateTime(localDateTime.toString(), "yyyy-MM-dd HH:mm:ss");
    }

}
