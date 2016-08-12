package net.codejava.spring.dao;

import java.util.List;


import net.codejava.spring.model.Adress;

public interface AdressDao  {
	public void saveOrUpdateAdress(Adress adress);
	public void updateAdress(Adress adress);
	public Adress getAdress(int id);
	public void deleteAdress(int id);
	public List<Adress> getAdress();
	public List<String> getNameOfUsers();


}
