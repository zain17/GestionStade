package tn.stade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.stade.models.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
}
