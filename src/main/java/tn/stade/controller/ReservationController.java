package tn.stade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.stade.exception.ResourceNotFoundException;
import tn.stade.models.Reservation;
import tn.stade.models.Stade;
import tn.stade.services.ReservationService;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "reservation")
    public List<Reservation> getAllReservation(){return reservationService.getAllReservation();}

    @PostMapping(value = "reservation/add")
    public void addReservation(@RequestBody Reservation reservation){reservationService.addReservation(reservation);}

    @DeleteMapping(value = "reservation/{id}")
    public void deleteReservation(@PathVariable Long id){reservationService.deleteReservation(id);}

    @GetMapping(value = "reservation/{id}")
    public Reservation findById(@PathVariable Long id){return reservationService.findReservationById(id);}

    @PutMapping(value = "/reservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation, @PathVariable(value = "id") Long reservationId){
        Reservation existantReservation = reservationService.findReservationById(reservationId);
        if (existantReservation == null){
            new ResourceNotFoundException("reservation not found for the id :" + reservationId);
        }else {
            existantReservation.setDateCreation(reservation.getDateCreation());
            existantReservation.setDateDebut(reservation.getDateDebut());
            existantReservation.setDateFin(reservation.getDateFin());
            existantReservation.setMiTemps(reservation.getMiTemps());
            existantReservation.setPause(reservation.getPause());
            existantReservation.setProlongation(reservation.getProlongation());
            existantReservation.setEtat(reservation.getEtat());
            reservationService.addReservation(existantReservation);
        }
        return ResponseEntity.ok(existantReservation);
    }
}
