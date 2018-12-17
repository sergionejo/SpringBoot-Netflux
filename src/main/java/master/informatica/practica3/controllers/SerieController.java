package master.informatica.practica3.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import master.informatica.practica3.exceptions.NotFoundException;
import master.informatica.practica3.models.Serie;
import master.informatica.practica3.repositories.SerieRepository;


/**
 * SerieController
 */
@RestController
public class SerieController {

    @Autowired
    private SerieRepository repository;

    @GetMapping(value="/series/novedades")
    public Iterable<Serie> novedades() {
        return repository.findAll();
    }

    @GetMapping(value="/series/{id}")
    public Serie serie(@PathVariable(value="id") String id) {
        
        Long idLong = Long.parseLong(id);
        
        Optional<Serie> encontrada = repository.findById(idLong);

        if(encontrada.isPresent()) {
            return encontrada.get();
        }
        else {
            throw new NotFoundException();
        }
    }
    
    
}