package net.codejava.spring.dao;

	import java.io.Serializable;
	import java.util.Collection;
	import java.util.List;

	public interface GenericDao {

		public <T> T get(Class<T> entity, Serializable id);

		public <T> List<T> get(Class<T> entity);

		public <T> Serializable save(T entity);

		public <T> void saveOrUpdate(T entity);

		public <T> void saveOrUpdate(Collection<T> entities);

		public <T> void refresh(T entity);

		public <T> void delete(T entity);

		public <T> void delete(Collection<T> entities);

	}


