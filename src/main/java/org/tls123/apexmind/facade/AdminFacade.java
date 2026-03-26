package org.tls123.apexmind.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tls123.apexmind.model.Lead;
import org.tls123.apexmind.service.LeadService;
import org.tls123.apexmind.service.SurveyStatsService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminFacade {

    private final LeadService leadService;
    private final SurveyStatsService surveyStatsService;

    public List<Lead> getAllLeads() {
        return leadService.findAll();
    }

    public Map<String, Double> getStats() {
        return surveyStatsService.getAverageStats();
    }
}
