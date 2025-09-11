package com.example.sportshopee.service;

import com.example.sportshopee.entity.Login;
import com.example.sportshopee.repository.CustomerRepository;
import com.example.sportshopee.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public Login login(Login login) {
        Optional<Login> optLogin = loginRepo.findById(login.getEmail());

        if (optLogin.isPresent()) {
            Login dbLogin = optLogin.get();
            if (dbLogin.getPassword().equals(login.getPassword()) &&
                dbLogin.getRole().equals(login.getRole())) {
                dbLogin.setLogin(true);
                return loginRepo.save(dbLogin);
            }
        }
        return null; // Invalid credentials
    }

    @Override
    public Login logout(String email) {
        Optional<Login> optLogin = loginRepo.findById(email);

        if (optLogin.isPresent()) {
            Login dbLogin = optLogin.get();
            dbLogin.setLogin(false);
            return loginRepo.save(dbLogin);
        }
        return null; // Email not found
    }

    @Override
    public String changePassword(String email, String newPassword) {
        Optional<Login> optLogin = loginRepo.findById(email);

        if (optLogin.isPresent()) {
            Login dbLogin = optLogin.get();
            dbLogin.setPassword(newPassword);
            loginRepo.save(dbLogin);
            return "Password updated successfully";
        }
        return "Email not found";
    }
}
