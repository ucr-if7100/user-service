package ucr.gasIn.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.gasIn.userservice.domain.Member;
import ucr.gasIn.userservice.domain.User;
import ucr.gasIn.userservice.dto.MemberDTO;
import ucr.gasIn.userservice.repository.MemberRepository;
import ucr.gasIn.userservice.repository.UserRepository;

import javax.transaction.Transactional;
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


    public List<MemberDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());}

    public void save(MemberDTO memberDTO) {
        for (User user : repositoryUser.findAll()) {
            if (Objects.equals(memberDTO.getEmail(), user.getEmail())) {
                memberDTO.setIdMember(user.getId());
                Member member = convertDtoToEntity(memberDTO);
                repository.save(member);
            }
        }
    }

    public List<MemberDTO> getMembersbyIdAdmin(UUID idAdmin){
        List<MemberDTO> allMembers = listAll();
        List<MemberDTO> filteredMembers = new ArrayList<>();
        for (MemberDTO memberDTO : allMembers) {
            if (memberDTO.getIdAdmin().equals(idAdmin)) {
                filteredMembers.add(memberDTO);
            }
        }
        return filteredMembers;
    }

    private MemberDTO convertEntityToDto(Member member){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(member.getEmail());
        memberDTO.setIdMember(member.getId());
        memberDTO.setIdAdmin(member.getIdAdmin());
        return memberDTO;
    }

    private Member convertDtoToEntity(MemberDTO memberDTO){
        Member member = new Member();
        member.setId(memberDTO.getIdMember());
        member.setEmail(memberDTO.getEmail());
        member.setIdAdmin(memberDTO.getIdAdmin());
        return member;
    }
}
