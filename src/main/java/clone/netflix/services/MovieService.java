package clone.netflix.services;

import clone.netflix.dtos.MovieDTO;
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
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieDTOMapper movieDTOMapper;
    private final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieDTOMapper movieDTOMapper) {
        this.movieRepository = movieRepository;
        this.movieDTOMapper = movieDTOMapper;
    }

    public ArrayList<MovieDTO> findAllMovies(){
        return (ArrayList<MovieDTO>) movieRepository.findAll()
                .stream()
                .map(movieDTOMapper)
                .toList();
    }

    public ResponseEntity deleteAllMovies(){
        movieRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<MovieDTO> createMovie(Movie movie){
        if (movie.getId() != null){
            log.warn("Movie contains id and must be null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(movieDTOMapper.apply(movieRepository.save(movie)));
    }

    public ResponseEntity<MovieDTO> findMovieById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()){
            log.warn("Movie with id=" + id + " not found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDTOMapper.apply(movieOptional.get()));
    }

    public ResponseEntity<MovieDTO> deleteMovieById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()){
            log.warn("Movie with id=" + id + " not found");
            return ResponseEntity.notFound().build();
        }
        movieRepository.deleteById(id);
        return ResponseEntity.ok(movieDTOMapper.apply(movieOptional.get()));
    }

    public ArrayList<MovieDTO> findMoviesByName(String name){
        return (ArrayList<MovieDTO>) movieRepository.findMoviesByName(name)
                .stream()
                .map(movieDTOMapper)
                .toList();
    }

    public List<MovieDTO> findAllMoviesByGenre(String genre){
        return movieRepository.findAllMoviesByGenre(genre)
                .stream()
                .map(movieDTOMapper)
                .toList();
    }

}
