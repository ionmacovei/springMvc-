package net.codejava.spring.dao;

import net.codejava.spring.model.Adress;

import java.util.List;

public interface AdressDao extends GenericDao {
    void saveOrUpdateAdress(Adress adress);

    void updateAdress(Adress adress);

    Adress getAdress(int id);

    void deleteAdress(int id);

    List<Adress> getAdress();

    List<String> getNameOfUsers();


}
