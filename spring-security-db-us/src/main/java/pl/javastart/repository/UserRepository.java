package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.javastart.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
