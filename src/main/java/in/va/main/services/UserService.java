package in.va.main.services;

import java.util.List;

import in.va.main.entities.User;


public interface UserService {
	public User createUser(User user);
	public List<User> getUsers();
	public void deleteUser(long id);
}
