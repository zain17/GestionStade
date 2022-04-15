package tn.stade.models;


import javax.persistence.*;

@Entity

public class Delegation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nomDelegation;



    @ManyToOne(cascade =CascadeType.ALL ,fetch= FetchType.LAZY)

    private Governorat governorat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomDelegation() {
        return nomDelegation;
    }

    public void setNomDelegation(String nomDelegation) {
        this.nomDelegation = nomDelegation;
    }

    public Governorat getGovernorat() {
        return governorat;
    }

    public void setGovernorat(Governorat governorat) {
        this.governorat = governorat;
    }

    public Delegation(long id, String nomDelegation, Governorat governorat) {
        this.id = id;
        this.nomDelegation = nomDelegation;
        this.governorat = governorat;
    }

    public Delegation() {
    }
}
