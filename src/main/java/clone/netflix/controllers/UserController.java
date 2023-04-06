package clone.netflix.controllers;

import clone.netflix.dtos.UserDTO;
import clone.netflix.entities.User;
import clone.netflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/v1/user/username={username}")
    public ResponseEntity<UserDTO> findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @PostMapping("/api/v1/user/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/api/v1/user/delete={username}")
    public ResponseEntity<UserDTO> deleteUserByUsername(@PathVariable String username){
        return userService.deleteUserByUsername(username);
    }
}
