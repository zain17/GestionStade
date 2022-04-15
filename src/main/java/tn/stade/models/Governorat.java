package tn.stade.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
public class Governorat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nomGovernorat;
    @OneToMany(fetch = FetchType.EAGER)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Delegation> delegation;


    public Governorat() {

    }
    public Governorat(long id, String nomGovernorat, List<Delegation> delegation) {
        this.id = id;
        this.nomGovernorat = nomGovernorat;
        this.delegation = delegation;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomGovernorat() {
        return nomGovernorat;
    }

    public void setNomGovernorat(String nomGovernorat) {
        this.nomGovernorat = nomGovernorat;
    }

    public List<Delegation> getDelegation() {
        return delegation;
    }

    public void setDelegation(List<Delegation> delegation) {
        this.delegation = delegation;
    }
}
