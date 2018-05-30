package org.rizki.mufrizal.aplikasi.surat.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 29 May 2018
 * @Time 4:27 AM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.util
 * @File SetOfRoles
 */
public class SetOfRoles {
    public static Set<String> getRoles() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("ROLE_ADMIN");
        stringSet.add("ROLE_PIMPINAN");
        stringSet.add("ROLE_KEPALA_BAGIAN");
        return stringSet;
    }
}