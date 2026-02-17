package olzhas.nurseit.spring.daos;

import olzhas.nurseit.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//DAO is responsible for talking to the database.
@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;


    //auto injection. done becouse we creaete the bean JdbcTemplate in the springConfig
    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index(){
        return jdbcTemplate.query("SELECT * FROM users",
                new BeanPropertyRowMapper<>(User.class));
    }

    public User show(int id){
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", new BeanPropertyRowMapper<>(User.class),
                id).stream().findAny().orElse(null);
    }

    public void save(User user){
        jdbcTemplate.update(
                "INSERT INTO users (name) VALUES (?)",
                user.getName());
    }

    public void update(int id, User updatedUser){
        jdbcTemplate.update(
                "UPDATE users SET name=? WHERE id=?",
                updatedUser.getName(), id
        );
    }

    public void delete(int id){
        jdbcTemplate.update(
                "DELETE FROM users WHERE id=?",
                id
        );
    }

}
