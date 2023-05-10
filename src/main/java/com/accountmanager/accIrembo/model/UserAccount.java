package com.accountmanager.accIrembo.model;

import java.time.LocalDate;


import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

import com.accountmanager.accIrembo.enumaration.AccountState;
import com.accountmanager.accIrembo.enumaration.Gender;
import com.accountmanager.accIrembo.enumaration.MaritalStatus;
import com.accountmanager.accIrembo.enumaration.VerificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RequiredArgsConstructor

public class UserAccount {
	@Id
	@GeneratedValue(strategy=AUTO)
	private Long id;
	private String firstName;
	private String lastName;	
	private Gender gender;
	private Integer age;
	private LocalDate dob;
	private MaritalStatus maritalStatus;
	private String nationality;
	private String imageUrl;
	private VerificationStatus verificationStatus;
	private AccountState accountState;
	private String nationalIdNumber;
	private String passportNumber;
	private String verificationDocumentUrl;

//	Profile photo - use an actual image, not an avatar.

}
