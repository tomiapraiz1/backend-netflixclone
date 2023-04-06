package clone.netflix.services;

import clone.netflix.entities.Movie;
import clone.netflix.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ArrayList<Movie> findAllMovies(){
        return (ArrayList<Movie>) movieRepository.findAll();
    }

    public ResponseEntity<Movie> findMovieById(Long id){
        Optional<Movie> movieResponseEntity = movieRepository.findById(id);
        if (!movieResponseEntity.isPresent()){
            log.warn("Movie with id=" + id + " not found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieResponseEntity.get());
    }

    public ArrayList<Movie> findMoviesByName(String name){
        return movieRepository.findMoviesByName(name);
    }

    public ArrayList<Movie> findAllMoviesByGenre(String genre){
        return movieRepository.findAllMoviesByGenre(genre);
    }

}
