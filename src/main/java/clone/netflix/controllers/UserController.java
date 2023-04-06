package clone.netflix.controllers;

import clone.netflix.dtos.UserDTO;
import clone.netflix.entities.User;
import clone.netflix.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users", description = "Users management APIs")

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Retrieve a User by username",
            description = "Get a User object by specifying its username. The response is UserDTO object with username, email, gender and age.",
            tags = { "user", "get" })
    @GetMapping("/api/v1/user/username={username}")
    public ResponseEntity<UserDTO> findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @Operation(
            summary = "Create a User using JSON format",
            description = "Create a User object by specifying its username, password, email, name, gender and age in JSON format. The response is UserDTO object with username, email, gender and age.",
            tags = { "user", "post" })
    @PostMapping("/api/v1/user/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @Operation(
            summary = "Delete a User by username",
            description = "Delete a User object by specifying its username. The response is UserDTO object with username, email, gender and age.",
            tags = { "user", "delete" })
    @DeleteMapping("/api/v1/user/delete={username}")
    public ResponseEntity<UserDTO> deleteUserByUsername(@PathVariable String username){
        return userService.deleteUserByUsername(username);
    }
}
