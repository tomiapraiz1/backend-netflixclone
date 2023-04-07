package clone.netflix.controllers;

import clone.netflix.dtos.MovieDTO;
import clone.netflix.entities.Movie;
import clone.netflix.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Movies", description = "Movies management APIs")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(
            summary = "Create a Movie using JSON format",
            description = "Create a Movie object by specifying its id (must be null), name, duration, genres and description in JSON format. The response is Movie object with body.",
            tags = { "movie", "post" })
    @PostMapping("/create")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @Operation(
            summary = "Find all movies",
            description = "Find all movies. The response is a list of Movie object.",
            tags = { "movie", "get" })
    @GetMapping("/all")
    public ArrayList<MovieDTO> findAllMovies(){
        return movieService.findAllMovies();
    }

    @Operation(
            summary = "Delete all movies",
            description = "Delete all movies. The response is an 200 status.",
            tags = { "movie", "delete" })
    @DeleteMapping("/all")
    public ResponseEntity deleteAllMovies(){
        return movieService.deleteAllMovies();
    }


    @Operation(
            summary = "Retrive a Movie by id",
            description = "Get a Movie object by specifying its id. The response is Movie object with body.",
            tags = { "movie", "get" })
    @GetMapping("/movieid={id}")
    public ResponseEntity<MovieDTO> findOneMovieById(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @Operation(
            summary = "Delete a Movie by id",
            description = "Delete a Movie object by specifying its id. The response is Movie object with body.",
            tags = { "movie", "delete" })
    @DeleteMapping("/movieid={id}")
    public ResponseEntity<MovieDTO> deleteOneMovieById(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @Operation(
            summary = "Find all movies which contains an specified name",
            description = "Find all movie object which contains an specified name. The response is an list of Movie object with body.",
            tags = { "movie", "get" })
    @GetMapping("/moviename={name}")
    public ArrayList<MovieDTO> findMoviesByName(@PathVariable String name){
        return movieService.findMoviesByName(name);
    }

    @Operation(
            summary = "Find all movies which contains an specified genre",
            description = "Find all movie object which contains an specified genre. The response is an list of Movie object with body.",
            tags = { "movie", "get" })
    @GetMapping("/moviegenre={genre}")
    public List<MovieDTO> findAllMoviesByGenre(@PathVariable String genre){
        return movieService.findAllMoviesByGenre(genre);
    }


}
