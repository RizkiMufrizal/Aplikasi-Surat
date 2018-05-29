package org.rizki.mufrizal.aplikasi.surat.helper.security;

import org.springframework.security.core.Authentication;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 10:10 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.helper.security
 * @File AuthenticationSessionFacade
 */
public interface AuthenticationSessionFacade {
    Authentication getAuthentication();

    String getUsername();
}