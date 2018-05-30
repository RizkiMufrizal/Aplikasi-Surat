package org.rizki.mufrizal.aplikasi.surat.service;

import org.rizki.mufrizal.aplikasi.surat.domain.User;

import java.util.Optional;
import java.util.Set;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 10:58 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service
 * @File UserService
 */
public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(String username);

    Optional<User> findById(String username);

    Iterable<User> findAll();

    Iterable<User> findAllByRoles(Set<String> roles);
}