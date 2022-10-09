package keywallet.DAO;

import keywallet.models.Password;
import keywallet.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class PasswordDAO {

    private final static String SELECT_ALL = "SELECT * FROM password";

    //language=SQL
    private final static String ADD_USER = "INSERT INTO password (password, id_user, web_address, description, login) "+
            "values (?, ?, ?, ?, ?)";

    //language=SQL
    private final static String CHECK_EXIST = "SELECT count(*) FROM password WHERE login = ?";
    private final JdbcTemplate jdbcTemplate;

    public List<Password> getAll(){
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Password.class));
    }

    public void addPassword(Password password){
        jdbcTemplate.update(ADD_USER, preparedStatement -> {
            preparedStatement.setString(1, password.getPassword());
            preparedStatement.setInt(2, password.getUserId());
            preparedStatement.setString(3, password.getWebAddress());
            preparedStatement.setString(4, password.getDescription());
            preparedStatement.setString(5, password.getLogin());
        });
    }

    public Boolean checkUserExist(String login){
        Integer integer = jdbcTemplate.queryForObject(CHECK_EXIST, new Object[]{login}, Integer.class);
        if(integer!=0) return true;
        else return false;
    }


}
