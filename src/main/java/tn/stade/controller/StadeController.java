package tn.stade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.stade.exception.ResourceNotFoundException;
import tn.stade.models.Stade;
import tn.stade.services.StadeService;

import java.util.List;

@RestController
public class StadeController {

    @Autowired
    StadeService stadeService;

    @GetMapping(value = "stades")
    public List<Stade>getAllStades(){return stadeService.getAllStades();}

    @PostMapping(value = "stades/add")
    public void addStade(@RequestBody Stade stade){stadeService.addStade(stade);}

    @DeleteMapping(value = "stades/{id}")
    public void deleteStade(@PathVariable Long id){stadeService.deleteById(id);}

    @GetMapping(value = "stades/{id}")
    public Stade findById(@PathVariable Long id){return stadeService.findStadeById(id);}

    @PutMapping(value = "/stades/{id}")
    public ResponseEntity<Stade> updateStade(@RequestBody Stade stade, @PathVariable(value = "id") Long stadeId){
        Stade existantStade = stadeService.findStadeById(stadeId);
        if (existantStade == null){
            new ResourceNotFoundException("employee not found for the id :" + stadeId);
        }else {
            existantStade.setReference(stade.getReference());
            stadeService.addStade(existantStade);
        }
        return ResponseEntity.ok(existantStade);
    }
}
