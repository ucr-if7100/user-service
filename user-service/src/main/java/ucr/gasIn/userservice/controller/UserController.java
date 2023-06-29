package ucr.gasIn.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.userservice.dto.UserDTO;
import ucr.gasIn.userservice.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/User")
public class UserController {

    @Autowired
    private UserService service;



    @GetMapping("/GetUser")
    public List<UserDTO> list() {
        return service.listAll();
    }

    @GetMapping("/GetUser/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable UUID id) {
        try {
            UserDTO user = service.get(id);
            return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public void add(@RequestBody UserDTO userDTO) {service.save(userDTO);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") UUID id,
                       @RequestBody UserDTO user) {
        UserDTO entity = user;
        entity.setIdUser(id);
        service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
