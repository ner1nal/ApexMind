package org.tls123.apexmind.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tls123.apexmind.dto.SurveyRequest;
import org.tls123.apexmind.service.SurveyService;

@Controller
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping("/api/survey")
    public String submitSurvey(@ModelAttribute @Valid SurveyRequest request, BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Invalid survey");
            return "redirect:/";
        }

        surveyService.save(request);
        redirectAttributes.addFlashAttribute("surveySuccess", true);

        return "redirect:/";
    }
}