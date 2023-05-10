package com.accountmanager.accIrembo.service.userAccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.accountmanager.accIrembo.model.UserAccount;
import com.accountmanager.accIrembo.repository.UserAccountRepository;

import java.util.Collection;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
	private final UserAccountRepository userAccountRepository;

	@Override
	public UserAccount create(UserAccount userAccount) {
		// TODO Auto-generated method stub
		log.info("Saving new Account User: {}", userAccount.getFirstName());
		userAccount.setImageUrl(setUserAccountImageUrl());
		return userAccountRepository.save(userAccount);
	}

	@Override
	public UserAccount get(Long id) {
		log.info("Fetching Account User by ID: {}", id);
		return userAccountRepository.findById(id).get();
	}

	@Override
	public UserAccount update(UserAccount userAccount) {
		log.info("Updating Account User: {}",  userAccount.getFirstName());
		return userAccountRepository.save(userAccount);
	}

	@Override
	public Collection<UserAccount> list(int limit) {
		log.info("Fetching all Account Users");
		return userAccountRepository.findAll(PageRequest.of(0,limit)).toList();
	}

	private String setUserAccountImageUrl() {
		String[] imageNames = {"image0","image1","image2","image3","image4"};
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/Desktop" + imageNames[new Random().nextInt(6)]).toUriString();
	}
}
