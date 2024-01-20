package br.com.vpayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.vpayroll.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

    User findByVerificationCode(String verificationCode);

}
