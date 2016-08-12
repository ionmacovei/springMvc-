package net.codejava.spring.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.spring.dao.ProjectDao;
import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Project;
import net.codejava.spring.model.User;

@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDao userDao;

	public ProjectDaoImpl() {
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
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
		getCurrentSession().saveOrUpdate(project);

	}

	@Override
	@Transactional
	public Project getproject(Serializable id) {

		Project p = (Project) getCurrentSession().get(Project.class, id);
		p.getUsers().size();
		return p;
	}

	@Override
	@Transactional
	public void deleteProject(Serializable id) {
		Project p = getproject(id);
		if (p != null){
			p.setUsers(null);
			getCurrentSession().update(p);
			getCurrentSession().delete(p);}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Project> getProjects() {
		return getCurrentSession().createQuery("from Project").list();
	}

	@Override
	@Transactional
	public Project getProjectWithUsers(Serializable id) {
		Project project = getproject(id);
		Hibernate.initialize(project.getUsers());
		return project;
	}

}
