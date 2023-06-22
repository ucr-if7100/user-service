package ucr.gasIn.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.userservice.domain.Member;
import ucr.gasIn.userservice.dto.UserDTO;
import ucr.gasIn.userservice.repository.MemberRepository;
import ucr.gasIn.userservice.service.MemberService;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/Member")

public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/getMembers/{id}")
    public List<Member> getMembers(@PathVariable("id") String id) {
        UUID idAdmin = UUID.fromString(id);
        return service.getMembersbyIdAdmin(idAdmin);
    }

    @PostMapping("/insertMember")
    public void addMember(@RequestBody Member member) {service.saveMember(member);
    }

}
