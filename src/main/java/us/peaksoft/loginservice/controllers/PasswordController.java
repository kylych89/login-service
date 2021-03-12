package us.peaksoft.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.peaksoft.loginservice.services.PasswordService;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@RestController
@RequestMapping(value = "/api/v1/pwd")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/generate")
    public String generatePassword(@RequestParam String password) {
        return passwordService.generatePassword(password);
    }
}
