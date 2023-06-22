package ucr.gasIn.userservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.gasIn.userservice.domain.Member;
import ucr.gasIn.userservice.domain.User;
import ucr.gasIn.userservice.dto.UserDTO;
import ucr.gasIn.userservice.repository.MemberRepository;
import ucr.gasIn.userservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private UserRepository repositoryUser;


    public List<Member> listAll() {
        return repository.findAll();}

    public void saveMember(Member member) {
        for (User user : repositoryUser.findAll()) {
            if (Objects.equals(member.getEmail(), user.getEmail())) {
                member.setId(user.getId());
                repository.save(member);
            }
        }
    }

    public List<Member> getMembersbyIdAdmin(UUID idAdmin){
        List<Member> allMembers = listAll();
        List<Member> filteredMembers = new ArrayList<>();
        for (Member member : allMembers) {
            if (member.getIdAdmin().equals(idAdmin)) {
                filteredMembers.add(member);
            }
        }
        return filteredMembers;
    }
}
