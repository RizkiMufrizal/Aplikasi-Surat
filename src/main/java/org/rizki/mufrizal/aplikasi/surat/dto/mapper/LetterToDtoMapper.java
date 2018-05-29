package org.rizki.mufrizal.aplikasi.surat.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.rizki.mufrizal.aplikasi.surat.domain.Letter;
import org.rizki.mufrizal.aplikasi.surat.dto.LetterDto;
import org.rizki.mufrizal.aplikasi.surat.dto.mapper.custom.StringToLocalDate;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 1:54 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.dto.mapper
 * @File LetterToDtoMapper
 */
@Mapper(componentModel = "spring", uses = {StringToLocalDate.class})
public interface LetterToDtoMapper {

    @Mapping(target = "letterDate", qualifiedByName = {"StringToLocalDate", "toLocalDateTime"})
    Letter letterDtoToLetter(LetterDto letterDto);

}
