package net.codejava.spring.dao.impl;

import net.codejava.spring.dao.AdressDao;
import net.codejava.spring.model.Adress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("adressDao")
public class AdressDaoImpl extends GenericDaoImpl implements AdressDao {

    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    public Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }

    @Override
    @Transactional
    public void saveOrUpdateAdress(Adress adress) {
        getCurrentSession().saveOrUpdate(adress);

    }

    @Override
    public void updateAdress(Adress adress) {
        Adress adressToUpdate = getAdress(adress.getId());
        adressToUpdate.setStreet(adress.getStreet());
        adressToUpdate.setCity(adress.getCity());
        adressToUpdate.setCountury(adress.getCountury());
        adressToUpdate.setUser(adress.getUser());
        getCurrentSession().update(adressToUpdate);

    }

    @Override
    @Transactional
    public Adress getAdress(int id) {
        Adress adress = (Adress) getCurrentSession().get(Adress.class, id);
        return adress;

    }

    @Override
    @Transactional
    public void deleteAdress(int id) {
        Adress adress = getAdress(id);
        if (adress != null)
            getCurrentSession().delete(adress);

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Adress> getAdress() {

        return getCurrentSession().createQuery("from Adress").list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<String> getNameOfUsers() {
        return getCurrentSession().createQuery("SELECT U.username FROM User U").list();
    }


}
