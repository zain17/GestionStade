package tn.stade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.stade.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
