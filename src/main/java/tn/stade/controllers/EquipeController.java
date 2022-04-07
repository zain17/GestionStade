package tn.stade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.stade.exceptions.ResourceNotFoundException;
import tn.stade.models.Equipe;
import tn.stade.services.EquipeService;

import java.util.List;

@RestController
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @GetMapping(value = "equipe")
    public List<Equipe> getAllEquipe(){return equipeService.getAllEquipe();}

    @PostMapping(value = "equipe/add")
    public void addEquipe(@RequestBody Equipe equipe){equipeService.addEquipe(equipe);}

    @DeleteMapping(value = "equipe/{id}")
    public void deleteEquipe(@PathVariable Long id){equipeService.deleteById(id);}

    @GetMapping(value = "equipe/{id}")
    public Equipe findById(@PathVariable Long id){return equipeService.findEquipeById(id);}

    @PutMapping(value = "/equipe/{id}")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe, @PathVariable(value = "id") Long equipeId){
        Equipe existantEquipe = equipeService.findEquipeById(equipeId);
        if (existantEquipe == null){
            new ResourceNotFoundException("equipe not found for the id :" + equipeId);
        }else {
            existantEquipe.setNom(equipe.getNom());
            existantEquipe.setEstExistant(equipe.getEstExistant());
            equipeService.addEquipe(existantEquipe);
        }
        return ResponseEntity.ok(existantEquipe);
    }
}
