package com.accountmanager.accIrembo.service.authService;

import jakarta.servlet.http.HttpServletRequest;
import com.accountmanager.accIrembo.model.AuthModel;

public interface AuthService {

    AuthModel login (String userName, String password);
    AuthModel logout (HttpServletRequest request);
    AuthModel resetPassword (String username, String oldPassword, String newPassword);
}
