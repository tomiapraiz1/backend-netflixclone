package clone.netflix.services;

import clone.netflix.dtos.MovieDTO;
import clone.netflix.dtos.UserDTO;
import clone.netflix.entities.Movie;
import clone.netflix.entities.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MovieDTOMapper implements Function<Movie, MovieDTO> {

    @Override
    public MovieDTO apply(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getName(),
                movie.getDuration(),
                movie.getGenres()
                        .stream()
                        .map(String -> String
                        ).toList(),
                movie.getDescription()
        );
    }
}
