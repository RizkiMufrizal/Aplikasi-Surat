package org.rizki.mufrizal.aplikasi.surat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 9:38
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.domain
 * @File Disposition
 */
@Entity
@Table(name = "tb_disposition")
@Data
@NoArgsConstructor
public class Disposition {

    @Id
    @Column(name = "id_disposition", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idDisposition;

    @Column(name = "disposition_date", columnDefinition = "DATETIME")
    private LocalDateTime dispositionDate;

    @Column(name = "disposition_to")
    private String dispositionTo;

    @Column(name = "is_disposition")
    private boolean isDisposition;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_letter", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Letter letter;
}
