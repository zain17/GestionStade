package tn.stade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.stade.models.Equipe;
import tn.stade.repositories.EquipeRepository;


import java.util.List;

@Service
public class EquipeService {

    @Autowired
    EquipeRepository equipeRepository;

    public void addEquipe(Equipe equipe){equipeRepository.save(equipe);}

    public List<Equipe> getAllEquipe(){return equipeRepository.findAll();}

    public Equipe findEquipeById(Long id){return equipeRepository.findById(id).get();}

    public void deleteById(Long id){equipeRepository.deleteById(id);}
}
