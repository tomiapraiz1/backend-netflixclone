package clone.netflix.services;

import clone.netflix.entities.Movie;
import clone.netflix.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public ResponseEntity deleteAllMovies(){
        movieRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Movie> createMovie(Movie movie){
        if (movie.getId() != null){
            log.warn("Movie contains id and must be null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    public ResponseEntity<Movie> findMovieById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()){
            log.warn("Movie with id=" + id + " not found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieOptional.get());
    }

    public ResponseEntity<Movie> deleteMovieById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()){
            log.warn("Movie with id=" + id + " not found");
            return ResponseEntity.notFound().build();
        }
        movieRepository.deleteById(id);
        return ResponseEntity.ok(movieOptional.get());
    }

    public ArrayList<Movie> findMoviesByName(String name){
        return movieRepository.findMoviesByName(name);
    }

    public List<Movie> findAllMoviesByGenre(String genre){
        return movieRepository.findAllMoviesByGenre(genre);
    }

}
