package tn.stade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.stade.models.Stade;

public interface StadeRepository extends JpaRepository<Stade,Long> {
}
