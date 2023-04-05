package clone.netflix.repositories;

import clone.netflix.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.genres LIKE %?1%")
    ArrayList<Movie> findAllMoviesByGenre(String genre);

    @Query("SELECT m FROM Movie m WHERE m.name LIKE %?1%")
    ArrayList<Movie> findMoviesByName(String name);
}
