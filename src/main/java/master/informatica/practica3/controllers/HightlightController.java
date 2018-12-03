package master.informatica.practica3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import master.informatica.practica3.models.Highlight;
import master.informatica.practica3.repositories.HighlightRepository;


/**
 * HightlightController
 */
@RestController
public class HightlightController {

    @Autowired
    private HighlightRepository repository;

    @GetMapping(value="/destacados")
    public Iterable<Highlight> destacados() {
        return repository.findAll();
    }
    
}