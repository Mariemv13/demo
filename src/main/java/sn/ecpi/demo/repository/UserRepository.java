package sn.ecpi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ecpi.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
