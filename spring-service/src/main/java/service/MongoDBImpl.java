package service;

import exceptions.FoundUserException;
import exceptions.UserNotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

import java.util.List;

//@Component
public class MongoDBImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    public List<User> findByNameStartingWith(String nameRegex){
        return userRepository.findByNameStartingWith(nameRegex);
    }

    @Override
    public User findById(String id) {
       return userRepository.findById(id).orElse(null);
    }

    @Override
    public User insert(User user) throws FoundUserException {
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        if (foundUser != null)
            throw new FoundUserException("User " + foundUser.getId() + " already in the system");
        else
            return userRepository.insert(user);
    }

    @Override
    public User save(User user) throws UserNotFoundException {
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        if (foundUser != null)
            return userRepository.save(user);
        else
            throw new UserNotFoundException("Not Found User " + user.getId());
    }

    @Override
    public User delete(String id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }else {
            throw new UserNotFoundException("Not Found User " + user.getId());
        }
        return user;
    }
}
