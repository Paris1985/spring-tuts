package service;

import exceptions.FoundUserException;
import exceptions.UserNotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(String nameRegex) {
        return userRepository.findByNameStartingWith(nameRegex);
    }

    public User getUser(String id)  {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) throws FoundUserException {
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        if (foundUser != null)
            throw new FoundUserException("User " + foundUser.getId() + " already in the system");
        else
            return userRepository.insert(user);
    }

    public User updateUser(User user) throws UserNotFoundException {
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        if (foundUser != null)
            return userRepository.save(user);
        else
            throw new UserNotFoundException("Not Found User " + user.getId());
    }


    public User removeUser(String id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }else {
            throw new UserNotFoundException("Not Found User " + user.getId());
        }
        return user;
    }
}
