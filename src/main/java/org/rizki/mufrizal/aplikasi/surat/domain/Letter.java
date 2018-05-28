package org.rizki.mufrizal.aplikasi.surat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 9:38
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.domain
 * @File Letter
 */
@Entity
@Table(name = "tb_letter")
@Data
@NoArgsConstructor
public class Letter {

    @Id
    @Column(name = "id_letter", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idLetter;

    private String subject;

    @Column(name = "agenda_number")
    private String agendaNumber;

    @Column(name = "letter_number")
    private String letterNumber;

    @Column(name = "agenda_date", columnDefinition = "DATETIME")
    private LocalDateTime agendaDate;

    @Column(name = "description")
    private String description;

    @Column(name = "is_let_pass")
    private boolean isLetPass;

    @Column(name = "letter_upload")
    private String letterUpload;

    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "letter")
    private List<Disposition> dispositions;
}
