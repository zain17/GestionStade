package tn.stade.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.stade.models.Delegation;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {
}
