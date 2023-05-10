package com.accountmanager.accIrembo.service.verificationService;

import com.accountmanager.accIrembo.model.UserAccount;

public interface VerificationService {

    UserAccount verify(String emailaddress);

}
