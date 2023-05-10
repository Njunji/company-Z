package com.accountmanager.accIrembo.service.authService;

import jakarta.servlet.http.HttpServletRequest;
import com.accountmanager.accIrembo.model.AuthModel;


public class AuthServiceImpl implements AuthService {

    @Override
    public AuthModel login(String userName, String password) {
        return null;
    }

    @Override
    public AuthModel logout(HttpServletRequest request) {
        return null;
    }

    @Override
    public AuthModel resetPassword(String username, String oldPassword, String newPassword) {
        return null;
    }
}