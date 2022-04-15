package tn.stade.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.stade.models.Governorat;
import tn.stade.repositories.GovernoratRepository;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class Governoratcontroller {

    @Autowired
    private GovernoratRepository governoratrepository;
    @GetMapping("/Governorat")
    public List<Governorat> getAllGovernorat() {
        return governoratrepository.findAll();
    }

}

