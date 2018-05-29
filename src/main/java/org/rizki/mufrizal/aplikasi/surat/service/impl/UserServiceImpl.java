package org.rizki.mufrizal.aplikasi.surat.service.impl;

import org.rizki.mufrizal.aplikasi.surat.domain.User;
import org.rizki.mufrizal.aplikasi.surat.repository.UserRepository;
import org.rizki.mufrizal.aplikasi.surat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 11:04 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service.impl
 * @File UserServiceImpl
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User userOld = userRepository.findById(user.getUsername()).orElse(user);
        if (!userOld.getPassword().equals(user.getPassword())) {
            if (!bCryptPasswordEncoder.matches(user.getPassword(), userOld.getPassword())) {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
        }
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public Optional<User> findById(String username) {
        return userRepository.findById(username);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
