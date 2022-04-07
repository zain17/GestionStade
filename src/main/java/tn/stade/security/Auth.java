package tn.stade.security;


import tn.stade.models.Authenticity;
import tn.stade.models.User;

import java.util.ArrayList;
import java.util.List;
/*
    Cette class contient un mock de l'utilisateur connecté avec les roles
    Elle va être supprimé une fois on a integré spring security
 */
public class Auth {
    public User currentUserAsJoueurInfo() {
        long id = 10;
        String pseudo = "joueur";
        String password = "0000";
        String nom = "test";
        String prenom = "test";
        int tel = 55555555;
        String email = "test@test.com";
        String img = "src/main/resources/static/avatar.png";

        String user_role = "USER_ROLE";
        List<Authenticity> roles = new ArrayList<>();
        User connectedUserSession = new User(id, pseudo, password, nom, prenom, tel, email, img);
        roles.add(new Authenticity(id, user_role, connectedUserSession));
        return connectedUserSession;
    }

    public User currentUserAsCapitainInfo() {
        long id = 20;
        String pseudo = "capitaine";
        String password = "0000";
        String nom = "test";
        String prenom = "test";
        int tel = 55555555;
        String email = "test@test.com";
        String img = "src/main/resources/static/avatar.png";
        String user_role = "USER_ROLE";
        String capitaine_role = "CAPITAINE_ROLE";

        List<Authenticity> roles = new ArrayList<>();
        User connectedUserSession = new User(id, pseudo, password, nom, prenom, tel, email, img);
        roles.add(new Authenticity(id, user_role, connectedUserSession));
        roles.add(new Authenticity(id, capitaine_role, connectedUserSession));

        return connectedUserSession;
    }

    public User currentUserAsArbitreInfo() {
        long id = 30;
        String pseudo = "arbitre";
        String password = "0000";
        String nom = "test";
        String prenom = "test";
        int tel = 55555555;
        String email = "test@test.com";
        String img = "src/main/resources/static/avatar.png";
        String user_role = "USER_ROLE";
        String capitaine_role = "CAPITAINE_ROLE";
        String arbitre_role = "ARBITRE_ROLE";

        List<Authenticity> roles = new ArrayList<>();
        User connectedUserSession = new User(id, pseudo, password, nom, prenom, tel, email, img);
        roles.add(new Authenticity(id, user_role, connectedUserSession));
        roles.add(new Authenticity(id, capitaine_role, connectedUserSession));
        roles.add(new Authenticity(id, arbitre_role, connectedUserSession));

        return connectedUserSession;
    }

    public User currentUserAsAdminInfo() {
        long id = 1;
        String pseudo = "admin";
        String password = "0000";
        String nom = "test";
        String prenom = "test";
        int tel = 55555555;
        String email = "test@test.com";
        String img = "src/main/resources/static/avatar.png";
        String user_role = "USER_ROLE";
        String capitaine_role = "CAPITAINE_ROLE";
        String arbitre_role = "ARBITRE_ROLE";


        List<Authenticity> roles = new ArrayList<>();
        User connectedUserSession = new User(id, pseudo, password, nom, prenom, tel, email, img);
        roles.add(new Authenticity(id, user_role, connectedUserSession));
        roles.add(new Authenticity(id, capitaine_role, connectedUserSession));
        roles.add(new Authenticity(id, arbitre_role, connectedUserSession));


        return connectedUserSession;
    }

}
