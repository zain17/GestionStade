package tn.stade.repositories;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.stade.models.User;


@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findByPseudo(String name);

    Optional<User> findByEmail(String email);
}