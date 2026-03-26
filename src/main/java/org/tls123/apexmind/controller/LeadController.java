package org.tls123.apexmind.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tls123.apexmind.facade.LeadFacade;
import org.tls123.apexmind.model.Lead;

@Controller
@RequiredArgsConstructor
public class LeadController {

    private final LeadFacade leadFacade;

    @PostMapping("/api/lead")
    public String submitLead(@Valid Lead lead, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Invalid form data");
            return "redirect:/#lead";
        }

        leadFacade.createLead(lead);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:/#lead";
    }
}
