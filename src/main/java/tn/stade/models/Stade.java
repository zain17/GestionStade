package tn.stade.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@Getter
@Setter
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Length(min = 3)
    private String reference;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "reservations", referencedColumnName = "id")
    private List<Reservation> reservationsList;

    public Stade() {
    }

    ;


    public Stade(String reference) {
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Reservation> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<Reservation> reservationsList) {
        this.reservationsList = reservationsList;
    }

    @Override
    public String toString() {
        return "Stade{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", reservationsList=" + reservationsList +
                '}';
    }
}
