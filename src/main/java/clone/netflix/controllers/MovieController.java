package clone.netflix.controllers;

import clone.netflix.entities.Movie;
import clone.netflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/v1/movies")
    public ArrayList<Movie> findAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/api/v1/movie/{id}")
    public ResponseEntity<Movie> findOneMovieById(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @GetMapping("/api/v1/movie/{name}")
    public ResponseEntity<Movie> findOneMovieById(@PathVariable String name){
        return movieService.findMovieByName(name);
    }

    @GetMapping("/api/v1/movies/{genre}")
    public ArrayList<Movie> findAllMoviesByGenre(String genre){
        return movieService.findAllMoviesByGenre(genre);
    }


}
