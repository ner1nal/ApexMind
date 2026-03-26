package org.tls123.apexmind.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tls123.apexmind.model.Lead;
import org.tls123.apexmind.repository.LeadRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;

    @Transactional
    public Lead save(Lead lead) {
        validate(lead);

        lead.setCreatedAt(LocalDateTime.now());
        Lead saved = leadRepository.save(lead);

        log.info("Lead saved: id={}, email={}", saved.getId(), saved.getEmail());

        return saved;
    }

    @Transactional(readOnly = true)
    public List<Lead> findAll() {
        return leadRepository.findAll(
                Sort.by(Sort.Direction.DESC, "createdAt")
        );
    }

    private void validate(Lead lead) {
        if (isBlank(lead.getName())
                || isBlank(lead.getPhone())
                || isBlank(lead.getEmail())
                || isBlank(lead.getCompany())) {

            throw new IllegalArgumentException("Заполните все обязательные поля");
        }

        if (!lead.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Некорректный email");
        }

        String digits = lead.getPhone().replaceAll("[^0-9]", "");

        if (digits.length() < 10 || digits.length() > 15) {
            throw new IllegalArgumentException("Некорректный телефон");
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
