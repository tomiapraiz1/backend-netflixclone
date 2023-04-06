package clone.netflix.controllers;

import clone.netflix.entities.Movie;
import clone.netflix.services.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Tag(name = "Movies", description = "Movies management APIs")

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

    @GetMapping("/api/v1/movie/id={id}")
    public ResponseEntity<Movie> findOneMovieById(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @GetMapping("/api/v1/movies/name={name}")
    public ArrayList<Movie> findMoviesByName(@PathVariable String name){
        return movieService.findMoviesByName(name);
    }

    @GetMapping("/api/v1/movies/genre={genre}")
    public ArrayList<Movie> findAllMoviesByGenre(@PathVariable String genre){
        return movieService.findAllMoviesByGenre(genre);
    }


}
