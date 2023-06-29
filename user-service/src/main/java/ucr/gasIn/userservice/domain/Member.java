package ucr.gasIn.userservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class Member {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)",name ="id")
    private UUID id;
    @Column(columnDefinition = "BINARY(16)",name ="id_admin")
    private UUID idAdmin;
    @Column(name = "email")
    private String email;


    public Member(UUID id, UUID idAdmin, String email) {
        this.setId(id);
        this.setIdAdmin(idAdmin);
        this.setEmail(email);
    }

    public Member() {}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public UUID getIdAdmin() {return idAdmin;}

    public void setIdAdmin(UUID idAdmin) {this.idAdmin = idAdmin;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}