package tn.stade.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateCreation= new Date();

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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
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

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Reservation(){};

    public Reservation(Date dateCreation, LocalDateTime dateDebut,LocalDateTime dateFin,Integer miTemps,Integer pause,Integer prolongation,Integer score,Integer scoreAdv,String etat){
        this.dateCreation = dateCreation;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.miTemps=miTemps;
        this.pause=pause;
        this.prolongation=prolongation;
        this.score=score;
        this.scoreAdv=scoreAdv;
        this.etat=etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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

}
