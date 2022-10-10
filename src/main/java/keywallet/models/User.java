package keywallet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", length = 30, nullable = false)
    private String login;

    @Column(name = "password_hash", length = 512, nullable = false)
    private String passwordHash;

    @Column(name = "salt", length = 20)
    private String salt;

    @Column(name = "isPasswordKeptAsHash")
    private Boolean isPasswordKeptAsHash;

}
