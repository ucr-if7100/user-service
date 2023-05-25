package ucr.gasIn.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.userservice.domain.User;
import ucr.gasIn.userservice.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/User")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/GetUser")
    public List<User> list() {
        return service.listAll();
    }

    @GetMapping("/GetUser/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = service.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody User user) {service.save(user);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") int id,
                       @RequestBody User user) {
        User entity = user;
        //entity.setId_User(id);
        service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
