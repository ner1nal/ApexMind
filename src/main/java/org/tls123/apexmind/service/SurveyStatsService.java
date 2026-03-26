package org.tls123.apexmind.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tls123.apexmind.model.SurveyAnswer;
import org.tls123.apexmind.repository.SurveyRepository;

import java.util.*;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SurveyStatsService {

    private final SurveyRepository surveyRepository;

    @Transactional(readOnly = true)
    public Map<String, Double> getAverageStats() {

        List<SurveyAnswer> all = surveyRepository.findAll();

        if (all.isEmpty()) {
            return Map.of();
        }

        Map<String, Double> result = new LinkedHashMap<>();

        result.put("q1", avg(all, SurveyAnswer::getQ1));
        result.put("q2", avg(all, SurveyAnswer::getQ2));
        result.put("q3", avg(all, SurveyAnswer::getQ3));
        result.put("q4", avg(all, SurveyAnswer::getQ4));
        result.put("q5", avg(all, SurveyAnswer::getQ5));
        result.put("q6", avg(all, SurveyAnswer::getQ6));
        result.put("q7", avg(all, SurveyAnswer::getQ7));
        result.put("q8", avg(all, SurveyAnswer::getQ8));
        result.put("q9", avg(all, SurveyAnswer::getQ9));
        result.put("q10", avg(all, SurveyAnswer::getQ10));

        return result;
    }

    private double avg(List<SurveyAnswer> list, Function<SurveyAnswer, Integer> f) {
        return list.stream()
                .map(f)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}