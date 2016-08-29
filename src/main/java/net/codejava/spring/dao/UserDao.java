package net.codejava.spring.dao;

import net.codejava.spring.model.User;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends GenericDao {
    List<User> list();

    void saveOrUpdate(User user);

    void delete(int id);

    User getUserWithAdresses(Serializable id);

    List<User> getUsersNotWithTheProject(Integer projectId);

    User get(Serializable id);

    List<User> getUsersFromProject(Integer projectId);

    User findByUserName(String username);
}