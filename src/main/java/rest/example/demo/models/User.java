package rest.example.demo.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @GenericGenerator(
            name = "usersSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "usersSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "usersSequenceGenerator")

    @Column(name = "user_id")
    private Long id;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name="user_email",unique = true)
    private String user_email;
    @Column(name = "date_of_registration")
    private Date date_of_registration;
    @OneToMany(mappedBy = "users")
    private Set<User> users;

    public User(){}
    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }


}
