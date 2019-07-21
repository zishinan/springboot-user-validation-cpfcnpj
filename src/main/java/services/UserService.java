package services;

import domain.User;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User insert(User user) {
        return userRepo.save(user);
    }

    public User fromDTO(UserDto userDto) {
        return new User(userDto.getId(), userDto.getCpfOuCnpj(), userDto.getTipo());
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

}
