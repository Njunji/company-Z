package com.accountmanager.accIrembo.repository;

import com.accountmanager.accIrembo.model.Username;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernameRepository extends JpaRepository <UsernameRepository, String> {
    Username findByEmail(String email);
}
