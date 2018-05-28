package org.rizki.mufrizal.aplikasi.surat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 9:37
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.domain
 * @File User
 */
@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private boolean isActive;

    private String position;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "username"))
    @Column(name = "roles")
    private Set<String> roles;

}
