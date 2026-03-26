package org.tls123.apexmind;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.tls123.apexmind.model.User;
import org.tls123.apexmind.repository.UserRepository;

@SpringBootApplication
public class ApexMindApplication {

    @Value("${APP_ADMIN_USERNAME}")
    private String username;

    @Value("${APP_ADMIN_PASSWORD}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(ApexMindApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername(username).isEmpty()) {
                repo.save(User.builder()
                        .username(username)
                        .password(encoder.encode(password))
                        .build());
            }
        };
    }

}
