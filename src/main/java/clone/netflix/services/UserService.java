package clone.netflix.services;

import clone.netflix.dtos.UserDTO;
import clone.netflix.entities.User;
import clone.netflix.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final PasswordEncoder passwordEncoder;
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<UserDTO> findUserByUsername(String username){
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()){
            log.warn("User doesn't exists");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTOMapper.apply(userOptional.get()));
    }

    public ResponseEntity<UserDTO> deleteUserByUsername(String username){
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()){
            log.warn("User doesn't exists");
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(username);
        return ResponseEntity.ok(userDTOMapper.apply(userOptional.get()));
    }

    public ResponseEntity<UserDTO> createUser(User user){
        if (userRepository.findById(user.getUsername()).isPresent()){
            log.warn("Username has taken");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userDTOMapper.apply(userRepository.save(user)));
    }


}
