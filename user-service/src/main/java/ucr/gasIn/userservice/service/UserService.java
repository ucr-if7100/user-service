package ucr.gasIn.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.gasIn.userservice.domain.User;
import ucr.gasIn.userservice.dto.UserDTO;
import ucr.gasIn.userservice.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void save(UserDTO userDTO) {
        User user = convertDtoToEntity(userDTO);
        repository.save(user);
    }

    public UserDTO get(UUID idUser) {
        return repository.findById(idUser).map(this::convertEntityToDto).orElse(null);
    }


    public void update(UserDTO userDTO) {
        User user = convertDtoToEntity(userDTO);
        User entityToUpdate = repository.findById(user.getId()).get();
        if(entityToUpdate != null) {
            repository.save(user);
        }
    }
    public void delete(UUID id) {repository.deleteById(id);
    }

    private UserDTO convertEntityToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    private User convertDtoToEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getIdUser());
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        return user;
    }


}
