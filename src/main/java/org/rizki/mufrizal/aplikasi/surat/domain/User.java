package org.rizki.mufrizal.aplikasi.surat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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

    @PrePersist
    public void onPrePersist() {
        this.setActive(Boolean.TRUE);
        this.setPassword(new BCryptPasswordEncoder().encode(this.getPassword()));
    }
}
