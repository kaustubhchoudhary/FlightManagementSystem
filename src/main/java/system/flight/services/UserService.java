package system.flight.services;

import system.flight.dto.CreateUserDTO;
import system.flight.dto.CreateUserResponseDTO;
import system.flight.dto.UserProfileDTO;
import system.flight.dto.UserProfileResponseDTO;
import system.flight.entities.User;

import java.util.List;

public interface UserService {

	public CreateUserResponseDTO registerUser(CreateUserDTO dto) throws IllegalArgumentException;

	public User getUserById(int userId);

	public List<User> getAllUsers();

	public UserProfileResponseDTO updateUserProfile(int userId, UserProfileDTO dto);

	public void deleteUserById(int userId);

	public User getUserByUsername(String username);

	public User getCurrentAuthenticatedUser();

}
