package rest.controllers;

import exceptions.FoundUserException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import exceptions.UserNotFoundException;
import service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{nameRegex}")
    public List<User> getUsers(@PathVariable String nameRegex) {
        return userService.getUsers(nameRegex);
    }
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId)  {
        return userService.getUser(userId);
    }
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create( @RequestBody User user) throws FoundUserException {
        return userService.createUser(user);
    }
    @PutMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public User update( @RequestBody User user) throws UserNotFoundException {
        User updatedUser = userService.updateUser(user);

        return updatedUser;
    }
    @DeleteMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(@PathVariable String userId) throws UserNotFoundException {
        User user = userService.removeUser(userId);
        if(user == null)
            throw new UserNotFoundException("Not Found User " + userId);

    }
}
