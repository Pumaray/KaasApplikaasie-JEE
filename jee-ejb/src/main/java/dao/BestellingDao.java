package dao;

import java.util.List;

import javax.ejb.Remote;

import pojo.Bestelling;

@Remote
public interface BestellingDao {

	List<Bestelling> findAll();

	Bestelling findById(long id);

	long insert(Bestelling bestelling) throws Exception;

	long update(Bestelling bestelling) throws Exception;

	void delete(Bestelling bestelling) throws Exception;

}
