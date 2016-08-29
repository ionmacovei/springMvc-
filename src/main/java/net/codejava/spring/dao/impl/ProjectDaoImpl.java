package net.codejava.spring.dao.impl;

import net.codejava.spring.dao.ProjectDao;
import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Project;
import net.codejava.spring.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository("projectDao")
public class ProjectDaoImpl extends GenericDaoImpl implements ProjectDao {


    @Autowired
    private UserDao userDao;


    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    public Session getCurrentSesion() {
        return getSessionFactory().getCurrentSession();
    }


    @Override
    @Transactional
    public void saveOrUpdateProject(Project project) {
        if (project.getId() != null) {
            List<User> users = userDao.getUsersFromProject(project.getId());
            if (project.getUsers() == null) {

                project.setUsers(users);
            } else {
                users.addAll(project.getUsers());
                project.setUsers(users);
            }

        }
        getCurrentSesion().saveOrUpdate(project);

    }

    @Override
    @Transactional
    public Project getproject(Serializable id) {

        Project p = (Project) getCurrentSesion().get(Project.class, id);
        p.getUsers().size();
        return p;
    }

    @Override
    @Transactional
    public void deleteProject(Serializable id) {
        Project p = getproject(id);
        if (p != null) {
            p.setUsers(null);
            getCurrentSesion().update(p);
            getCurrentSesion().delete(p);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Project> getProjects() {
        return getCurrentSesion().createQuery("from Project").list();
    }

    @Override
    @Transactional
    public Project getProjectWithUsers(Serializable id) {
        Project project = getproject(id);
        Hibernate.initialize(project.getUsers());
        return project;
    }

}
