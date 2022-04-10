package tn.stade.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pseudo;
    private String password;
    private String nom;
    private String prenom;
    private int telephone;
    private String email;
    private String imageUrl;
    @Column(nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDateTime date = LocalDateTime.now();
    @OneToMany
    @JsonManagedReference
    private List<Notification> notifications;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER)
    private List<Authenticity> roles;

    @ManyToOne
    private Equipe equipe;

    public User(Long id, String pseudo, String password, String nom, String prenom, int telephone, String email, String imageUrl) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
