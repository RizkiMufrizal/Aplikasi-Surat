package org.rizki.mufrizal.aplikasi.surat.repository;

import org.rizki.mufrizal.aplikasi.surat.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 8:21 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.repository
 * @File UserRepository
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    Iterable<User> findAllByRoles(Set<String> roles);
}