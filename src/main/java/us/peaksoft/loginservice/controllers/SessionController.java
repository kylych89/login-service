package us.peaksoft.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.loginservice.models.dto.SessionDto;
import us.peaksoft.loginservice.services.SessionService;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@RestController
@RequestMapping(value = "/api/v1/session")
public class SessionController {


    @Autowired
    private SessionService sessionService;

    @GetMapping("/auth")
    public SessionDto auth(@RequestParam String login, @RequestParam String password) {
        return sessionService.login(login, password);
    }

    @GetMapping("/out")
    public boolean logOut(@RequestHeader("auth") String auth) {
        return sessionService.closeSession(auth);
    }

    @GetMapping("/check")
    public boolean checkSession(@RequestHeader("auth") String auth) {
        return sessionService.findSessionByToken(auth) != null;
    }

}
