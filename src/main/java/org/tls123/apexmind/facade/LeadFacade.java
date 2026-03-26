package org.tls123.apexmind.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tls123.apexmind.model.Lead;
import org.tls123.apexmind.service.EmailService;
import org.tls123.apexmind.service.LeadService;

@Service
@RequiredArgsConstructor
public class LeadFacade {

    private final LeadService leadService;
    private final EmailService emailService;

    public void createLead(Lead lead) {
        Lead saved = leadService.save(lead);
        emailService.sendLeadNotification(saved);
    }
}
