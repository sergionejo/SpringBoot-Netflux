package master.informatica.practica3.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import master.informatica.practica3.exceptions.NotFoundException;
import master.informatica.practica3.models.Movie;
import master.informatica.practica3.repositories.MovieRepository;


/**
 * MovieController
 */
@RestController
public class MovieController  {

    @Autowired
    private MovieRepository repository;

    @GetMapping(value="/peliculas/novedades")
    public Iterable<Movie> novedades() {
        return repository.findAll();
    }
    
    @GetMapping(value="/peliculas/{id}")
    public Movie pelicula(@PathVariable(value="id") String id) {

        Long idLong = Long.parseLong(id); 

        Optional<Movie> encontrada = repository.findById(idLong);

        if(encontrada.isPresent()) {
            return encontrada.get();
        }
        else {
            throw new NotFoundException();
        }
    }  
}