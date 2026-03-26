package org.tls123.apexmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tls123.apexmind.model.SurveyAnswer;

public interface SurveyRepository extends JpaRepository<SurveyAnswer, Long> {
}
