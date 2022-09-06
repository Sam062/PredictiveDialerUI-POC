package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.User;

public interface UserRegisterRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
