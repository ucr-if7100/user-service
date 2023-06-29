package ucr.gasIn.userservice.dto;

import java.util.UUID;

public class MemberDTO {

    private UUID idMember;

    private UUID idAdmin;

    private String email;


    public UUID getIdMember() {
        return idMember;
    }

    public void setIdMember(UUID idMember) {
        this.idMember = idMember;
    }

    public UUID getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(UUID idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
