package pl.javastart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.javastart.model.User;
import pl.javastart.model.UserRole;
import pl.javastart.repository.UserRepository;
import pl.javastart.repository.UserRoleRepository;

@Service
public class UserService {

	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private UserRoleRepository roleRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setRoleRepository(UserRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public void addWithDefaultRole(User user) {
		UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
		user.getRoles().add(defaultRole);
		userRepository.save(user);
	}
	
}