package org.rizki.mufrizal.aplikasi.surat.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.rizki.mufrizal.aplikasi.surat.domain.Disposition;
import org.rizki.mufrizal.aplikasi.surat.dto.DispositionDto;
import org.rizki.mufrizal.aplikasi.surat.dto.mapper.custom.StringToLocalDate;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 8:44 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.dto.mapper
 * @File DispositionToDtoMapper
 */
@Mapper(componentModel = "spring", uses = {StringToLocalDate.class})
public interface DispositionToDtoMapper {

    @Mappings({
            @Mapping(target = "dispositionDate", qualifiedByName = {"StringToLocalDate", "toLocalDateTime"}),
            @Mapping(target = "letter.idLetter", source = "letterDto")
    })
    Disposition dispositionDtoToDisposition(DispositionDto dispositionDto);

    @Mappings({
            @Mapping(target = "dispositionDate", qualifiedByName = {"StringToLocalDate", "toStringLocalDateTime"}),
            @Mapping(target = "letterDto", source = "letter.idLetter")
    })
    DispositionDto dispositionToDispositionDto(Disposition disposition);

}
