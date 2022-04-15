package tn.stade.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.stade.models.Delegation;
import tn.stade.repositories.DelegationRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class Delegationcontroller {

    @Autowired
    private DelegationRepository delegationrepository;
    @GetMapping("/Delegation")
    public List<Delegation> getAllDelegation() {
        return delegationrepository.findAll();
    }

}

