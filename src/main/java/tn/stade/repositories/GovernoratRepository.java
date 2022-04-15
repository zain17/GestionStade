package tn.stade.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.stade.models.Governorat;

@Repository
public interface GovernoratRepository  extends JpaRepository<Governorat, Long> {
}
