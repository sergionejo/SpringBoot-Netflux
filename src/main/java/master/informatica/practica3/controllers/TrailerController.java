package master.informatica.practica3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import master.informatica.practica3.models.Trailer;
import master.informatica.practica3.repositories.TrailerRepository;


/**
 * TrailerController
 */
@RestController
public class TrailerController {

    @Autowired
    private TrailerRepository repository;

    @GetMapping(value="/trailers")
    public Iterable<Trailer> trailers() {
        return repository.findAll();
    }
}