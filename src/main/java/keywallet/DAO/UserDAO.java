package keywallet.DAO;

import keywallet.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    //language=SQL
    private final static String SELECT_ALL = "SELECT * FROM user";

    //language=SQL
    private final static String ADD_USER = "INSERT INTO USER (login, password_hash, salt, isPasswordKeptAsHash) "+
            "values (?, ?, ?, ?)";

    //language=SQL
    private final static String CHECK_EXIST = "SELECT count(*) FROM user WHERE login = ?";
    private final JdbcTemplate jdbcTemplate;

    public List<User> getAll(){
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(User.class));
    }

    public void addUser(User user){
        jdbcTemplate.update(ADD_USER, preparedStatement -> {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword_hash());
            preparedStatement.setString(3, user.getSalt());
            preparedStatement.setBoolean(4, user.getIsPasswordKeptAsHash());
        });
    }

    public Boolean checkUserExist(String login){
        Integer integer = jdbcTemplate.queryForObject(CHECK_EXIST, new Object[]{login}, Integer.class);
        if(integer!=0) return true;
        else return false;
    }

}
