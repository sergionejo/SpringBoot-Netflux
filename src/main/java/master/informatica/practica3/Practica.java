package master.informatica.practica3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import master.informatica.practica3.models.Cast;
import master.informatica.practica3.models.Creator;
import master.informatica.practica3.models.Highlight;
import master.informatica.practica3.models.Movie;
import master.informatica.practica3.models.Serie;
import master.informatica.practica3.models.Trailer;
import master.informatica.practica3.repositories.CastRepository;
import master.informatica.practica3.repositories.CreatorRepository;
import master.informatica.practica3.repositories.HighlightRepository;
import master.informatica.practica3.repositories.MovieRepository;
import master.informatica.practica3.repositories.SerieRepository;
import master.informatica.practica3.repositories.TrailerRepository;

@SpringBootApplication
public class Practica {

	public static void main(String[] args) {
		SpringApplication.run(Practica.class, args);
	}

	@Bean
	public CommandLineRunner init(CreatorRepository creatorRepository, CastRepository castRepository,
			TrailerRepository trailerRepository, MovieRepository movieRepository, SerieRepository serieRepository, HighlightRepository highlightRepository) {
		return (args) -> {

			Creator c = new Creator();
			c.setName("Sergio");
			creatorRepository.save(c);

			Creator cr = new Creator();
			cr.setName("Diego Armando Maradona");
			creatorRepository.save(cr);

			for (int i = 0; i < 10; i++) {
				Cast cast = new Cast();
				cast.setName("Actor " + (i + 1));
				castRepository.save(cast);
			}

			for (int i = 0; i < 10; i++) {
				Movie m = new Movie();
				m.setTitle("Pelicula " + (i + 1));
				m.setDescription("Descripcion de la pelicula");
				m.setYear(1990 + i);
				m.setDuration(100 + (i * 10));
				m.setDirector(c);
				m.setUrl("prueba");
				m.setDirector(c);
				movieRepository.save(m);

				Iterable<Cast> allCast = castRepository.findAll();
				List<Cast> addCast = new ArrayList<>();

				for (Cast cast : allCast) {
					addCast.add(cast);
				}

				m.getCast().addAll(addCast);
				movieRepository.save(m);
			}

			for (int i = 0; i < 10; i++) {
				Serie s = new Serie();
				s.setTitle("Serie " + (i + 1));
				s.setDescription("Descripcion de la serie");
				s.setYearStart(1990 + i);
				s.setYearEnd(1995 + i);
				s.setSeasons((i * 2));
				s.setUrl("prueba");
				serieRepository.save(s);

				Iterable<Cast> allCast = castRepository.findAll();
				List<Cast> addCast = new ArrayList<>();

				for (Cast cast : allCast) {
					addCast.add(cast);
				}

				s.getCast().addAll(addCast);

				s.getCreators().add(c);
				s.getCreators().add(cr);
				serieRepository.save(s);
			}

			Trailer trailer = new Trailer();
			trailer.setTitle("Trailer");
			trailer.setUrl("https://www.youtube.com/watch?v=vCzgGgIgofk");
			trailerRepository.save(trailer);

			Highlight highlight = new Highlight();
			highlight.setType("series");
			highlight.setDestacadosSeries(serieRepository.findById(3L).get());
			highlightRepository.save(highlight);

			Highlight highlight2 = new Highlight();
			highlight2.setType("peliculas");
			highlight2.setDestacadosMovies(movieRepository.findById(7L).get());
			highlightRepository.save(highlight2);
		};
	}
}
