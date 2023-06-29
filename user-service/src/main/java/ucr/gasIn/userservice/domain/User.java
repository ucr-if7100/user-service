package ucr.gasIn.userservice.domain;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
public class User {
    //Usar nuevos cambios
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)",name ="id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;


    public User(UUID id, String name, String lastname, String email, String username) {
        this.setId(id);
        this.setName(name);
        this.setLastname(lastname);
        this.setEmail(email);
        this.setUsername(username);
    }
    public User(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

