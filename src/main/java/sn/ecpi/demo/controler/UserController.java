package sn.ecpi.demo.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.ecpi.demo.entity.User;
import sn.ecpi.demo.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.creer(user);
    }

    @GetMapping("/read")
    public List<User> read() {
        return userService.lire();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.modifier(id, user);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id) {
        return userService.supprimer(id);
    }
}
