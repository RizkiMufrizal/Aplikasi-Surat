package org.rizki.mufrizal.aplikasi.surat.service.impl;

import org.rizki.mufrizal.aplikasi.surat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 28 May 2018
 * @Time 8:22 PM
 * @Project Aplikasi-Surat
 * @Package org.rizki.mufrizal.aplikasi.surat.service.impl
 * @File UserAuthenticationService
 */
@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<org.rizki.mufrizal.aplikasi.surat.domain.User> userOptional = userRepository.findById(username);

        if (userOptional.isPresent()) {
            List<GrantedAuthority> authorities = buildUserAuthority(userOptional.get().getRoles());
            return buildUserForAuthentication(userOptional.get(), authorities);
        }
        return null;
    }

    private User buildUserForAuthentication(org.rizki.mufrizal.aplikasi.surat.domain.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<String> userRoles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        userRoles.forEach((userRole) -> grantedAuthorities.add(new SimpleGrantedAuthority(userRole)));
        return new ArrayList<>(grantedAuthorities);
    }


}
