package dao;

import java.util.List;

import javax.ejb.Remote;

import pojo.Artikel;

@Remote
public interface ArtikelDao {

	List<Artikel> findAll();

	Artikel findById(long id);

	List<Artikel> findByName(String name);

	Artikel insert(Artikel artikel) throws Exception;

	Artikel update(Artikel artikel) throws Exception;

	boolean delete(Artikel artikel) throws Exception;

}
