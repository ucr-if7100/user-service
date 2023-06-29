package ucr.gasIn.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.userservice.dto.MemberDTO;
import ucr.gasIn.userservice.service.MemberService;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/Member")

public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/getMembers/{id}")
    public List<MemberDTO> getMembers(@PathVariable("id") String id) {
        UUID idAdmin = UUID.fromString(id);
        return service.getMembersbyIdAdmin(idAdmin);
    }

    @PostMapping("/insertMember")
    public void addMember(@RequestBody MemberDTO memberDTO) {service.save(memberDTO);
    }

}
