package net.codejava.spring.dao;

import java.io.Serializable;
import java.util.List;

import net.codejava.spring.model.User;

public interface UserDao {
	public List<User> list();

	public void saveOrUpdate(User user);

	public void delete(int id);

	public User getUserWithAdresses(Serializable id);

	public List<User> getUsersNotWithTheProject(Integer projectId);

	public User get(Serializable id);
	
	public List<User> getUsersFromProject(Integer projectId);
}