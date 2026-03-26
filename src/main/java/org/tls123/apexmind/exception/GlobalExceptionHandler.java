package org.tls123.apexmind.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleValidation(Exception ex, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("error", ex.getMessage());

        return "redirect:/#lead";
    }
}