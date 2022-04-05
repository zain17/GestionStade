package tn.stade.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ReservationsPk implements Serializable {

    @Column(name = "domicile_id")
    private Long domicileId;

    @Column(name = "exterieur_id")
    private Long exterieurId;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_on")
    private Date dateCreation= new Date();

    public ReservationsPk() {}

    public ReservationsPk(
            Long postId,
            Long tagId) {
        this.domicileId = postId;
        this.exterieurId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ReservationsPk that = (ReservationsPk) o;
        return Objects.equals(domicileId, that.domicileId) &&
                Objects.equals(exterieurId, that.exterieurId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domicileId, exterieurId);
    }

    public Long getDomicileId() {
        return domicileId;
    }

    public void setDomicileId(Long domicileId) {
        this.domicileId = domicileId;
    }

    public Long getExterieurId() {
        return exterieurId;
    }

    public void setExterieurId(Long exterieurId) {
        this.exterieurId = exterieurId;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "reservationsFk{" +
                "domicileId=" + domicileId +
                ", exterieurId=" + exterieurId +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
