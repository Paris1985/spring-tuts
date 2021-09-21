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
    private IUserService userRepository;

    public List<User> getUsers(String nameRegex) {
        return userRepository.findByNameStartingWith(nameRegex);
    }

    public User getUser(String id)  {
        return userRepository.findById(id);
    }

    public User createUser(User user) throws FoundUserException {
       return userRepository.insert(user);
    }

    public User updateUser(User user) throws UserNotFoundException {
      return userRepository.save(user);
    }


    public User removeUser(String id) throws UserNotFoundException {
       return userRepository.delete(id);
    }
}
