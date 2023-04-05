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

		String genre1 = "Action";
		String genre2 = "Drama";
		String genre3 = "Terror";
		ArrayList<String> movie1 = new ArrayList<String>();
		movie1.add(genre1);
		movie1.add(genre2);
		ArrayList<String> movie2 = new ArrayList<String>();
		movie2.add(genre3);
		Movie movieAction = new Movie(null, "Boca", 100, movie1, "");
		Movie movieTerror = new Movie(null, "River", 100, movie2, "");

		movieRepository.save(movieAction);
		movieRepository.save(movieTerror);

	}

}
