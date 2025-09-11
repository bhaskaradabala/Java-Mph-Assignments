package com.example.sportshopee.controller;


import com.example.sportshopee.entity.Login;
import com.example.sportshopee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Login login(@RequestBody Login login) {
        return loginService.login(login);
    }

    @PostMapping("/logout")
    public Login logout(@RequestParam String email) {
        return loginService.logout(email);
    }

    @PutMapping("/password")
    public String changePassword(
            @RequestParam String email,
            @RequestParam String newPassword) {
        return loginService.changePassword(email, newPassword);
    }

}
