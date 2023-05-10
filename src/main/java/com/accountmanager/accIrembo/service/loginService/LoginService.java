package com.accountmanager.accIrembo.service.loginService;


import com.accountmanager.accIrembo.model.Username;
import org.apache.catalina.User;

public interface LoginService {

    Username authenticateUser(String email, String password);

    String generateJwtToken(Username username);

    Username validateJwtToken(String token);

}
