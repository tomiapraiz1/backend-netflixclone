package clone.netflix.repositories;

import clone.netflix.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE :genre MEMBER OF m.genres")
    List<Movie> findAllMoviesByGenre(@Param("genre") String genre);

    @Query("SELECT m FROM Movie m WHERE m.name LIKE %?1%")
    ArrayList<Movie> findMoviesByName(String name);
}
