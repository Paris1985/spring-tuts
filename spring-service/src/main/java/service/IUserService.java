package service;

import exceptions.FoundUserException;
import exceptions.UserNotFoundException;
import model.User;

import java.util.List;

public interface IUserService {

    List<User> findByNameStartingWith(String nameRegex);
    User findById(String id);
    User insert(User user) throws FoundUserException;
    User save(User user) throws UserNotFoundException;
    User delete(String id) throws UserNotFoundException;
}
