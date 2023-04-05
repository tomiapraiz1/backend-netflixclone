package clone.netflix.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int duration;
    @ElementCollection
    private ArrayList<String> genres;
    private String description;

    public Movie(Long id, String name, int duration, ArrayList<String> genres, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.genres = genres;
        this.description = description;
    }

    public Movie() {
    }
}
