package br.com.vpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.vpayroll.exceptions.auth.LoginException;
import br.com.vpayroll.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userRepository.findByEmail(username) == null) {
            throw new LoginException("Usuário não encontrado");
        } else {
            return userRepository.findByEmail(username);
        }
    }
}
