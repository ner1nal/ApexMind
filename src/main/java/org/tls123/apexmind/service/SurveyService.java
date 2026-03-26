package org.tls123.apexmind.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tls123.apexmind.dto.SurveyRequest;
import org.tls123.apexmind.model.SurveyAnswer;
import org.tls123.apexmind.repository.SurveyRepository;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    public void save(SurveyRequest request) {

        SurveyAnswer entity = SurveyAnswer.builder()
                .q1(request.getQ1())
                .q2(request.getQ2())
                .q3(request.getQ3())
                .q4(request.getQ4())
                .q5(request.getQ5())
                .q6(request.getQ6())
                .q7(request.getQ7())
                .q8(request.getQ8())
                .q9(request.getQ9())
                .q10(request.getQ10())
                .company(request.getCompany())
                .position(request.getPosition())
                .createdAt(LocalDateTime.now())
                .build();

        surveyRepository.save(entity);

        log.info("Survey submitted: company={}, position={}",
                request.getCompany(), request.getPosition());
    }
}
