package net.codejava.spring.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericDao {

    <T> T get(Class<T> entity, Serializable id);

    <T> List<T> get(Class<T> entity);

    <T> Serializable save(T entity);

    <T> void saveOrUpdate(T entity);

    <T> void saveOrUpdate(Collection<T> entities);

    <T> void refresh(T entity);

    <T> void delete(T entity);

    <T> void delete(Collection<T> entities);

}


