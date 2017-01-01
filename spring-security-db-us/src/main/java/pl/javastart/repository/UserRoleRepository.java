package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.javastart.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}
