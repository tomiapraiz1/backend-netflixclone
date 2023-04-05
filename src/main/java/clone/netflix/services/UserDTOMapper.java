package clone.netflix.services;

import clone.netflix.dtos.UserDTO;
import clone.netflix.entities.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getEmail(),
                user.getGender(),
                user.getAge()
        );
    }
}
