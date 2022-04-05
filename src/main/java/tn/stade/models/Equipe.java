package tn.stade.models;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NaturalIdCache

public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private Boolean estExistant;

    @OneToMany(mappedBy = "domicile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> domiciles = new ArrayList<>();

    @OneToMany(mappedBy = "exterieur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> exterieurs = new ArrayList<>();

    public Equipe(){};

    public Equipe(String nom , Boolean estExistant){
        this.nom = nom;
        this.estExistant = estExistant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipe domicile = (Equipe) o;
        return Objects.equals(nom, domicile.nom);
    }

    public void addTag(Equipe equipe) {
        Reservation reservation = new Reservation(this,equipe);
        exterieurs.add(reservation);
        equipe.getDomiciles().add(reservation);
    }

    public void removeTag(Equipe tag) {
        for (Iterator<Reservation> iterator = exterieurs.iterator();
             iterator.hasNext(); ) {
            Reservation reservation = iterator.next();

            if (reservation.getDomicile().equals(this) &&
                    reservation.getExterieur().equals(tag)) {
                iterator.remove();
                reservation.getExterieur().getDomiciles().remove(reservation);
                reservation.setDomicile(null);
                reservation.setExterieur(null);
            }
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getEstExistant() {
        return estExistant;
    }

    public void setEstExistant(Boolean estExistant) {
        this.estExistant = estExistant;
    }

    public List<Reservation> getDomiciles() {
        return domiciles;
    }

    public void setDomiciles(List<Reservation> domiciles) {
        this.domiciles = domiciles;
    }

    public List<Reservation> getExterieurs() {
        return exterieurs;
    }

    public void setExterieurs(List<Reservation> exterieurs) {
        this.exterieurs = exterieurs;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", estExistant=" + estExistant +
                ", domicile=" + domiciles +
                ", exterieur=" + exterieurs +
                '}';
    }

}
