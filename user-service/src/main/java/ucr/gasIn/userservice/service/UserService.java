package ucr.gasIn.userservice.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.gasIn.userservice.domain.User;
import ucr.gasIn.userservice.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> listAll() {
        return repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User get(int id_User) {
        return repository.findById(id_User).get();
    }

    public void update(User entity) {
        User entityToUpdate = repository.findById(entity.getId()).get();
        if(entityToUpdate != null) {
            repository.save(entity);
        }
    }
    public void delete(int id) {repository.deleteById(id);
    }


}
