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
 * @Time 9:37
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.domain
 * @File UserRole
 */
@Entity
@Table(name = "tb_user_role")
@Data
@NoArgsConstructor
public class UserRole {
    @Id
    @Column(name = "id_user_role", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idUserRole;

    @Column(name = "role", length = 15, nullable = false)
    private String role;

    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user;
}
