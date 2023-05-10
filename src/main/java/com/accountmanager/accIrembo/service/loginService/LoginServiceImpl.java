package com.accountmanager.accIrembo.service.loginService;

import com.accountmanager.accIrembo.model.UserAccount;
import com.accountmanager.accIrembo.model.Username;
import com.accountmanager.accIrembo.repository.UserAccountRepository;
import com.accountmanager.accIrembo.repository.UsernameRepository;
import com.accountmanager.accIrembo.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService{
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UsernameRepository usernameRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public Username authenticateUser(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return new Username(userDetails.getUsername(), userDetails.getPassword(), (List<GrantedAuthority>) userDetails.getAuthorities());
    }

    @Override
    public String generateJwtToken(Username username) {
        return jwtTokenUtil.generateToken(username);
    }

    @Override
    public Username validateJwtToken(String token) {
        String email = jwtTokenUtil.getUsernameFromToken(token);
        Username username = usernameRepository.findByEmail(email);

        if (jwtTokenUtil.validateToken(token, username)) {
            return username;
        } else {
            return null;
        }
    }

}
