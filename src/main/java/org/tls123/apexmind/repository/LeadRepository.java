package org.tls123.apexmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tls123.apexmind.model.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
}
