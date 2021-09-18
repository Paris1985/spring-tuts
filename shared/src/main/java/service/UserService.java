package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(String nameRegex);

    User getUser(String id);

    User createUser(User user);

    User updateUser(User user);

    User removeUser(String id);

}
