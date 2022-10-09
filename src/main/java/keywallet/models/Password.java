package keywallet.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Password {

    private Integer id;
    private String password;
    private Integer userId;
    private String webAddress;
    private String description;
    private String login;

}
