package service;

import exceptions.FoundUserException;
import exceptions.UserNotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Primary
@Component
public class JdbcDBImpl implements IUserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findByNameStartingWith(String nameRegex) {
        String sql = "select * from users where name like \'" + nameRegex +"%\'";
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User userDto = new User();
                userDto.setId(resultSet.getString("id"));
                userDto.setName(resultSet.getString("name"));
                userDto.setAge(resultSet.getInt("age"));
                return userDto;
            }
        });
        return users;
    }

    @Override
    public User findById(String id) {
        List<User> users = jdbcTemplate.query("select * from users where id = ? ",
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setString(1, id);
                    }
                }, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User userDto = new User();
                        userDto.setId(resultSet.getString("id"));
                        userDto.setName(resultSet.getString("name"));
                        userDto.setAge(resultSet.getInt("age"));
                        return userDto;
                    }
                });
        if(users.isEmpty()) return null;

        return users.get(0);
    }

    @Override
    public User insert(User user) throws FoundUserException {
        String insert = "insert into users (id,name,age) values (?, ?, ?)";
        int rowsInserted = jdbcTemplate.update(insert,new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setInt(3, user.getAge());
            }
        });
        return user;
    }

    @Override
    public User save(User user) throws UserNotFoundException {
        String insert = "update users set name=?, age=? where id = ?";
        int rowsInserted = jdbcTemplate.update(insert,new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {

                preparedStatement.setString(1, user.getName());
                preparedStatement.setInt(2, user.getAge());
                preparedStatement.setString(3, user.getId());
            }
        });
        return user;
    }

    @Override
    public User delete(String id) throws UserNotFoundException {
        User byId = findById(id);
        if(byId==null) return null;

        String delete = "delete from users where id = \'" + byId.getId() +"\'";
        int rowsInserted = jdbcTemplate.update(delete);
        return byId;
    }
}
