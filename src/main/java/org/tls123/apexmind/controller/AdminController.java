package org.tls123.apexmind.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tls123.apexmind.facade.AdminFacade;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminFacade adminFacade;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("leads", adminFacade.getAllLeads());
        return "admin";
    }

    @GetMapping("/admin/stats")
    public String stats(Model model) {
        model.addAttribute("stats", adminFacade.getStats());
        return "stats";
    }
}
