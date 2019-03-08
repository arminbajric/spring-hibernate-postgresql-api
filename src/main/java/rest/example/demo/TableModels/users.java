package rest.example.demo.TableModels;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class users implements Serializable {
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

    @Column(name = "userId")
    private Long userId;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name="email",unique = true)
    private String email;
    @Column(name = "date_of_registration")
    private Date date_of_registration;
    public users(){}
    public users(String username, String password, String email, Date date_of_registration, List<rest.example.demo.TableModels.users> users) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.date_of_registration = date_of_registration;
        this.users = users;
    }
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "users")
    private List<users> users;

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<users> getUsers() {
        return users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_email() {
        return email;
    }

    public void setUser_email(String user_email) {
        this.email = user_email;
    }

    public Date getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(Date date_of_registration) {
        this.date_of_registration = date_of_registration;
    }
    @Override
    public String toString() {
        return "League [id=" + userId + ", email=" + email +",username"+ username+ "]";
    }

}
