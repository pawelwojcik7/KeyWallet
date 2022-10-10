package keywallet.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "password")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="id_user", nullable = false)
    private Integer userId;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="description")
    private String description;

    @Column(name="login", length = 30)
    private String login;

}
