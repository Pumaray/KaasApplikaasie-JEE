package dao;

import java.util.List;

import javax.ejb.Remote;

import pojo.Gebruiker;

@Remote
public interface GebruikerDao {
	
	List<Gebruiker> findAll();

	List<Gebruiker> findById();

	List<Gebruiker> findByName();

	boolean insert(Gebruiker gebruiker);

	boolean update(Gebruiker gebruiker);

	boolean delete(Gebruiker gebruiker);

}
