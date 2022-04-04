package tn.stade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.stade.models.Reservation;
import tn.stade.repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public void addReservation(Reservation reservation){reservationRepository.save(reservation);}

    public List<Reservation>getAllReservation(){return reservationRepository.findAll();}

    public Reservation findReservationById(Long id){return reservationRepository.findById(id).get();}

    public void deleteReservation(Long id){reservationRepository.deleteById(id);}
}
