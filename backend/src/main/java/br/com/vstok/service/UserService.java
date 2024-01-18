package br.com.vstok.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vstok.dto.user.UserRequest;
import br.com.vstok.dto.user.UserResponse;
import br.com.vstok.model.User;
import br.com.vstok.repository.UserRepository;
import br.com.vstok.service.exceptions.RegisterException;
import br.com.vstok.utils.RandomCode;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public UserResponse registerUser(UserRequest userRequest) {

        User newUser = new UserRequest(userRequest.name(), userRequest.email(), userRequest.password(),
                userRequest.role()).convert(userRequest);

        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            throw new RegisterException("Esse email já está cadastrado.");
        } else {
            String encodedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encodedPassword);
            newUser.setEnabled(false);
            String code = RandomCode.generateRandomString(64);
            newUser.setVerificationCode(code);
            User saveUser = userRepository.save(newUser);

            Map<String, Object> email = new HashMap<>();
            email.put("name", newUser.getName());
            email.put("message", "http://localhost:8080/user/verify?code=" + newUser.getVerificationCode());
            emailService.sendEmailCode(newUser.getEmail(), "Ative sua conta", "Vstok", email);
            UserResponse userResponse = new UserResponse(newUser.getId(), newUser.getName(), newUser.getEmail(),
                    newUser.getPassword(), newUser.getRole());
            return userResponse;
        }
    }

    public boolean verifyUser(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;

        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);
            return true;
        }
    }
}
