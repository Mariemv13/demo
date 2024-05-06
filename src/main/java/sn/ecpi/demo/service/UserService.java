package sn.ecpi.demo.service;

import sn.ecpi.demo.entity.User;

import java.util.List;

public interface UserService {
    User creer(User user);

    List<User> lire();

    User modifier(Long id, User user);

    String supprimer(Long id);
}
