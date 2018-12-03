package master.informatica.practica3.repositories;

import org.springframework.data.repository.CrudRepository;

import master.informatica.practica3.models.Movie;

/**
 * MovieRepository
 */
public interface MovieRepository extends CrudRepository<Movie, Long>{

    
}