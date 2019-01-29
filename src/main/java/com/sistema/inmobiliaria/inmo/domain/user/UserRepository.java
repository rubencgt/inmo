package com.sistema.inmobiliaria.inmo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
