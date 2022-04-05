package tn.stade.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Reservation {

    @EmbeddedId
    private ReservationsPk id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("domicileId")
    private Equipe domicile;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exterieurId")
    private Equipe exterieur;


    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    private Integer miTemps;

    private Integer pause;

    private Integer prolongation;

    private Integer score;

    private Integer scoreAdv;

    private String etat;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stade_id")
    private Stade stade;

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Reservation(){};
    public Reservation(Equipe equipe, Equipe equipe1){};

    public Reservation(Equipe domicile , Equipe exterieur , LocalDateTime dateDebut,LocalDateTime dateFin,Integer miTemps,Integer pause,Integer prolongation,Integer score,Integer scoreAdv,String etat){
        this.domicile = domicile;
        this.exterieur = exterieur;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.miTemps=miTemps;
        this.pause=pause;
        this.prolongation=prolongation;
        this.score=score;
        this.scoreAdv=scoreAdv;
        this.etat=etat;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Reservation that = (Reservation) o;
        return Objects.equals(domicile, that.domicile) &&
                Objects.equals(exterieur, that.exterieur);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", domicile=" + domicile +
                ", exterieur=" + exterieur +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", miTemps=" + miTemps +
                ", pause=" + pause +
                ", prolongation=" + prolongation +
                ", score=" + score +
                ", scoreAdv=" + scoreAdv +
                ", etat='" + etat + '\'' +
                ", stade=" + stade +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(domicile, exterieur);
    }

    public ReservationsPk getId() {
        return id;
    }

    public void setId(ReservationsPk id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getMiTemps() {
        return miTemps;
    }

    public void setMiTemps(Integer miTemps) {
        this.miTemps = miTemps;
    }

    public Integer getPause() {
        return pause;
    }

    public void setPause(Integer pause) {
        this.pause = pause;
    }

    public Integer getProlongation() {
        return prolongation;
    }

    public void setProlongation(Integer prolongation) {
        this.prolongation = prolongation;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScoreAdv() {
        return scoreAdv;
    }

    public void setScoreAdv(Integer scoreAdv) {
        this.scoreAdv = scoreAdv;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Equipe getDomicile() {
        return domicile;
    }

    public void setDomicile(Equipe domicile) {
        this.domicile = domicile;
    }

    public Equipe getExterieur() {
        return exterieur;
    }

    public void setExterieur(Equipe exterieur) {
        this.exterieur = exterieur;
    }
}
