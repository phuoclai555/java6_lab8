package com.nhom1.java6.Config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.extras.springsecurity6.auth.Authorization;

@ControllerAdvice
public class GeneralAdvice {
    @ModelAttribute
    public void getRequest(Model model, HttpServletRequest req, Authentication auth) {
        model.addAttribute("request",req);
    }
}
