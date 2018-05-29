package org.rizki.mufrizal.aplikasi.surat.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 2:01 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.helper
 * @File DateFormatterHelper
 */
public class DateFormatterHelper {
    public static LocalDateTime fromStringToLocalDateTime(String date, String pattern) {
        System.out.println("ini tanggal " + date);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        //return LocalDateTime.parse(date, dateTimeFormatter);
        return LocalDateTime.now();
    }
}
