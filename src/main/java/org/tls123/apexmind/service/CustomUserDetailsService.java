package org.tls123.apexmind.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tls123.apexmind.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("User authenticated: {}", username);

        return userRepository.findByUsername(username).map(user -> User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles("ADMIN")
                        .build()
                )
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
