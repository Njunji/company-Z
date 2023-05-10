package com.accountmanager.accIrembo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoginRequest {

        @Id
        @GeneratedValue(strategy=AUTO)
        private Long id;
        private String userName;
        private String password;
}
