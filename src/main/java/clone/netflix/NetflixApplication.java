package clone.netflix;

import clone.netflix.entities.Movie;
import clone.netflix.entities.User;
import clone.netflix.repositories.MovieRepository;
import clone.netflix.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NetflixApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(NetflixApplication.class, args);
		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);

		List<String> genre1 = new ArrayList<String>();
		genre1.add("Action");
		genre1.add("Drama");
		List<String> genre2 = new ArrayList<String>();
		genre2.add("Terror");
		Movie movieAction = new Movie(null, "Boca River", 100, genre1, "");
		Movie movieTerror = new Movie(null, "River", 100, genre2, "");

		movieRepository.save(movieAction);
		movieRepository.save(movieTerror);

		User user = new User("tomi", passwordEncoder.encode("213"), "", "Thomas", "male", 23);
		userRepository.save(user);

	}

}
