package org.rizki.mufrizal.aplikasi.surat.configuration;

import org.rizki.mufrizal.aplikasi.surat.domain.User;
import org.rizki.mufrizal.aplikasi.surat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 8:45 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.configuration
 * @File ScheduledTaskConfiguration
 */
@EnableScheduling
@Component
public class ScheduledTaskConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Scheduled(fixedRate = 3600000)
    public void insertDefaultUserAdministrator() {
        if (!userRepository.findById("admin").isPresent()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setActive(Boolean.TRUE);
            user.setPosition("admin");

            Set<String> roles = new HashSet<>();
            roles.add("ROLE_ADMIN");

            user.setRoles(roles);

            userRepository.save(user);
        }
    }
}
