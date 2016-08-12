package net.codejava.spring.dao.impl;

import java.io.Serializable;
import java.util.List;

import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Project;
import net.codejava.spring.model.User;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("userDao")
public class UserDAOImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

      public UserDAOImpl() {
		
	    }
	
	public Session getCurrentSesion(){
    return sessionFactory.getCurrentSession();
    }
	 

	@Override
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		User userToDelete = new User();
		userToDelete= get(id);
		
		if (userToDelete != null){
			userToDelete.setProjects(null);
			sessionFactory.getCurrentSession().update(userToDelete);
		    sessionFactory.getCurrentSession().delete(userToDelete);}
	}

	@Override
	@Transactional
	public User get(Serializable id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	@Override
	@Transactional
	public User getUserWithAdresses(Serializable id){
	User user = get(id);
	Hibernate.initialize(user.getAdresses());
		return user;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsersNotWithTheProject(Integer projectId) {
		
		//String hql = "select distinct us from User us left join fetch us.projects p where p.id != :projectId";
		String hql="select us from User us where us not in (select u from User u join u.projects p where p.id = :projectId)";
		Query query = getCurrentSesion().createQuery(hql);
		query.setParameter("projectId",projectId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getUsersFromProject(Integer projectId) {
		String hql="select distinct u from User u join u.projects p where p.id = :projectId";
		Query query = getCurrentSesion().createQuery(hql);
		query.setParameter("projectId",projectId);
		return query.list();
	}			
}