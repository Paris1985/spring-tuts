package service;

import exceptions.FoundUserException;
import exceptions.UserNotFoundException;
import hibernate.repository.UserJpaRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
@Primary
@Component
public class JpaDBImpl implements IUserService{

    @Autowired
    private UserJpaRepository jpaRepository;

    @Override
    public List<User> findByNameStartingWith(String nameRegex) {

        return null;
    }

    @Override
    public User findById(String id) {
        entity.User user = jpaRepository.findById(id).orElse(null);

        if(user == null) return null;
        User userModel = new User();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setAge(user.getAge());

        return userModel;
    }

    @Override
    public User insert(User user) throws FoundUserException {
        entity.User userEntity = new entity.User();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        entity.User save = jpaRepository.save(userEntity);
        return user;
    }

    @Override
    public User save(User user) throws UserNotFoundException {
        entity.User userEntity = new entity.User();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        entity.User save = jpaRepository.save(userEntity);
        return user;
    }

    @Override
    public User delete(String id) throws UserNotFoundException {
        entity.User userEntity = new entity.User();
        userEntity.setId(id);
        jpaRepository.delete(userEntity);
        return new User();
    }
}
