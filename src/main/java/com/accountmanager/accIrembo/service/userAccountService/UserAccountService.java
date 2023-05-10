package com.accountmanager.accIrembo.service.userAccountService;

import com.accountmanager.accIrembo.model.UserAccount;

import java.util.Collection;

public interface UserAccountService {
	
	UserAccount create(UserAccount userAccount);
	UserAccount get(Long id);
	UserAccount update(UserAccount userAccount);
	Collection<UserAccount> list(int limit);
}
