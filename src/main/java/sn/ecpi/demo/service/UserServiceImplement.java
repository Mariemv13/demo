package sn.ecpi.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.ecpi.demo.entity.User;
import sn.ecpi.demo.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User modifier(Long id, User user) {
        return userRepository.findById(id)
                .map(p-> {
                    p.setUsername(user.getUsername());
                    p.setFirstname(user.getFirstname());
                    p.setLastname(user.getLastname());
                    p.setPassword(user.getPassword());
                    p.setId(user.getId());
                    return userRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("User non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        userRepository.deleteById(id);
        return "User supprimé !";
    }
}
