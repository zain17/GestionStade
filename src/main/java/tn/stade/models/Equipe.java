package tn.stade.models;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private Boolean estExistant;

    public Equipe(){};

    public Equipe(String nom , Boolean estExistant){
        this.nom = nom;
        this.estExistant = estExistant;
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

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", estExistant=" + estExistant +
                '}';
    }
}
