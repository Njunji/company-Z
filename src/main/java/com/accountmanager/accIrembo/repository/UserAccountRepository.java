package com.accountmanager.accIrembo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountmanager.accIrembo.model.UserAccount;

public interface UserAccountRepository extends JpaRepository <UserAccount, Long> {
}
