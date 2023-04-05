package clone.netflix;

import clone.netflix.entities.Movie;
import clone.netflix.repositories.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class NetflixApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(NetflixApplication.class, args);
		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);

		String genre1 = "Action;Drama";
		String genre2 = "Terror";
		Movie movieAction = new Movie(null, "Boca River", 100, genre1, "");
		Movie movieTerror = new Movie(null, "River", 100, genre2, "");

		movieRepository.save(movieAction);
		movieRepository.save(movieTerror);

	}

}
