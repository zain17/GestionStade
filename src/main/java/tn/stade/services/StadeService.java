package tn.stade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.stade.models.Stade;
import tn.stade.repositories.StadeRepository;

import java.util.List;

@Service
public class StadeService {

    @Autowired
    StadeRepository stadeRepository;

    public void addStade(Stade stade){stadeRepository.save(stade);}

    public List<Stade>getAllStades(){return stadeRepository.findAll();}

    public Stade findStadeById(Long id){return stadeRepository.findById(id).get();}

    public void deleteById(Long id){stadeRepository.deleteById(id);}

}
